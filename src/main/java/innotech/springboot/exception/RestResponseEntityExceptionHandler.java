package innotech.springboot.exception;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(value = {DateTimeParseException.class})
    public final ResponseEntity handleDateTimeParseException(DateTimeParseException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse resp = new ErrorResponse(
                ApiError.WRONG_DATE_FORMAT.getErrorMessage(),
                ApiError.WRONG_DATE_FORMAT.getCode(),
                details);
        return new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {InvalidFormatException.class})
    public final ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse resp = new ErrorResponse(
                ApiError.WRONG_DATE_FORMAT.getErrorMessage(),
                ApiError.WRONG_DATE_FORMAT.getCode(),
                details);
        return new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public final ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse resp = new ErrorResponse(
                ApiError.INPUT_DATE_IS_NULL.getErrorMessage(),
                ApiError.INPUT_DATE_IS_NULL.getCode(),
                details);
        return new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {JsonParseException.class})
    public final ResponseEntity<Object> handleJsonParseException(JsonParseException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse resp = new ErrorResponse(
                ApiError.INPUT_JSON_IS_NOT_VALID.getErrorMessage(),
                ApiError.INPUT_JSON_IS_NOT_VALID.getCode(),
                details);
        return new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
    }
}
