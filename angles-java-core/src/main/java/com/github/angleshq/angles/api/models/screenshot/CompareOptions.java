package com.github.angleshq.angles.api.models.screenshot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Options for the screenshot compare endpoints. Field names match the API's query
 * parameters; any field left null falls back to the server-side default.
 */
@Getter
@Setter
@NoArgsConstructor
public class CompareOptions implements Serializable {

    /** Comparison algorithm: 'pixel' (default), 'ssim', or 'phash' (JSON endpoints only). */
    private String algorithm;

    /** Per-pixel colour-distance threshold (0-1, pixel algorithm only). Defaults to 0.5. */
    private Double threshold;

    /** When true (pixel algorithm only), changed pixels are clustered into regions. */
    private Boolean regions;

}
