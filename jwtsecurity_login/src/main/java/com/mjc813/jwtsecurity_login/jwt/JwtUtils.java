package com.mjc813.jwtsecurity_login.jwt;

import com.mjc813.jwtsecurity_login.models.auth.AuthTokenDto;
import com.mjc813.jwtsecurity_login.models.member.IMember;
import com.mjc813.jwtsecurity_login.models.redis.RedisMemberDto;
import com.mjc813.jwtsecurity_login.models.redis.RedisMemberService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtils {
	@Autowired
	private RedisMemberService redisMemberService;
//	@Value("${myapp.jwt.secret:8922dd9b66160ad81c3141c6051767b42cc912e03a62c3c5e8fd77c72eb906d9vv!123456abcdef}")
	private String secret = "8922dd9b66160ad81c3141c6051767b42cc912e03a62c3c5e8fd77c72eb906d9vv!123456abcdef";
//	@Value("${myapp.jwt.expireAccessToken}")
	private Long expireAccessToken = 1800000L; // 30분
	private Long expireRefreshToken = 604800000L; // 7일

	private final SecretKey secretKey;

	public JwtUtils() {
		this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
	}

	public String generateAccessToken(String value) {
		return this.generateToken(value, this.expireAccessToken);
	}

	public String generateRefreshToken(String value) {
		return this.generateToken(value, this.expireRefreshToken);
	}

	public String generateToken(String value, Long milliSeconds) {
		String str = Jwts.builder()
				.subject(value)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + milliSeconds))
				.signWith(this.secretKey)
				.compact();
		return str;
	}

	public String generateToken(IMember member, Long milliSeconds) {
		String str = Jwts.builder()
				.subject(member.getSignId())
				.claim("role", member.getRole())    // subject 외에 부가정보는 claim 에 추가할수 있다.
				.claim("email", member.getEmail())  // jwt 에 부가정보 중 개인정보를 넣으면 위험하다.
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + milliSeconds))
				.signWith(this.secretKey)
				.compact();
		return str;
	}

	public Claims parseToken(String token) {
		try {
			Claims cl = Jwts.parser()
					.verifyWith(this.secretKey)
					.build()
					.parseSignedClaims(token)
					.getPayload();
			return cl;
		} catch (ExpiredJwtException | IllegalArgumentException e ) {
			throw e;
		} catch (JwtException e ) {
			throw e;
		}
	}

	public String getRole(String token) throws JwtExpireException {
		Claims cl = this.parseToken(token);
		return cl.get("role", String.class);
	}

	public String getEmail(String token) throws JwtExpireException {
//		Claims cl = this.parseToken(token);
//		return cl.get("email", String.class);
		return this.getValueFromClaims(token, "email");
	}

	public String getValueFromClaims(String token, String key) throws JwtExpireException {
		Claims cl = this.parseToken(token);
		return cl.get(key, String.class);
	}

	public String getSignId(String token) throws JwtExpireException {
		Claims cl = this.parseToken(token);
		return cl.getSubject();
	}

	public Boolean validateToken(String token) throws JwtExpireException {
		this.parseToken(token);
		return true;
	}

	public String resolveJwtTokenFromBearerToken(String bearerToken) {
		if ( bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}

	public void saveRedis(IMember user, AuthTokenDto authTokenDto) {
		RedisMemberDto redisMemberDto = RedisMemberDto.builder()
				.accessToken(authTokenDto.getAccessToken())
				.refreshToken(authTokenDto.getRefreshToken())
				.build();
		redisMemberDto.clone(user, true);
		this.redisMemberService.update(redisMemberDto);
	}

	public void removeRedis(String signId) {
		this.redisMemberService.deleteBySignId(signId);
	}

	public RedisMemberDto findRedis(String signId) {
		RedisMemberDto redisMemberDto = this.redisMemberService.findBySignId(signId);
		return redisMemberDto;
	}
}
