package com.example.jwt_start.model.auth;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AuthTokenDto {
    private String accessToken;
    private String refreshToken;
//    private String tokenType;
}
