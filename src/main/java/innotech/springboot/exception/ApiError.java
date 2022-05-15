package innotech.springboot.exception;

public enum ApiError {
    WRONG_DATE_FORMAT(1, "Date format doesn't match the pattern \"dd.MM.yyyy\""),
    INPUT_DATE_IS_NULL(2, "Input date should not be null"),
    INPUT_JSON_IS_NOT_VALID(3, "Input body is not valid");

    private final Integer code;
    private final String errorMessage;

    ApiError(Integer code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public Integer getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
