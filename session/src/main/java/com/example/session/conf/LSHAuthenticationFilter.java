package com.example.session.conf;

import com.example.session.model.member.IMember;
import com.example.session.model.member.MemberDto;
import com.example.session.model.member.MemberService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
public class LSHAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    MemberService memberService;

    @Override
    protected void doFilterInternal(HttpServletRequest request
            , HttpServletResponse response
            , FilterChain filterChain) throws ServletException, IOException {
        try {
            if(request.getMethod().equals("OPTIONS")) {
                filterChain.doFilter(request, response);
                return;
            }
            HttpSession session = request.getSession();
            Object mjcLogin = session.getAttribute("MJC_LOGIN");
            if(mjcLogin instanceof IMember signedMember){
                MemberDto find = memberService.findBySignId(signedMember.getSignId());
                UsernamePasswordAuthenticationToken auth = new  UsernamePasswordAuthenticationToken(
                        find
                        , find
                        , find.getAuthorities()
                );
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e) {
            log.error("user auth error" + e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}
