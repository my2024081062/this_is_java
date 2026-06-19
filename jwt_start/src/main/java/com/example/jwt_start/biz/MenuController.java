package com.example.jwt_start.biz;

import com.example.session.model.member.IMember;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MenuController {

	@GetMapping("/")
	public String index(Model model) {
		Object obj = model.getAttribute("signedMember");
		if ( obj instanceof IMember signedMember ) {
			model.addAttribute("signedMember", signedMember);
		}
		return "home";
	}

	@GetMapping("/signup")
	public String signupPage() {
		return "info/signup";
	}

	@GetMapping("/signin")
	public String signinPage() {
		return "info/signin";
	}
}
