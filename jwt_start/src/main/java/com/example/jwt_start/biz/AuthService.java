package com.example.jwt_start.biz;

import com.example.jwt_start.model.auth.SignInDto;
import com.example.jwt_start.model.member.MemberEntity;
import com.example.jwt_start.model.member.MemberJpaRepository;
import com.example.jwt_start.model.member.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
	private final MemberJpaRepository memberJpaRepository;

	private final PasswordEncoder passwordEncoder;

	public Boolean signMember(SignInDto signInDto) {
		MemberEntity find = this.memberJpaRepository.findBySignId(signInDto.getSignId()).orElseThrow();
//		if ( !find.getValidEmail() ) {
//			throw new LoginException("not valid email");
//		}
		if(signInDto.getPassword() != null) {
			if ( this.passwordEncoder.matches(signInDto.getPassword(), find.getPassword()) && find.getRole() != Role.GUEST ) {
				return true;
			}
		}
		return false;
	}
}
