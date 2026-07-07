package com.mjc813.jwtsecurity_login.models.redis;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@RedisHash(value = "member")
public class RedisMemberEntity implements IRedisMember {
    private Long id;
    @Id
    private String signId;
    private String password;
    private String email;
    private String role;
    private Boolean isValidEmail;
    private String validText;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
    private LocalDateTime deleteDt;

    private String accessToken;
    private String refreshToken;
}
