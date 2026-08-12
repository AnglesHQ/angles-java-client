package com.github.angleshq.angles.api.models.screenshot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ImageFindMatch implements Serializable {

    /** Left edge of the matched region, in original screenshot pixels. */
    private Integer x;

    /** Top edge of the matched region, in original screenshot pixels. */
    private Integer y;

    private Integer width;
    private Integer height;

    /** Normalized cross-correlation score (0-1). */
    private Double confidence;

    /** Template scale at which the match was found. */
    private Double scale;

}
