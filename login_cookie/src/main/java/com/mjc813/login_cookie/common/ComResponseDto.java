package com.mjc813.login_cookie.common;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComResponseDto<T> {
    private ResponseCode responseCode;
    private String message;
    private T result;

    public static <T> ComResponseDto<T> make(ResponseCode responseCode, String message, T data) {
        return ComResponseDto.<T>builder()
                .responseCode(responseCode)
                .message(message)
                .result(data)
                .build();
    }
}
