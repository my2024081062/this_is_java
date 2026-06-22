package com.example.jwt_start.jwt;

import com.example.jwt_start.model.member.IMember;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Slf4j
@Component
public class JwtUtils {
    @Value("${jwt.secrete.key:defaultSecretKeyStringMustBeVeryLongForSecurityPurposes}")
    private String key;

    @Value("${jwt.secrete.access-token-time:1800000}")
    private Long accessTokenTime;

    @Value("${jwt.secrete.refresh-token-time:1800000}")
    private Long refreshTokenTime;

    private SecretKey secretKey;

    public JwtUtils() {
    }
    //스프링의 Bean 생성 순서와 생성자(JwtUtils()) 실행 시점 때문에 PostConstruct 사용
    //생성자에서는 아무것도 하지 않고, 스프링이 @Value 값 주입을 모두 마친 직후에 secretKey를 초기화하도록 하는 어노테이션
    @PostConstruct
    public void init() {
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
    }

    public String generateAccessToken(IMember iMember) {
        return this.generateAccessToken(iMember.getSignId());
    }
    public String generateAccessToken(String signId) {
        return Jwts.builder()
                .subject(signId)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + this.accessTokenTime))
                .signWith(secretKey)
                .compact();
    }

    public String generateRefreshToken(IMember iMember) {
        return this.generateRefreshToken(iMember.getSignId());
    }

    public String generateRefreshToken(String signId) {
        return Jwts.builder()
                .subject(signId)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + this.refreshTokenTime))
                .signWith(secretKey)
                .compact();
    }

    public Claims parseToken(String token) throws Exception {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(this.secretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return claims;
        }
        catch (ExpiredJwtException e) {
            log.error("ExpiredJwtException Error while parsing token", e);
            throw new JwtExpireException(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            log.error("IllegalArgumentException Error while parsing token", e);
            throw new jwtIllegalException(e.getMessage());
        }
        catch (JwtException e) {
            log.error("JwtException Error while parsing token", e);
            throw e;
        }
    }

    public String geValue(String key, String token) throws Exception {
        Claims claims = this.parseToken(token);
        return claims.get(key, String.class);
    }

    public void validateToken(String token) throws Exception {
        this.parseToken(token);
    }

    public String resolveTokenFromBearerToken(String bearerToken) throws Exception {
        if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
