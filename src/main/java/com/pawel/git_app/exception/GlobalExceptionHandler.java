package com.pawel.git_app.exception;

import com.pawel.git_app.domain.ErrorHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GithubUserNotFoundException.class)
    public ResponseEntity<ErrorHandler> handleGithubNotFoundException(GithubUserNotFoundException exception) {
        ErrorHandler errorHandler = new ErrorHandler(HttpStatus.NOT_FOUND.value(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorHandler);
    }
}
