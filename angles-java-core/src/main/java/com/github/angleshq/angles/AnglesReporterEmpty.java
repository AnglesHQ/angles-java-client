package com.github.angleshq.angles;

import com.github.angleshq.angles.api.models.Platform;
import com.github.angleshq.angles.api.models.attachment.TestAttachment;
import com.github.angleshq.angles.api.models.build.Artifact;
import com.github.angleshq.angles.api.models.screenshot.ImageCompareResponse;
import com.github.angleshq.angles.api.models.screenshot.Screenshot;
import com.github.angleshq.angles.api.models.screenshot.ScreenshotDetails;

import java.io.File;
import java.util.List;

public class AnglesReporterEmpty implements AnglesReporterInterface {

    public AnglesReporterEmpty() {
        // do nothing
    }

    public void setApiKey(String apiKey) {
        // do nothing
    }

    public void startBuild(String name, String environmentName, String teamName, String componentName) {
        // do nothing
    }

    public void startBuild(String name, String environmentName, String teamName, String componentName, String phaseName) {
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

    public void setBatchMode(boolean batchMode) {
        // do nothing.
    }

    public void saveAllTests() {
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

    public String getBuildId() {
        // do nothing
        return null;
    }

    public TestAttachment attachFile(File file) {
        // do nothing
        return null;
    }

    public TestAttachment attachFile(File file, String fileName) {
        // do nothing
        return null;
    }

    public TestAttachment attachData(byte[] data, String fileName) {
        // do nothing
        return null;
    }

    public TestAttachment attachFileToLastStep(File file) {
        // do nothing
        return null;
    }

    public TestAttachment attachFileToLastStep(File file, String fileName) {
        // do nothing
        return null;
    }

    public TestAttachment attachDataToLastStep(byte[] data, String fileName) {
        // do nothing
        return null;
    }
}
