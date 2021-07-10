package angles;

import angles.api.models.Platform;
import angles.api.models.build.Artifact;
import angles.api.models.screenshot.ImageCompareResponse;
import angles.api.models.screenshot.Screenshot;
import angles.api.models.screenshot.ScreenshotDetails;

import java.util.List;

public interface AnglesReporterInterface {

    void startBuild(String name, String environmentName, String teamName, String componentName);

    void storeArtifacts(Artifact[] artifacts);

    void startTest(String suiteName, String testName);

    void updateTestName(String testName);

    void startTest(String suiteName, String testName, String feature);

    void startTest(String suiteName, String testName, String feature, List<String> tags);

    void saveTest();

    void storePlatformDetails(Platform... platform);

    void startAction(String description);

    void debug(String debug);

    void debug(String debug, String screenshotId);

    void error(String error);

    void error(String error, String screenshotId);

    void info(String info);

    void info(String info, String screenshotId);

    void pass(String name, String expected, String actual, String info);

    void pass(String name, String expected, String actual, String info, String screenshotId);

    void fail(String name, String expected, String actual, String info);

    void fail(String name, String expected, String actual, String info, String screenshotId);

    Screenshot storeScreenshot(ScreenshotDetails details);

    ImageCompareResponse compareScreenshotAgainstBaseline(String screenshotId);
}
