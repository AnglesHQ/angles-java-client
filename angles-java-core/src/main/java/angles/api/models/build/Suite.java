package angles.api.models.build;

import angles.api.models.execution.Execution;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class Suite {
    private String name;
    private List<Execution> executions = new ArrayList<>();

    public void addExecution(Execution execution) {
        this.executions.add(execution);
    }
}
