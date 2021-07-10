package angles;

import angles.api.models.Platform;
import angles.api.models.build.Artifact;
import angles.api.models.screenshot.ImageCompareResponse;
import angles.api.models.screenshot.Screenshot;
import angles.api.models.screenshot.ScreenshotDetails;

import java.util.List;

public class AnglesReporterEmpty implements AnglesReporterInterface {

    public AnglesReporterEmpty() {
        // do nothing
    }

    public void startBuild(String name, String environmentName, String teamName, String componentName) {
        // do nothing
    }

    public void storeArtifacts(Artifact[] artifacts) {
        // do nothing
    }

    public void startTest(String suiteName, String testName) {
        // do nothing
    }

    public void updateTestName(String testName) {
        // do nothing.
    }

    public void startTest(String suiteName, String testName, String feature) {
        // do nothing
    }

    public void startTest(String suiteName, String testName, String feature, List<String> tags) {
        // do nothing.
    }

    public void saveTest() {
        // do nothing.
    }

    public void storePlatformDetails(Platform... platform) {
        // do nothing
    }

    public void startAction(String description) {
        // do nothing
    }

    public void debug(String debug) {
        // do nothing
    }

    public void debug(String debug, String screenshotId) {
        // do nothing
    }

    public void error(String error) {
        // do nothing
    }

    public void error(String error, String screenshotId) {
        // do nothing
    }

    public void info(String info) {
        // do nothing
    }

    public void info(String info, String screenshotId) {
        // do nothing
    }

    public void pass(String name, String expected, String actual, String info) {
        // do nothing
    }

    public void pass(String name, String expected, String actual, String info, String screenshotId) {
        // do nothing
    }

    public void fail(String name, String expected, String actual, String info) {
        // do nothing
    }

    public void fail(String name, String expected, String actual, String info, String screenshotId) {
        // do nothing
    }

    private void addStep(String name, String expected, String actual, String info, StepStatus status) {
        // do nothing
    }

    public Screenshot storeScreenshot(ScreenshotDetails details) {
        // do nothing
        return null;
    }

    public ImageCompareResponse compareScreenshotAgainstBaseline(String screenshotId) {
        // do nothing
        return null;
    }
}
