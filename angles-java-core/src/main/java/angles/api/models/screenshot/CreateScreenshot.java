package angles.api.models.screenshot;

import angles.api.models.Platform;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class CreateScreenshot implements Serializable {

    private String buildId;
    private Date timestamp;
    private String view;
    private String filePath;
    private Platform platform;
    private List<String> tags;

}
