package com.example.session.biz;

import com.example.session.model.member.IMember;
import com.example.session.model.member.MemberDto;
import com.example.session.model.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

@ControllerAdvice
public class SessionControllerAdvice {
	@Autowired
	private MemberService memberService;

	@ModelAttribute
	public void addSignedUser(Model model
		, @SessionAttribute(name = "MJC_LOGIN", required = false) IMember signMember ) {
		// 해당 메소드는 클라이언트의 요청을 가로채서 쿠키의 키가 "MJC_LOGIN" 인 값을 signId 변수에 담는다.
		if ( signMember != null ) {
			// signedMember 가 존재한다면 member 테이블을 조회 한다.
			MemberDto signedMember = memberService.findBySignId(signMember.getSignId());
			model.addAttribute("signedMember", signedMember);
			// 조회한 사용자 데이터를 model 에 추가한다. 추가할때 키 를 "signedMember" 를 줬다. 값은 MemberDto 이다.
		}
	}
}
