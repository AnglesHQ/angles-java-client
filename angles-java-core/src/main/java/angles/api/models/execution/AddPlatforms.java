package angles.api.models.execution;

import angles.api.models.Platform;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter @Setter
public class AddPlatforms {

    private List<Platform> platforms = new ArrayList<>();

    public void addPlatform(Platform... platform) {
        this.platforms.addAll(Arrays.asList(platform));
    }

}
