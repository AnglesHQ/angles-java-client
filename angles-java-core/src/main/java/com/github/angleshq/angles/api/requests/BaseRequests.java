package com.github.angleshq.angles.api.requests;

import com.github.angleshq.angles.api.exceptions.AnglesServerException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public abstract class BaseRequests {

    protected CloseableHttpClient client = HttpClients.createDefault();
    protected String baseUrl;
    protected Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    protected BaseRequests(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    protected CloseableHttpResponse sendJSONPost(String path, Object message) throws IOException {
        HttpPost httpPost = new HttpPost(baseUrl.concat(path));
        StringEntity entity = new StringEntity(gson.toJson(message));
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        return client.execute(httpPost);
    }

    protected CloseableHttpResponse sendMultiPartEntity(String path, Map<String, String> headers, HttpEntity entity) throws IOException {
        HttpPost httpPost = new HttpPost(baseUrl.concat(path));
        //handle headers
        for (String key: headers.keySet()) {
            httpPost.setHeader(key, headers.get(key));
        }
        httpPost.setHeader("Accept", "application/json");
        httpPost.setEntity(entity);

        return client.execute(httpPost);
    }

    protected CloseableHttpResponse sendJSONGet(String path) throws IOException {
        HttpGet httpGet = new HttpGet(baseUrl.concat(path));
        httpGet.setHeader("Accept", "application/json");
        return client.execute(httpGet);
    }

    protected CloseableHttpResponse sendJSONGet(String path, Map<String, Object> parameters) throws IOException, URISyntaxException {
        URIBuilder builder = new URIBuilder(baseUrl.concat(path));
        if (parameters != null && parameters.size() > 0) {
            for (String key: parameters.keySet()) {
                builder.setParameter(key, parameters.get(key).toString());
            }
        }
        HttpGet httpGet = new HttpGet(builder.build());
        httpGet.setHeader("Accept", "application/json");
        return client.execute(httpGet);
    }


    protected CloseableHttpResponse sendDelete(String path) throws IOException {
        HttpDelete httpDelete = new HttpDelete(baseUrl.concat(path));
        httpDelete.setHeader("Accept", "application/json");
        return client.execute(httpDelete);
    }

    protected CloseableHttpResponse sendJSONPut(String path, Object message) throws IOException {
        HttpPut httpPut = new HttpPut(baseUrl.concat(path));
        StringEntity entity = new StringEntity(gson.toJson(message));
        httpPut.setEntity(entity);
        httpPut.setHeader("Accept", "application/json");
        httpPut.setHeader("Content-type", "application/json");
        return client.execute(httpPut);
    }

    protected String getDefaultErrorMessage(CloseableHttpResponse response) {
        String errorMessage = "";
        try {
            String bodyString =  EntityUtils.toString(response.getEntity());
            JsonObject jsonResponse = gson.fromJson(bodyString, JsonObject.class);
            errorMessage = jsonResponse.get("message").toString();
        } catch (IOException | JsonSyntaxException exc) {
            try {
                errorMessage =  EntityUtils.toString(response.getEntity());
            } catch (Exception exception) {
                errorMessage = "Unable to extract error message from response due to [" + exception.getMessage() + "]";
            }
        }
        return errorMessage;
    }

    protected <T> T processResponse(CloseableHttpResponse response, Class<T> responseClass) throws IOException, AnglesServerException {
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK ||
                response.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED) {
            String responseBody = EntityUtils.toString(response.getEntity());
            return gson.fromJson(responseBody, responseClass);
        } else {
            processErrorResponse(response);
        }
        return null;
    }

    protected void processErrorResponse(CloseableHttpResponse response) throws AnglesServerException {
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
            throw new AnglesServerException(404, getDefaultErrorMessage(response));
        } else if (response.getStatusLine().getStatusCode() == HttpStatus.SC_CONFLICT) {
            throw new AnglesServerException(409, getDefaultErrorMessage(response));
        } else if (response.getStatusLine().getStatusCode() == HttpStatus.SC_UNPROCESSABLE_ENTITY) {
            throw new AnglesServerException(422, getDefaultErrorMessage(response));
        } else {
            throw new AnglesServerException(500, getDefaultErrorMessage(response));
        }
    }

}
