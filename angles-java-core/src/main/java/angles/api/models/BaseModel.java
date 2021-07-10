package angles.api.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
public class BaseModel implements Serializable {

    @Getter @Setter
    @SerializedName("_id")
    protected String id;
    protected Date createdAt;
    protected Date updatedAt;
    @SerializedName("__v")
    protected Integer version;
}
