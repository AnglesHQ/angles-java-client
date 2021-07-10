package angles.api.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Team extends BaseModel {

    @Getter @Setter
    private String name;
    @Getter @Setter
    private List<Component> components = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addComponent(String name) {
        components.add(new Component(name));
    }
}
