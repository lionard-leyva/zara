package com.zara.catalog.api.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DateTimeParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handleDateTimeParseException(DateTimeParseException e) {
        return ResponseEntity.badRequest().body(new ApiError("Invalid date-time format", "DateTimeParseException"));
    }

    @ExceptionHandler(PriceCalculationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiError> handlePriceCalculationException(PriceCalculationException e) {
        return ResponseEntity.internalServerError().body(new ApiError(e.getMessage(), "PriceCalculationException"));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiError> handleGeneralException(Exception e) {
        return ResponseEntity.internalServerError().body(new ApiError("An unexpected error occurred", "Exception"));
    }
}
