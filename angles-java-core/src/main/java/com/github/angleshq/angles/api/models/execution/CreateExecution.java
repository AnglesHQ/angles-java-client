package com.github.angleshq.angles.api.models.execution;

import com.github.angleshq.angles.api.models.Platform;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter @Setter @NoArgsConstructor
public class CreateExecution implements Serializable {

    private String build;
    private String title;
    private String suite;
    private String feature;
    private List<String> tags = new ArrayList<>();
    private Date start;
    /* prevent any modifications by other threads to cause an issue. */
    private List<Action> actions = new CopyOnWriteArrayList<>();
    private List<Platform> platforms = new ArrayList<>();
    /* Ids of files attached to the whole test, e.g. a video, trace, HAR file or console log. */
    private List<String> attachments = new CopyOnWriteArrayList<>();

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public void addAttachment(String attachmentId) {
        this.attachments.add(attachmentId);
    }

    public void addAction(Action action) {
        this.actions.add(action);
    }

    public void addPlatform(Platform... platform) {
        this.platforms.clear();
        this.platforms.addAll(Arrays.asList(platform));
    }
}
