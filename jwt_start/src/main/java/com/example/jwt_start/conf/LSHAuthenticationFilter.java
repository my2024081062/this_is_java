package com.example.jwt_start.conf;

import com.example.jwt_start.jwt.JwtExpireException;
import com.example.jwt_start.jwt.JwtUtils;
import com.example.jwt_start.model.member.IMember;
import com.example.jwt_start.model.member.MemberDto;
import com.example.jwt_start.model.member.MemberService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class LSHAuthenticationFilter extends OncePerRequestFilter {

    private final MemberService memberService;

    private final JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request
            , HttpServletResponse response
            , FilterChain filterChain) throws ServletException, IOException {
        try {
            if(request.getMethod().equals("OPTIONS")) {
                filterChain.doFilter(request, response);
                return;
            }
            String authorizationHeader = request.getHeader("Authorization");
            //헤더에 아무것도 없으니 비인가 사용
            if(authorizationHeader == null) {
                filterChain.doFilter(request, response);
                return;
            }
            String jwtToken = this.jwtUtils.resolveTokenFromBearerToken(authorizationHeader);

            String signId = this.jwtUtils.geValue("sub",jwtToken);
            MemberDto find = this.memberService.findBySignId(signId);

            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    find
                    , find
                    , find.getAuthorities()
            );
            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(auth);

        } catch (JwtExpireException e){
            log.error("user auth error" + e.getMessage());
            response.setStatus(401);
            return;
        } catch (Exception e) {
            log.error("user auth error" + e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}
