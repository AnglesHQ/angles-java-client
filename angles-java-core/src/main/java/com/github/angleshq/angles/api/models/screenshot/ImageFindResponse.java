package com.github.angleshq.angles.api.models.screenshot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ImageFindResponse implements Serializable {

    private List<ImageFindMatch> matches;

    /** The highest-confidence match, or null when nothing was found. */
    private ImageFindMatch bestMatch;

    private ImageFindDimensions imageDimensions;
    private ImageFindDimensions templateDimensions;

    /** Search duration in milliseconds. */
    private Integer analysisTime;

}
