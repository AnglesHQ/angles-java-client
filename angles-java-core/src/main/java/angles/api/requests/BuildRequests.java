package angles.api.requests;

import angles.api.exceptions.AnglesServerException;
import angles.api.models.build.Artifact;
import angles.api.models.build.Build;
import angles.api.models.build.CreateBuild;
import angles.api.models.build.StoreArtifacts;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class BuildRequests extends BaseRequests {

    private String basePath = "build";
    public BuildRequests(String baseUrl) {
        super(baseUrl);
    }

    public Build create(CreateBuild createBuild) throws IOException, AnglesServerException {
        CloseableHttpResponse response = sendJSONPost(basePath, createBuild);
        return processResponse(response, Build.class);
    }

    public Build[] get(String teamId, Integer limit, Integer skip) throws IOException, URISyntaxException, AnglesServerException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("teamId", teamId);
        if (limit != null) { parameters.put("limit", limit); }
        if (skip != null) { parameters.put("skip", skip); }
        CloseableHttpResponse response = sendJSONGet(basePath, parameters);
        return processResponse(response, Build[].class);
    }

    public Build get(String buildId) throws IOException, AnglesServerException {
        CloseableHttpResponse response = sendJSONGet(basePath + "/" + buildId);
        return processResponse(response, Build.class);
    }

    public Boolean delete(String buildId) throws IOException, AnglesServerException {
        CloseableHttpResponse response = sendDelete(basePath + "/" + buildId);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            return true;
        } else {
            processErrorResponse(response);
        }
        return false;
    }

    public Build update(Build build) throws IOException, AnglesServerException {
        CloseableHttpResponse response = sendJSONPut(basePath + "/" + build.getId(), build);
        return processResponse(response, Build.class);
    }

    public Build keep(String buildId, Boolean keep) throws IOException, AnglesServerException {
        String request = "{ \"keep\": " + keep + " }";
        CloseableHttpResponse response = sendJSONPut(basePath + "/" + buildId + "/keep", request);
        return processResponse(response, Build.class);
    }

    public Build artifacts(String buildId, Artifact artifact) throws IOException, AnglesServerException {
        Artifact[] artifacts = { artifact };
        return artifacts(buildId, artifacts);
    }

    public Build artifacts(String buildId, Artifact[] artifacts) throws IOException, AnglesServerException {
        StoreArtifacts request = new StoreArtifacts();
        request.setArtifacts(artifacts);
        CloseableHttpResponse response = sendJSONPut(basePath + "/" + buildId + "/artifacts", request);
        return processResponse(response, Build.class);
    }

}
