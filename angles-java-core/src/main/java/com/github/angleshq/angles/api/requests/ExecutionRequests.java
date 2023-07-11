package com.github.angleshq.angles.api.requests;

import com.github.angleshq.angles.api.exceptions.AnglesServerException;
import com.github.angleshq.angles.api.models.Platform;
import com.github.angleshq.angles.api.models.execution.AddPlatforms;
import com.github.angleshq.angles.api.models.execution.CreateExecution;
import com.github.angleshq.angles.api.models.execution.Execution;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;

public class ExecutionRequests extends BaseRequests {

    private String basePath = "execution";
    public ExecutionRequests(String baseUrl) {
        super(baseUrl);
    }

    public ExecutionRequests(String baseUrl, RequestConfig requestConfig) {
        super(baseUrl, requestConfig);
    }

    public Execution create(CreateExecution createExecution) throws IOException, AnglesServerException {
        CloseableHttpResponse response = sendJSONPost(basePath, createExecution);
        return processResponse(response, Execution.class);
    }

    public Execution[] get() throws IOException, AnglesServerException {
        CloseableHttpResponse response = sendJSONGet(basePath);
        return processResponse(response, Execution[].class);
    }

    public Execution get(String executionId) throws IOException, AnglesServerException {
        CloseableHttpResponse response = sendJSONGet(basePath + "/" + executionId);
        return processResponse(response, Execution.class);
    }

    public Boolean delete(String executionId) throws IOException, AnglesServerException {
        CloseableHttpResponse response = sendDelete(basePath + "/" + executionId);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            return true;
        } else {
            processErrorResponse(response);
        }
        return false;
    }

    public Execution update(Execution execution) throws IOException, AnglesServerException {
        CloseableHttpResponse response = sendJSONPut(basePath + "/" + execution.getId(), execution);
        return processResponse(response, Execution.class);
    }

    public Execution platforms(String executionId, Platform... platforms) throws IOException, AnglesServerException {
        AddPlatforms addPlatformsRequest = new AddPlatforms();
        for (Platform platform: platforms) {  addPlatformsRequest.addPlatform(platform); }
        CloseableHttpResponse response = sendJSONPut(basePath + "/" + executionId + "/platforms", addPlatformsRequest);
        return processResponse(response, Execution.class);
    }

}
