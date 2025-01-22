package data.invalidResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMain {

    @JsonProperty("error")
    private ErrorBase errorBase;

    /**
     * No args constructor for use in serialization
     *
     */
    public ErrorMain() {
    }

    public ErrorMain(ErrorBase errorBase) {
        super();
        this.errorBase = errorBase;
    }

    @JsonProperty("errorBase")
    public ErrorBase getErrorBase() {
        return errorBase;
    }

    @JsonProperty("errorBase")
    public void setErrorBase(ErrorBase errorBase) {
        this.errorBase = errorBase;
    }

}