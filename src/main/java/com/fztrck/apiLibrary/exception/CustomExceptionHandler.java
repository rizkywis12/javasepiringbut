package com.fztrck.apiLibrary.exception;

import com.fztrck.apiLibrary.exception.custom.CustomBadRequestException;
import com.fztrck.apiLibrary.exception.custom.CustomNotFoundException;
import com.fztrck.apiLibrary.model.dto.response.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    private ErrorMessage<Object> errorMessage;

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleExceptionGlobal(Exception e) {
        errorMessage = new ErrorMessage<Object>(HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now(),
                e.getMessage(), null);
        return ResponseEntity.status(errorMessage.getStatus()).body(errorMessage);
    }

    @ExceptionHandler(value = CustomNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(CustomNotFoundException e) {
        errorMessage = new ErrorMessage<Object>(HttpStatus.NOT_FOUND.value(), LocalDateTime.now(),
                e.getMessage(), null);
        return ResponseEntity.status(errorMessage.getStatus()).body(errorMessage);
    }

    @ExceptionHandler(value = CustomBadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(CustomBadRequestException e) {
        errorMessage = new ErrorMessage<Object>(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(),
                e.getMessage(), null);
        return ResponseEntity.status(errorMessage.getStatus()).body(errorMessage);
    }
}
