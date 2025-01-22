package data.invalidResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorBase {

    @JsonProperty("status")
    private Integer status;
    @JsonProperty("message")
    private String message;

    /**
     * No args constructor for use in serialization
     *
     */
    public ErrorBase() {
    }

    public ErrorBase(Integer status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

}