package com.github.angleshq.angles;

import com.github.angleshq.angles.api.exceptions.AnglesServerException;
import com.github.angleshq.angles.api.models.Platform;
import com.github.angleshq.angles.api.models.build.Artifact;
import com.github.angleshq.angles.api.models.build.Build;
import com.github.angleshq.angles.api.models.build.CreateBuild;
import com.github.angleshq.angles.api.models.execution.Action;
import com.github.angleshq.angles.api.models.execution.CreateExecution;
import com.github.angleshq.angles.api.models.execution.Step;
import com.github.angleshq.angles.api.models.screenshot.*;
import com.github.angleshq.angles.api.requests.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnglesReporter implements AnglesReporterInterface {

    public static final String DEFAULT_ACTION_NAME = "Test Details";
    public static final String EMPTY_REPORTER_NAME = "empty";
    private static Map<String, AnglesReporterInterface> reporterMap = new HashMap<>();
    private static boolean enabled = true;
    private String baseUrl;
    private BuildRequests buildRequests;
    private ExecutionRequests executionRequests;
    private EnvironmentRequests environmentRequests;
    private TeamRequests teamRequests;
    private ScreenshotRequests screenshotRequests;

    private InheritableThreadLocal<Build> currentBuild = new InheritableThreadLocal<>();
    private InheritableThreadLocal<CreateExecution> currentExecution = new InheritableThreadLocal<>();
    private InheritableThreadLocal<Action> currentAction = new InheritableThreadLocal<>();
    private ThreadLocal<Action> setUpAction = new InheritableThreadLocal<>();

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
            AnglesReporter.reporterMap.put(url, new AnglesReporter(url));
        }
        return AnglesReporter.reporterMap.get(url);
    }

    private AnglesReporter(String url) {
        this.baseUrl = url;
        buildRequests = new BuildRequests(baseUrl);
        executionRequests = new ExecutionRequests(baseUrl);
        environmentRequests = new EnvironmentRequests(baseUrl);
        teamRequests = new TeamRequests(baseUrl);
        screenshotRequests = new ScreenshotRequests(baseUrl);
    }

    public synchronized void startBuild(String name, String environmentName, String teamName, String componentName) {
        if (currentBuild.get() != null) {
            return;
        }
        CreateBuild createBuild = new CreateBuild();
        createBuild.setName(name);
        createBuild.setEnvironment(environmentName);
        createBuild.setTeam(teamName);
        createBuild.setComponent(componentName);
        createBuild.setStart(new Date());
        try {
            currentBuild.set(buildRequests.create(createBuild));
        } catch (IOException | AnglesServerException exception) {
            throw new Error("Unable to create build due to [" + exception.getMessage() + "]");
        }
    }

    public synchronized void storeArtifacts(Artifact[] artifacts) {
        try {
            currentBuild.set(buildRequests.artifacts(currentBuild.get().getId(), artifacts));
        } catch (IOException | AnglesServerException exception) {
            throw new Error("Unable to store build artifacts due to [" + exception.getMessage() + "]");
        }
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

    public void startTest(String suiteName, String testName, String feature, List<String> tags) {
        CreateExecution createExecution = new CreateExecution();
        createExecution.setStart(new Date());
        createExecution.setBuild(currentBuild.get().getId());
        createExecution.setTitle(testName);
        createExecution.setSuite(suiteName);
        createExecution.setFeature(feature);
        createExecution.setTags(tags);
        currentExecution.set(createExecution);
        if (setUpAction.get() != null) {
            // TODO: handle suite setup
            // currentExecution.get().addAction(setUpAction.get());
            setUpAction.set(null);
        }
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
        currentExecution.get().addPlatform(platform);
    }

    public void startAction(String description) {
        this.currentAction.set(new Action(description));
        this.currentExecution.get().getActions().add(this.currentAction.get());
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

    private void addStep(String name, String expected, String actual, String info, StepStatus status, String screenshotId) {
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
        // scenarios, 1. pre logs, 2. no action
        if (currentExecution.get() == null) {
            // test hasn't started yet (or maybe it has finished).
            if (setUpAction.get() == null) {
                this.setUpAction.set(new Action("Test-Setup"));
            }
            setUpAction.get().addStep(step);
        } else {
            // test has started
            if (currentAction.get() == null) {
                startAction(DEFAULT_ACTION_NAME);
            }
            currentAction.get().addStep(step);
        }
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

}
