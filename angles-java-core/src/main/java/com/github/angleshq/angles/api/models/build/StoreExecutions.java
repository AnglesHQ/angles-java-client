package com.github.angleshq.angles.api.models.build;

import com.github.angleshq.angles.api.models.execution.CreateExecution;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor @Getter @Setter
public class StoreExecutions implements Serializable {
    private CreateExecution[] executions;
}
