package com.example.session.biz;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/menu")
public class SessionTestController {

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

    @GetMapping("session/make")
    public String make(HttpSession session,
                       @RequestParam String name,
                       @RequestParam String value,
                       Model model){
        session.setAttribute(name, value);
        session.setMaxInactiveInterval(3600);
        model.addAttribute("name", name);
        model.addAttribute("value", session.getAttribute(name).toString());
        return "home";
    }

    @GetMapping("/session/delete")
    public String delete(
            HttpServletRequest request
            , @RequestParam("name") String name
            , Model model)
    {
        request.getSession().invalidate();
        model.addAttribute("name", name);
        model.addAttribute("value", "");
        return "info/info";
    }
}
