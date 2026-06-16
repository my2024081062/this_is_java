package com.example.session.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobarExceptionHandler {
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ComResponseDto<String>> handleException(Throwable throwable){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        ComResponseDto.make(ResponseCode.SERVER_ERROR,"error",throwable.getMessage()));
    }
    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ComResponseDto<String>> exceptionHandler(LoginException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ComResponseDto.make(ResponseCode.AUTHENTICATION_ERROR,"login_error" ,ex.getMessage())
        );
    }
}
