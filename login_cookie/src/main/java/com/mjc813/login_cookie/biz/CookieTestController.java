package com.mjc813.login_cookie.biz;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/menu")
public class CookieTestController {
    @GetMapping("/cookie/make")
    public String home(
            HttpServletResponse response
            , @RequestParam String name
            , @RequestParam String value
            , Model model){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/cookie");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(120);
        response.addCookie(cookie);
        model.addAttribute("cookie_time", cookie.getMaxAge());
        model.addAttribute("cookie_name", cookie.getName());
        model.addAttribute("cookie_value", cookie.getValue());
        return "info/home";
    }

    @GetMapping("/cookie/get")
    public String getInfo(
            HttpServletRequest request
            , Model model)
    {
        Cookie[] cks = request.getCookies();
        if (cks != null && cks.length > 0 ) {
            model.addAttribute("cookie_time", cks[0].getMaxAge());
            model.addAttribute("cookie_name", cks[0].getName());
            model.addAttribute("cookie_value", cks[0].getValue());
        }
        return "info/info";
    }

    @GetMapping("/cookie/delete")
    public String home(
            HttpServletResponse response
            , @RequestParam("name") String name
            , Model model)
    {
        Cookie ck = new Cookie(name, "");
        ck.setPath("/cookie");
        ck.setHttpOnly(true);
        ck.setMaxAge(-1);
        response.addCookie(ck);
        model.addAttribute("cookie_time", "");
        model.addAttribute("cookie_name", "");
        model.addAttribute("cookie_value", "");
        return "info/info";
    }
}
