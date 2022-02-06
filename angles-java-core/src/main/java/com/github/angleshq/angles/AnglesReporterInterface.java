package com.github.angleshq.angles;

import com.github.angleshq.angles.api.models.Platform;
import com.github.angleshq.angles.api.models.build.Artifact;
import com.github.angleshq.angles.api.models.screenshot.ImageCompareResponse;
import com.github.angleshq.angles.api.models.screenshot.Screenshot;
import com.github.angleshq.angles.api.models.screenshot.ScreenshotDetails;

import java.util.List;

public interface AnglesReporterInterface {

    void startBuild(String name, String environmentName, String teamName, String componentName);

    void startBuild(String name, String environmentName, String teamName, String componentName, String phaseName);

    void saveBuild();

    void storeArtifacts(Artifact[] artifacts);

    void startSuite(String suiteName);

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

    String getBuildId();

    Screenshot storeScreenshot(ScreenshotDetails details);

    ImageCompareResponse compareScreenshotAgainstBaseline(String screenshotId);
}
