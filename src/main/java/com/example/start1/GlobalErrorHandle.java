package com.example.start1;

import com.example.start1.Entities.ErrorEntity;
import com.example.start1.Exceptions.ProductNotFound;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalErrorHandle {
    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<?> handleProductNotFound(ProductNotFound exception){
        ErrorEntity productNotFoundEntity = new ErrorEntity(
                LocalDateTime.now(),exception.getMessage()
        );
        return new ResponseEntity<>(productNotFoundEntity, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationError(MethodArgumentNotValidException exception){
        ErrorEntity validation = new ErrorEntity(
                LocalDateTime.now(),
                "Validation for the data provided failed"
        );
        return new ResponseEntity<>(validation,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> nullExceptionHandling(DataIntegrityViolationException exception){
        ErrorEntity nullValue = new ErrorEntity(
                LocalDateTime.now(),
                exception.getMessage()
        );
        return new ResponseEntity<>(nullValue,HttpStatus.NOT_FOUND);
    }
}
