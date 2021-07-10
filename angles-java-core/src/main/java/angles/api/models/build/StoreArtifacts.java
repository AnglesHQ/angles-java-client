package angles.api.models.build;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor @Getter @Setter
public class StoreArtifacts implements Serializable {
    private Artifact[] artifacts;
}

