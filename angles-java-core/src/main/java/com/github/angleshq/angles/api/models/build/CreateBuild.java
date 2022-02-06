package com.github.angleshq.angles.api.models.build;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor @Getter @Setter
public class CreateBuild implements Serializable {
    private String team;
    private String environment;
    private String name;
    private String phase;
    private Date start;
    private String component;
    private List<Artifact> artifacts = new ArrayList<>();
    private List<Suite> suites = new ArrayList<>();

    public void addArtifact(Artifact artifact) {
        this.artifacts.add(artifact);
    }

    public void addSuite(Suite suite) {
        this.suites.add(suite);
    }
}
