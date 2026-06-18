package com.example.session.biz;

import com.example.session.common.LoginException;
import com.example.session.model.auth.SignInDto;
import com.example.session.model.member.MemberEntity;
import com.example.session.model.member.MemberJpaRepository;
import com.example.session.model.member.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	@Autowired
	private MemberJpaRepository memberJpaRepository;

	public Boolean signMember(SignInDto signInDto) throws LoginException {
		MemberEntity find = this.memberJpaRepository.findBySignId(signInDto.getSignId()).orElseThrow();
//		if ( !find.getValidEmail() ) {
//			throw new LoginException("not valid email");
//		}
		if ( find.getRole() == Role.GUEST ) {
			throw new LoginException("doesn't need login");
		}
        assert signInDto.getPassword() != null;
        if ( signInDto.getPassword().equals(find.getPassword()) ) {
			return true;
		}
		return false;
	}
}
