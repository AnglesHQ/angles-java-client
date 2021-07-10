package angles.api.exceptions;

import lombok.Getter;

@Getter
public class AnglesServerException extends Exception {

    private Integer httpStatusCode;
    public AnglesServerException(Integer httpStatusCode, String errorMessage) {
        super(errorMessage);
        this.httpStatusCode = httpStatusCode;
    }
}
