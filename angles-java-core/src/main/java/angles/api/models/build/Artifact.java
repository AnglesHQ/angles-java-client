package angles.api.models.build;

import lombok.*;

@Getter @Setter @AllArgsConstructor @RequiredArgsConstructor
public class Artifact {
    private String groupId;
    @NonNull
    private String artifactId;
    @NonNull
    private String version;
}
