package com.mjc813.swim.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobarExceptionHandler {
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiResponse<String>> handleException(Throwable throwable){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(
                ApiResponse.make(ResponseCode.other_failed,"error",throwable.getMessage()));
    }

}
