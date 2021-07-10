package angles.api.models.screenshot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ImageCompareResponse implements Serializable {

    private Boolean isSameDimensions;
    private Float rawMisMatchPercentage;
    private Double misMatchPercentage;
    private Integer analysisTime;
    
}
