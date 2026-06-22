package com.example.jwt_start.model.auth;

import lombok.Getter;

@Getter
public class RefreshAuthTokenDto extends AuthTokenDto {
    private final String signId;

    public RefreshAuthTokenDto(String signId, String accessToken, String refreshToken) {
        super(accessToken, refreshToken);
        this.signId = signId;
    }
}
