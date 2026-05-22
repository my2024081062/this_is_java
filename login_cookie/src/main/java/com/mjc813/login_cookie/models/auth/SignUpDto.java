package com.mjc813.login_cookie.models.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mjc813.login_cookie.models.member.IMember;
import com.mjc813.login_cookie.models.member.Role;
import jakarta.validation.Valid;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SignUpDto  implements IMember {
    @JsonIgnore
    private Long id;

    @Valid
    private String signId;
    private String password;
    private String email;

    @JsonIgnore
    private Boolean validEmail;
    @JsonIgnore
    private String validText;
    @JsonIgnore
    private Role role;
    @JsonIgnore
    private LocalDateTime createAt;
    @JsonIgnore
    private LocalDateTime updateAt;
    @JsonIgnore
    private LocalDateTime deleteAt;
}
