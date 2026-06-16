package com.example.session.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.session.model.member.IMember;
import com.example.session.model.member.Role;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SignInDto implements IMember {
    @JsonIgnore
    private Long id;

    private String signId;
    private String password;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private Boolean validEmail;

    @JsonIgnore
    private Role role;

    @JsonIgnore
    private String validText;

    @JsonIgnore
    private LocalDateTime createAt;

    @JsonIgnore
    private LocalDateTime updateAt;

    @JsonIgnore
    private LocalDateTime deleteAt;
}
