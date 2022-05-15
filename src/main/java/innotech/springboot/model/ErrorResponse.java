package innotech.springboot.model;

import innotech.springboot.exception.ApiError;

import java.util.List;

public class ErrorResponse {

    public ErrorResponse(String message, Integer errorCode, List<String> details) {
        super();
        this.message = message;
        this.details = details;
        this.errorCode = errorCode;
    }

    public ErrorResponse(ApiError error, List<String> details) {
        super();
        this.message = error.getErrorMessage();
        this.errorCode = error.getCode();
        this.details = details;
    }

    //General error message about nature of error
    private String message;
    private Integer errorCode;

    //Specific errors in API request processing
    private List<String> details;

    public String getMessage() {
        return message;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

}
