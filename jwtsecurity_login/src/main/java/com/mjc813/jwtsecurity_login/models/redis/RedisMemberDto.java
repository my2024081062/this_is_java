package com.mjc813.jwtsecurity_login.models.redis;

import com.mjc813.jwtsecurity_login.models.member.MemberDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class RedisMemberDto extends MemberDto implements IRedisMember {
    private String accessToken;
    private String refreshToken;
}
