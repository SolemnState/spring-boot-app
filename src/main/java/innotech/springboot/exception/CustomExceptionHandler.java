package innotech.springboot.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import innotech.springboot.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice
public class CustomExceptionHandler {//extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {DateTimeParseException.class})
    public final ResponseEntity handleDateTimeParseException(DateTimeParseException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse resp = new ErrorResponse(ApiError.WRONG_DATE_FORMAT, details);
        return new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(value = {IllegalArgumentException.class})
//    public final ResponseEntity<Object> handleIllegalArgumentExceptions(IllegalArgumentException ex, WebRequest request) {
//        List<String> details = new ArrayList<>();
//        details.add(ex.getLocalizedMessage());
//        ErrorResponse resp = new ErrorResponse(ApiError.WRONG_DATE_FORMAT, details);
//        return new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(value = {InvalidFormatException.class})
    public final ResponseEntity<Object> test(InvalidFormatException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse resp = new ErrorResponse(ApiError.WRONG_DATE_FORMAT, details);
        return new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {JsonMappingException.class})
    public final ResponseEntity<Object> test(JsonMappingException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse resp = new ErrorResponse(ApiError.INPUT_DATE_IS_NULL, details);
        return new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
    }
}
