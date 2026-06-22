package com.example.jwt_start.jwt;

public class JwtExpireException extends Exception {
    //try-catch 필요 컴파일 에러 발생시킴
    //db 트랜잭션 처리를 안함, 성공하든 실패하든 커밋
    JwtExpireException(String message){
        super(message);
    }
}
