package com.github.angleshq.angles.api.models.screenshot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Options for the 'find template in screenshot' endpoints. Field names match the API's
 * query parameters; any field left null falls back to the server-side default.
 */
@Getter
@Setter
@NoArgsConstructor
public class FindImageOptions implements Serializable {

    /** Minimum confidence (0-1) for a region to count as a match. Defaults to 0.8. */
    private Double minConfidence;

    /** Lower bound of the template scale sweep. Defaults to 0.75. */
    private Double scaleMin;

    /** Upper bound of the template scale sweep. Defaults to 1.25. */
    private Double scaleMax;

    /** Maximum number of matches to return (1-25). Defaults to 1. */
    private Integer maxMatches;

    /** Match on luminance only, which is more tolerant of colour differences between devices. */
    private Boolean grayscale;

}
