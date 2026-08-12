package com.github.angleshq.angles.api.models.screenshot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ImageCompareResponse implements Serializable {

    /** Algorithm that produced this result: 'pixel', 'ssim', or 'phash'. */
    private String algorithm;

    private Boolean isSameDimensions;
    private Float rawMisMatchPercentage;
    private Double misMatchPercentage;
    private Integer analysisTime;

    /** SSIM score in [-1, 1] (1 = identical); present when algorithm is 'ssim'. */
    private Double ssim;

    /** Normalised perceptual-hash distance (0-1); present when algorithm is 'phash'. */
    private Double distance;

    /** Clustered change regions; present when requested with regions=true (pixel only). */
    private List<DiffRegion> regions;

}
