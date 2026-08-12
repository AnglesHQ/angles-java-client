package com.github.angleshq.angles.api.requests;

import com.github.angleshq.angles.api.exceptions.AnglesServerException;
import com.github.angleshq.angles.api.models.Platform;
import com.github.angleshq.angles.api.models.screenshot.CompareOptions;
import com.github.angleshq.angles.api.models.screenshot.CreateScreenshot;
import com.github.angleshq.angles.api.models.screenshot.FindImageOptions;
import com.github.angleshq.angles.api.models.screenshot.ImageCompareResponse;
import com.github.angleshq.angles.api.models.screenshot.ImageFindResponse;
import com.github.angleshq.angles.api.models.screenshot.Screenshot;
import com.github.angleshq.angles.api.models.screenshot.UpdateScreenshot;
import com.google.gson.JsonArray;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.tika.Tika;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class ScreenshotRequests extends BaseRequests {

    private String basePath = "screenshot";
    private Tika tika = new Tika();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public ScreenshotRequests(String baseUrl) {
        super(baseUrl);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    public Screenshot create(CreateScreenshot createScreenshot) throws IOException, AnglesServerException {
        File screenShotFile = new File(createScreenshot.getFilePath());
        String mimeType = tika.detect(screenShotFile);
        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder
            .create()
            .addTextBody("buildId", createScreenshot.getBuildId())
            .addTextBody("timestamp", sdf.format(createScreenshot.getTimestamp()))
            .setContentType(ContentType.MULTIPART_FORM_DATA);
        if (createScreenshot.getView() != null) {
            entityBuilder.addTextBody("view", createScreenshot.getView());
        }
        if (createScreenshot.getPlatform() != null) {
            Platform platform = createScreenshot.getPlatform();
            if (platform.getPlatformName() != null) entityBuilder.addTextBody("platformName", platform.getPlatformName());
            if (platform.getPlatformVersion() != null) entityBuilder.addTextBody("platformVersion", platform.getPlatformVersion());
            if (platform.getBrowserName() != null) entityBuilder.addTextBody("browserName", platform.getBrowserName());
            if (platform.getBrowserVersion() != null) entityBuilder.addTextBody("browserVersion", platform.getBrowserVersion());
            if (platform.getDeviceName() != null) entityBuilder.addTextBody("deviceName", platform.getDeviceName());
        }
        if (createScreenshot.getTags() != null) {
            JsonArray jsonArray = new JsonArray();
            for (String tag: createScreenshot.getTags()) {
                jsonArray.add(tag);
            }
            entityBuilder.addTextBody("tags", jsonArray.toString());
        }
        entityBuilder.addBinaryBody("screenshot", screenShotFile, ContentType.getByMimeType(mimeType), screenShotFile.getName());
        HttpEntity entity = entityBuilder.build();
        CloseableHttpResponse response = sendMultiPartEntity(basePath, new HashMap<>(), entity);
        return processResponse(response, Screenshot.class);
    }

    public Screenshot[] get(String buildId, String view, Integer limit, Integer skip) throws IOException, URISyntaxException, AnglesServerException {
        Map<String, Object> parameters = new HashMap<>();
        if (buildId != null) { parameters.put("buildId", view); }
        if (view != null) { parameters.put("view", view); }
        if (limit != null) { parameters.put("limit", limit); }
        if (skip != null) { parameters.put("skip", skip); }
        CloseableHttpResponse response = sendJSONGet(basePath, parameters);
        return processResponse(response, Screenshot[].class);
    }

    public Screenshot get(String screenshotId) throws IOException, AnglesServerException {
        CloseableHttpResponse response = sendJSONGet(basePath + "/" + screenshotId);
        return processResponse(response, Screenshot.class);
    }

    public ImageCompareResponse baselineCompare(String screenshotId) throws IOException, AnglesServerException {
        CloseableHttpResponse response = sendJSONGet(basePath + "/" + screenshotId + "/baseline/compare");
        return processResponse(response, ImageCompareResponse.class);
    }

    private Map<String, Object> compareParameters(CompareOptions options) {
        Map<String, Object> parameters = new HashMap<>();
        if (options == null) {
            return parameters;
        }
        if (options.getAlgorithm() != null) { parameters.put("algorithm", options.getAlgorithm()); }
        if (options.getThreshold() != null) { parameters.put("threshold", options.getThreshold()); }
        if (options.getRegions() != null) { parameters.put("regions", options.getRegions()); }
        return parameters;
    }

    /**
     * Compares the screenshot against its baseline with explicit compare options
     * (algorithm 'pixel'|'ssim'|'phash', threshold, regions).
     */
    public ImageCompareResponse baselineCompare(String screenshotId, CompareOptions options) throws IOException, URISyntaxException, AnglesServerException {
        CloseableHttpResponse response = sendJSONGet(basePath + "/" + screenshotId + "/baseline/compare", compareParameters(options));
        return processResponse(response, ImageCompareResponse.class);
    }

    /**
     * Compares two stored screenshots and returns the comparison statistics.
     */
    public ImageCompareResponse compare(String screenshotId, String screenshotCompareId, CompareOptions options) throws IOException, URISyntaxException, AnglesServerException {
        CloseableHttpResponse response = sendJSONGet(basePath + "/" + screenshotId + "/compare/" + screenshotCompareId, compareParameters(options));
        return processResponse(response, ImageCompareResponse.class);
    }

    public Boolean delete(String screenshotId) throws IOException, AnglesServerException {
        CloseableHttpResponse response = sendDelete(basePath + "/" + screenshotId);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            return true;
        } else {
            processErrorResponse(response);
        }
        return false;
    }

    public Screenshot update(String screenshotId, UpdateScreenshot updateRequest) throws IOException, AnglesServerException {
        CloseableHttpResponse response = sendJSONPut(basePath + "/" + screenshotId, updateRequest);
        return processResponse(response, Screenshot.class);
    }

    private Map<String, Object> findImageParameters(FindImageOptions options) {
        Map<String, Object> parameters = new HashMap<>();
        if (options == null) {
            return parameters;
        }
        if (options.getMinConfidence() != null) { parameters.put("minConfidence", options.getMinConfidence()); }
        if (options.getScaleMin() != null) { parameters.put("scaleMin", options.getScaleMin()); }
        if (options.getScaleMax() != null) { parameters.put("scaleMax", options.getScaleMax()); }
        if (options.getMaxMatches() != null) { parameters.put("maxMatches", options.getMaxMatches()); }
        if (options.getGrayscale() != null) { parameters.put("grayscale", options.getGrayscale()); }
        return parameters;
    }

    /**
     * Finds a stored screenshot (the template) within another stored screenshot using
     * multi-scale template matching, and returns the matched region(s).
     */
    public ImageFindResponse findImageInScreenshot(String screenshotId, String templateScreenshotId, FindImageOptions options) throws IOException, URISyntaxException, AnglesServerException {
        CloseableHttpResponse response = sendJSONGet(basePath + "/" + screenshotId + "/find/" + templateScreenshotId, findImageParameters(options));
        return processResponse(response, ImageFindResponse.class);
    }

    /**
     * Finds a local template image file within a stored screenshot using multi-scale
     * template matching. The template is uploaded with the request and not stored.
     */
    public ImageFindResponse findImageInScreenshot(String screenshotId, File templateFile, FindImageOptions options) throws IOException, URISyntaxException, AnglesServerException {
        String mimeType = tika.detect(templateFile);
        HttpEntity entity = MultipartEntityBuilder
            .create()
            .setContentType(ContentType.MULTIPART_FORM_DATA)
            .addBinaryBody("template", templateFile, ContentType.getByMimeType(mimeType), templateFile.getName())
            .build();
        CloseableHttpResponse response = sendMultiPartEntity(basePath + "/" + screenshotId + "/find", new HashMap<>(), findImageParameters(options), entity);
        return processResponse(response, ImageFindResponse.class);
    }

    /**
     * Same search as findImageInScreenshot, but returns the screenshot image (PNG bytes)
     * with the matched region(s) outlined.
     */
    public byte[] findImageInScreenshotImage(String screenshotId, String templateScreenshotId, FindImageOptions options) throws IOException, URISyntaxException, AnglesServerException {
        CloseableHttpResponse response = sendJSONGet(basePath + "/" + screenshotId + "/find/" + templateScreenshotId + "/image", findImageParameters(options));
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            return EntityUtils.toByteArray(response.getEntity());
        }
        processErrorResponse(response);
        return null;
    }
}
