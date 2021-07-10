package angles.api.models.screenshot;

import angles.api.models.Platform;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class UpdateScreenshot implements Serializable {

    private Platform platform;
    private List<String> tags;

}
