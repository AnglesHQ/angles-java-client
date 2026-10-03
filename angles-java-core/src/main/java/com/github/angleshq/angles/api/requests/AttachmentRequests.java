package com.github.angleshq.angles.api.requests;

import com.github.angleshq.angles.api.exceptions.AnglesServerException;
import com.github.angleshq.angles.api.models.attachment.TestAttachment;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Uploads files that an automated test produced (POST /build/{buildId}/attachment).
 *
 * The server decides how a file is shown from its extension, so keep the real one:
 * .log/.txt, .json, .har, .webm/.mp4, .zip (a Playwright trace when the name contains
 * "trace"), .html/.htm, .png/.jpg/.jpeg/.gif/.webp.
 */
public class AttachmentRequests extends BaseRequests {

    public AttachmentRequests(String baseUrl) {
        super(baseUrl);
    }

    public TestAttachment upload(String buildId, File file, String fileName) throws IOException, AnglesServerException {
        HttpEntity entity = MultipartEntityBuilder.create()
                .addBinaryBody("attachment", file, ContentType.APPLICATION_OCTET_STREAM,
                        fileName != null ? fileName : file.getName())
                .build();
        return send(buildId, entity);
    }

    public TestAttachment upload(String buildId, byte[] data, String fileName) throws IOException, AnglesServerException {
        HttpEntity entity = MultipartEntityBuilder.create()
                .addBinaryBody("attachment", data, ContentType.APPLICATION_OCTET_STREAM, fileName)
                .build();
        return send(buildId, entity);
    }

    private TestAttachment send(String buildId, HttpEntity entity) throws IOException, AnglesServerException {
        try (CloseableHttpResponse response = sendMultiPartEntity("build/" + buildId + "/attachment", new HashMap<>(), entity)) {
            return processResponse(response, TestAttachment.class);
        }
    }
}
