package com.github.angleshq.angles;

import com.github.angleshq.angles.api.exceptions.AnglesServerException;
import com.github.angleshq.angles.api.models.Platform;
import com.github.angleshq.angles.api.models.build.Artifact;
import com.github.angleshq.angles.api.models.build.Build;
import com.github.angleshq.angles.api.models.build.CreateBuild;
import com.github.angleshq.angles.api.models.build.Suite;
import com.github.angleshq.angles.api.models.execution.Action;
import com.github.angleshq.angles.api.models.execution.CreateExecution;
import com.github.angleshq.angles.api.models.execution.Step;
import com.github.angleshq.angles.api.models.screenshot.CreateScreenshot;
import com.github.angleshq.angles.api.models.screenshot.ImageCompareResponse;
import com.github.angleshq.angles.api.models.screenshot.Screenshot;
import com.github.angleshq.angles.api.models.screenshot.ScreenshotDetails;
import com.github.angleshq.angles.api.requests.*;

import java.io.IOException;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class AnglesReporter implements AnglesReporterInterface {

    public static final String DEFAULT_ACTION_NAME = "Test Details";
    public static final String EMPTY_REPORTER_NAME = "empty";

    private static Map<String, AnglesReporterInterface> reporterMap = new HashMap<>();
    private static boolean enabled = true;
    private static boolean delayedReporting = true;

    protected String baseUrl;
    protected BuildRequests buildRequests;
    private ExecutionRequests executionRequests;
    private ScreenshotRequests screenshotRequests;

    protected InheritableThreadLocal<Build> currentBuild = new InheritableThreadLocal<>();
    protected InheritableThreadLocal<CreateExecution> currentExecution = new InheritableThreadLocal<>();
    protected InheritableThreadLocal<Action> currentAction = new InheritableThreadLocal<>();
    protected InheritableThreadLocal<Suite> currentSuite = new InheritableThreadLocal<>();

    public static AnglesReporterInterface getInstance(String url) {
        // if angles is disabled, return the empty reporter
        if (!enabled) {
            if (!AnglesReporter.reporterMap.containsKey(EMPTY_REPORTER_NAME)) {
                AnglesReporter.reporterMap.put(EMPTY_REPORTER_NAME, new AnglesReporterEmpty());
            }
            return AnglesReporter.reporterMap.get(EMPTY_REPORTER_NAME);
        }

        // if not disabled then return the reporter.
        if (!AnglesReporter.reporterMap.containsKey(url)) {
            if (delayedReporting) {
                AnglesReporter.reporterMap.put(url, new AnglesDelayedReporter(url));
            } else {
                AnglesReporter.reporterMap.put(url, new AnglesReporter(url));
            }
        }
        return AnglesReporter.reporterMap.get(url);
    }

    protected AnglesReporter(String url) {
        this.baseUrl = url;
        buildRequests = new BuildRequests(baseUrl);
        executionRequests = new ExecutionRequests(baseUrl);
        screenshotRequests = new ScreenshotRequests(baseUrl);
    }

    protected CreateBuild createBuild(String name, String environmentName, String teamName, String componentName, String phase) {
        CreateBuild createBuild = new CreateBuild();
        createBuild.setName(name);
        createBuild.setEnvironment(environmentName);
        createBuild.setTeam(teamName);
        createBuild.setComponent(componentName);
        createBuild.setStart(new Date());
        if (!isBlank(phase))
            createBuild.setPhase(phase);
        return createBuild;
    }

    protected CreateExecution createExecution(String suiteName, String testName, String feature, List<String> tags) {
        CreateExecution createExecution = new CreateExecution();
        createExecution.setStart(new Date());
        if (currentBuild.get() != null)
            createExecution.setBuild(currentBuild.get().getId());
        createExecution.setTitle(testName);
        createExecution.setSuite(suiteName);
        createExecution.setFeature(feature);
        createExecution.setTags(tags);
        return createExecution;
    }

    protected Suite createSuite(String suiteName) {
        Suite suite = new Suite();
        suite.setName(suiteName);
        CreateExecution setupExecution = createExecution("Suite Setup", suiteName, null, null);
        this.currentExecution.set(setupExecution);
        suite.setSetup(setupExecution);
        return suite;
    }

    public synchronized void startBuild(String name, String environmentName, String teamName, String componentName) {
        startBuild(name, environmentName, teamName, componentName, null);
    }

    public void saveBuild() {
        // do nothing;
    }

    public synchronized void startBuild(String name, String environmentName, String teamName, String componentName, String phase) {
        if (currentBuild.get() != null) {
            return;
        }
        CreateBuild createBuild = createBuild(name, environmentName, teamName, componentName, phase);
        try {
            currentBuild.set(buildRequests.create(createBuild));
        } catch (IOException | AnglesServerException exception) {
            throw new Error("Unable to create build due to [" + exception.getMessage() + "]");
        }
    }

    public synchronized void storeArtifacts(Artifact[] artifacts) {
        if (currentBuild.get().getArtifacts().size() == 0) {
            try {
                currentBuild.set(buildRequests.artifacts(currentBuild.get().getId(), artifacts));
            } catch (IOException | AnglesServerException exception) {
                throw new Error("Unable to store build artifacts due to [" + exception.getMessage() + "]");
            }
        }
    }

    public void startSuite(String suiteName) {
        this.currentSuite.set(createSuite(suiteName));
    }

    public void startTest(String suiteName, String testName) {
        startTest(suiteName, testName, null, null);
    }

    public void updateTestName(String testName) {
        currentExecution.get().setTitle(testName);
    }

    public void startTest(String suiteName, String testName, String feature) {
        startTest(suiteName, testName, feature, null);
    }

    public synchronized void startTest(String suiteName, String testName, String feature, List<String> tags) {
        if (this.currentSuite.get() == null) {
            startSuite(suiteName);
        }
        currentExecution.set(createExecution(suiteName, testName, feature, tags));
        currentAction.set(null);
    }

    public void saveTest() {
        try {
            if (currentExecution.get() != null) {
                executionRequests.create(currentExecution.get());
                currentExecution.set(null);
            }
        }  catch (IOException | AnglesServerException exception) {
            throw new Error("Unable to save/update test execution due to [" + exception.getMessage() + "]");
        }
    }

    public void storePlatformDetails(Platform... platform) {
        if (currentExecution.get() != null) {
            currentExecution.get().addPlatform(platform);
        }
    }

    public void startAction(String description) {
        this.currentAction.set(new Action(description));
        if (currentExecution.get() == null) {
            if (this.currentSuite.get() != null) {
                this.currentSuite.get().getSetup().addAction(this.currentAction.get());
            }
        } else {
            this.currentExecution.get().getActions().add(this.currentAction.get());
        }
    }

    public void debug(String debug) {
        addStep("debug", null, null, debug, StepStatus.DEBUG, null);
    }

    public void debug(String debug, String screenshotId) {
        addStep("debug", null, null, debug, StepStatus.DEBUG, screenshotId);
    }

    public void error(String error) {
        addStep("error", null, null, error, StepStatus.ERROR, null);
    }

    public void error(String error, String screenshotId) {
        addStep("error", null, null, error, StepStatus.ERROR, screenshotId);
    }

    public void info(String info) {
        addStep("info", null, null, info, StepStatus.INFO, null);
    }

    public void info(String info, String screenshotId) {
        addStep("info", null, null, info, StepStatus.INFO, screenshotId);
    }

    public void pass(String name, String expected, String actual, String info) {
        addStep(name, expected, actual, info, StepStatus.PASS, null);
    }

    public void pass(String name, String expected, String actual, String info, String screenshotId) {
        addStep(name, expected, actual, info, StepStatus.PASS, screenshotId);
    }

    public void fail(String name, String expected, String actual, String info) {
        addStep(name, expected, actual, info, StepStatus.FAIL);
    }

    public void fail(String name, String expected, String actual, String info, String screenshotId) {
        addStep(name, expected, actual, info, StepStatus.FAIL, screenshotId);
    }

    private void addStep(String name, String expected, String actual, String info, StepStatus status) {
        addStep(name, expected, actual, info, status, null);
    }

    protected void addStep(String name, String expected, String actual, String info, StepStatus status, String screenshotId) {
        Step step = new Step();
        step.setTimestamp(new Date());
        step.setStatus(status);
        step.setName(name);
        step.setExpected(expected);
        step.setActual(actual);
        step.setInfo(info);
        if (screenshotId !=null) {
            step.setScreenshot(screenshotId);
        }

        // test has started
        if (currentAction.get() == null) {
            startAction(DEFAULT_ACTION_NAME);
        }
        currentAction.get().addStep(step);
    }

    public Screenshot storeScreenshot(ScreenshotDetails details) {
        CreateScreenshot createScreenshot = new CreateScreenshot();
        createScreenshot.setBuildId(currentBuild.get().getId());
        createScreenshot.setTimestamp(new Date());
        createScreenshot.setView(details.getView());
        createScreenshot.setFilePath(details.getPath());
        createScreenshot.setPlatform(details.getPlatform());
        createScreenshot.setTags(details.getTags());
        try {
            Screenshot response = screenshotRequests.create(createScreenshot);
            return response;
        } catch (IOException | AnglesServerException exception) {
            throw new Error("Unable store screenshot due to [" + exception.getMessage() + "]");
        }
    }

    public ImageCompareResponse compareScreenshotAgainstBaseline(String screenshotId) {
        try {
            return screenshotRequests.baselineCompare(screenshotId);
        } catch (IOException exception) {
            throw new Error("Unable compare screenshot with baseline due to [" + exception.getMessage() + "]");
        } catch (AnglesServerException exception) {
            if (exception.getHttpStatusCode().equals(404) && exception.getMessage().contains("No baselines")) {
                // if baseline not set
                info("Unable to compare screenshot [" + screenshotId + "] against baseline as it has not been set. Please set a baseline using the Angles UI.");
            } else {
                throw new Error("Unable compare screenshot with baseline due to [" + exception.getMessage() + "]");
            }
        }
        return null;
    }

    public String getBuildId() {
        if (this.currentBuild.get() != null) {
            return this.currentBuild.get().getId();
        }
        return null;
    }

    /**
     * This method allows you to disable angles (in case you wanted to have a local run).
     *
     * @param enabled e.g. false to disable reporting to angles (and you will get an empty reporter).
     */
    public static void setEnabled(boolean enabled) {
        AnglesReporter.enabled = enabled;
    }

    public static boolean isEnabled() {
        return AnglesReporter.enabled;
    }

    /**
     * By setting this variable the Angles client will only send a single request to store the build (when saveBuild
     * is called). This is useful for e.g. Unit tests who don't want to be delayed by the additional before/after tests
     * calls to Angles.
     *
     * @param delayedReporting
     */
    public static void setDelayedReporting(boolean delayedReporting) {
        AnglesReporter.delayedReporting = delayedReporting;
    }

    public static boolean isDelayedReporting() {
        return delayedReporting;
    }

}
