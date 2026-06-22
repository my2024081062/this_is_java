package com.example.jwt_start.jwt;

public class jwtIllegalException extends RuntimeException {
    //unCheckedException try-catch 컴파일 에러 발생 안함
    //db 트랜잭션을 처리할 수 있게, 성공하면 쿼리 커밋, 실패하면 롤백
    public jwtIllegalException(String message) {
        super(message);
    }
}
