package com.mjc813.swim.common;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {
	private ResponseCode responseCode;
	private String message;
	private T responseData;

	public static <T> ApiResponse<T> make(ResponseCode code, String msg, T responseData) {
		return ApiResponse.<T>builder()
            .responseCode(code)
            .message(msg)
            .responseData(responseData)
            .build();
	}
}
