package angles.api.models.execution;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Action {

    private String name;
    private List<Step> steps = new ArrayList<Step>();

    public Action(String name) {
        this.name = name;
    }

    public Action(String name, List<Step> steps) {
        this.name = name;
        this.steps = steps;
    }

    public void addStep(Step step) {
        this.steps.add(step);
    }

}
