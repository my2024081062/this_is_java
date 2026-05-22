package com.mjc813.login_cookie.models.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mjc813.login_cookie.models.member.IMember;
import com.mjc813.login_cookie.models.member.Role;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidEmailDto implements IMember {
	@JsonIgnore
	private Long id;

	private String signId;

	@JsonIgnore
	private String password;
	@JsonIgnore
	private String email;
	@JsonIgnore
	private Boolean validEmail;

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
