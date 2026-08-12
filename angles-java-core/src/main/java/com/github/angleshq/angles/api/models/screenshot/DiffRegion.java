package com.github.angleshq.angles.api.models.screenshot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class DiffRegion implements Serializable {

    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;

    /** Number of changed pixels inside the region. */
    private Integer pixels;

}
