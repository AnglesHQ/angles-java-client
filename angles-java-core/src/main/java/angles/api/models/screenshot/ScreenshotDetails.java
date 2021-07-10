package angles.api.models.screenshot;

import angles.api.models.Platform;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class ScreenshotDetails implements Serializable {

    private Platform platform;
    private List<String> tags;
    private String path;
    private String view;
}
