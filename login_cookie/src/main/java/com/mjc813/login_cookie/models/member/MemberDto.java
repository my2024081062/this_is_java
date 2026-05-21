package com.mjc813.login_cookie.models.member;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MemberDto implements IMember{
    private Long id;
    private String signId;
    private String password;
    private String email;
    private Boolean validEmail;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;
}
