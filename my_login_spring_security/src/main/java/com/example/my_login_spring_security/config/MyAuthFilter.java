package com.example.my_login_spring_security.config;

import com.example.my_login_spring_security.models.member.IMember;
import com.example.my_login_spring_security.models.member.MemberService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
public class MyAuthFilter extends OncePerRequestFilter {

    @Autowired
    private MemberService memberService;

    @Override
    protected void doFilterInternal(HttpServletRequest request
            , HttpServletResponse response
            , FilterChain filterChain) throws ServletException, IOException {
        try {
            if(request.getMethod().equals("OPTIONS")) {
                filterChain.doFilter(request, response);
                return;
            }
            Object object = request.getSession().getAttribute("MJC_LOGIN");
            if(object == null) {
                filterChain.doFilter(request, response);
                return;
            }
            String signId = (String) object;
            IMember signedMember = memberService.findBySignId(signId);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    signedMember, signedMember,signedMember.getAuthorities()
            );
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        catch (Exception e) {
            log.error("user auth error" + e.getMessage());
        }
        filterChain.doFilter(request,response);
    }
}
