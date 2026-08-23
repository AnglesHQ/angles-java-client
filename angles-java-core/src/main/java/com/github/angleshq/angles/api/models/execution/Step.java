package com.github.angleshq.angles.api.models.execution;

import com.github.angleshq.angles.StepStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter @Getter @NoArgsConstructor
public class Step {

    private String name;
    private String expected;
    private String actual;
    private String info;
    private StepStatus status;
    private Date timestamp;
    private String screenshot;
    /* Attachment ids referenced by a manual step result, alongside the screenshot. */
    private List<String> attachments = new ArrayList<>();

    public Step(String name, String info, StepStatus status, Date timestamp) {
        this.name = name;
        this.info = info;
        this.status = status;
        this.timestamp = timestamp;
    }

    public Step(String name, String expected, String actual, String info, StepStatus status, Date timestamp) {
        this.name = name;
        this.expected = expected;
        this.actual = actual;
        this.info = info;
        this.status = status;
        this.timestamp = timestamp;
    }

    public Step(String name, String expected, String actual, String info, StepStatus status, String screenshot, Date timestamp) {
        this.name = name;
        this.expected = expected;
        this.actual = actual;
        this.info = info;
        this.status = status;
        this.screenshot = screenshot;
        this.timestamp = timestamp;
    }
}
