package com.github.angleshq.angles;

import com.github.angleshq.angles.api.models.Platform;
import com.github.angleshq.angles.api.models.attachment.TestAttachment;
import com.github.angleshq.angles.api.models.build.Artifact;
import com.github.angleshq.angles.api.models.screenshot.ImageCompareResponse;
import com.github.angleshq.angles.api.models.screenshot.Screenshot;
import com.github.angleshq.angles.api.models.screenshot.ScreenshotDetails;

import java.io.File;
import java.util.List;

public interface AnglesReporterInterface {

    void setApiKey(String apiKey);

    void startBuild(String name, String environmentName, String teamName, String componentName);

    void startBuild(String name, String environmentName, String teamName, String componentName, String phaseName);

    void storeArtifacts(Artifact[] artifacts);

    void startTest(String suiteName, String testName);

    void updateTestName(String testName);

    void startTest(String suiteName, String testName, String feature);

    void startTest(String suiteName, String testName, String feature, List<String> tags);

    void saveTest();

    void setBatchMode(boolean batchMode);

    void saveAllTests();

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

    /**
     * Uploads a file and attaches it to the current test: a video, a Playwright trace, a HAR
     * file, a console log and so on. The extension decides how Angles shows it: .log/.txt,
     * .json, .har, .webm/.mp4, .zip (a trace when the name contains "trace"), .html/.htm,
     * or an image.
     */
    TestAttachment attachFile(File file);

    /** As {@link #attachFile(File)}, shown under {@code fileName} (keep the extension). */
    TestAttachment attachFile(File file, String fileName);

    /** Attaches in-memory content to the current test. The extension of {@code fileName} decides how it is shown. */
    TestAttachment attachData(byte[] data, String fileName);

    /** Uploads a file and attaches it to the most recent step, e.g. the page HTML when an assertion failed. */
    TestAttachment attachFileToLastStep(File file);

    /** As {@link #attachFileToLastStep(File)}, shown under {@code fileName} (keep the extension). */
    TestAttachment attachFileToLastStep(File file, String fileName);

    /** Attaches in-memory content to the most recent step, e.g. {@code driver.getPageSource()} as "page.html". */
    TestAttachment attachDataToLastStep(byte[] data, String fileName);
}
