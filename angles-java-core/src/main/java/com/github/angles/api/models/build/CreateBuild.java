package com.github.angles.api.models.build;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor @Getter @Setter
public class CreateBuild implements Serializable {
    private String team;
    private String environment;
    private String name;
    private Date start;
    private String component;
}
