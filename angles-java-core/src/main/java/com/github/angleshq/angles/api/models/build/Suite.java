package com.github.angleshq.angles.api.models.build;

import com.github.angleshq.angles.api.models.execution.CreateExecution;
import com.github.angleshq.angles.api.models.execution.Execution;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class Suite {
    private String name;
    private CreateExecution setup;
    private CreateExecution teardown;
    private List<CreateExecution> executions = new ArrayList<>();

    public void addExecution(CreateExecution execution) {
        this.executions.add(execution);
    }
}
