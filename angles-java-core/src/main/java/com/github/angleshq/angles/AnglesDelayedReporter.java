package com.github.angleshq.angles;

import com.github.angleshq.angles.api.exceptions.AnglesServerException;
import com.github.angleshq.angles.api.models.build.Artifact;
import com.github.angleshq.angles.api.models.build.Build;
import com.github.angleshq.angles.api.models.build.CreateBuild;
import com.github.angleshq.angles.api.models.screenshot.Screenshot;
import com.github.angleshq.angles.api.models.screenshot.ScreenshotDetails;
import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AnglesDelayedReporter extends AnglesReporter implements AnglesReporterInterface {

    protected InheritableThreadLocal<CreateBuild> currentCreateBuildRequest = new InheritableThreadLocal<>();

    public AnglesDelayedReporter(String baseUrl) {
        super(baseUrl);
    }

    public void startBuild(String name, String environmentName, String teamName, String componentName, String phase) {
        if (currentCreateBuildRequest.get() != null) {
            return;
        }
        CreateBuild createBuild = createBuild(name, environmentName, teamName, componentName, phase);
        currentCreateBuildRequest.set(createBuild);
    }

    /**
     * This method will save the store build
     */
    @Override
    public void saveBuild() {
        try {
            Build build = buildRequests.create(this.currentCreateBuildRequest.get());
            System.out.println(build.getId() + ": " + build.toString());
        }  catch (IOException | AnglesServerException exception) {
            throw new Error("Unable to save build due to [" + exception.getMessage() + "]");
        }
    }

    @Override
    public void storeArtifacts(Artifact[] artifacts) {
        this.currentCreateBuildRequest.get().setArtifacts(Arrays.asList(artifacts));
    }

    @Override
    public void startSuite(String suiteName) {
        super.startSuite(suiteName);
        this.currentCreateBuildRequest.get().addSuite(this.currentSuite.get());
    }

    @Override
    public void startTest(String suiteName, String testName, String feature, List<String> tags) {
        super.startTest(suiteName, testName, feature, tags);
    }

    /**
     * Delayed reporter does not support screenshots.
     * @param details
     * @return
     */
    public Screenshot storeScreenshot(ScreenshotDetails details) {
        Screenshot screenshot = new Screenshot();
        screenshot.setId(null);
        return screenshot;
    }

    @Override
    public void saveTest() {
        // do nothing.
        if (currentExecution.get() != null) {
            this.currentSuite.get().getExecutions().add(SerializationUtils.clone(this.currentExecution.get()));
            currentExecution.set(null);
        }
    }

}
