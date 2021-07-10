package angles.api.models.execution;

import angles.api.models.BaseModel;
import angles.api.models.Platform;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter @Getter
public class Execution extends BaseModel {

    private String build;
    private String title;
    private String suite;
    private String feature;
    private List<String> tags = new ArrayList<String>();
    private Date start;
    private List<Action> actions = new ArrayList<>();
    private List<Platform> platforms = new ArrayList<>();

    public Execution(String build, String title, String suite, String feature,Date start) {
        this.build = build;
        this.title = title;
        this.suite = suite;
        this.feature = feature;
        this.start = start;
    }

    public Execution(String build, String title, String suite, String feature, List<String> tags, Date start) {
        this.build = build;
        this.title = title;
        this.suite = suite;
        this.feature = feature;
        this.tags = tags;
        this.start = start;
    }

    public Execution(String build, String title, String suite, String feature, List<String> tags, Date start, List<Action> actions) {
        this.build = build;
        this.title = title;
        this.suite = suite;
        this.feature = feature;
        this.tags = tags;
        this.start = start;
        this.actions = actions;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public void addAction(Action action) {
        this.actions.add(action);
    }

    public void addPlatform(Platform platform) {
        this.platforms.add(platform);
    }
}
