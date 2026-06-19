package com.example.jwt_start.model.auth;

import com.example.jwt_start.model.member.IMember;
import com.example.jwt_start.model.member.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
