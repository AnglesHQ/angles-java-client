package angles.api.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Environment extends BaseModel {

    @Getter @Setter
    private String name;

    public Environment(String name) {
        this.name = name;
    }
}
