package com.mjc813.cafe_kios.models;

import com.mjc813.cafe_kios.ResponseCode;
import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ApiResponse<T> {
    private ResponseCode code;
    private String message;
    private T responseData;

    public static <T> ApiResponse<T> make(ResponseCode code, String message, T resultData) {
        return ApiResponse.<T>builder()
            .code(code)
            .message(message)
            .responseData(resultData)
            .build();
    }
}
