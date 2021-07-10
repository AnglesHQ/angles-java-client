package angles.api.models.build;

import angles.api.models.BaseModel;
import angles.api.models.Environment;
import angles.api.models.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter @Setter @NoArgsConstructor
public class Build extends BaseModel {

    private Environment environment;
    private Team team;
    private String name;
    private String component;
    private Map<String, Integer> result;
    private List<Artifact> artifacts = new ArrayList<>();
    private List<Suite> suites = new ArrayList<>();

    public void addArtifact(Artifact artifact) {
        this.artifacts.add(artifact);
    }

    public void addSuite(Suite suite) {
        this.suites.add(suite);
    }
}
