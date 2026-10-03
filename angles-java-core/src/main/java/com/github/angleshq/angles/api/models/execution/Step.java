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
    /** Ids of files attached to this step (see AnglesReporter.attachFileToLastStep). */
    private List<String> attachments;

    public void addAttachment(String attachmentId) {
        if (attachments == null) {
            attachments = new ArrayList<>();
        }
        attachments.add(attachmentId);
    }

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
