package com.mjc813.login_cookie.biz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {

	@GetMapping("/check_email")
	public String checkEmail(@RequestParam("id") String signId, Model model) {
		model.addAttribute("signId", signId);
		return "info/checkEmail";
	}
}
