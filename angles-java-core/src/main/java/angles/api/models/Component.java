package angles.api.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
public class Component extends BaseModel {

    @Getter @Setter
    private String name;
    @Getter @Setter
    private List<String> features;

    public Component(String name) {
        this.name = name;
    }
}
