package angles.api.models.build;

import angles.api.models.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter @Setter @NoArgsConstructor
public class BuildResponse extends BaseModel {

    private String environment;
    private String team;
    private String name;
    private String component;
    private Map<String, Integer> result;
    private List<Artifact> artifacts = new ArrayList<>();
    private List<SuiteResponse> suites = new ArrayList<>();

}
