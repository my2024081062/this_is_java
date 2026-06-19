package com.example.jwt_start.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
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
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ComResponseDto<String>> handleAccessDeniedException(AccessDeniedException e) {
        // 원하는 형태의 에러 응답 포맷으로 변경 가능
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR,"authorize is not allow" ,e.getMessage())
        );
    }
}
