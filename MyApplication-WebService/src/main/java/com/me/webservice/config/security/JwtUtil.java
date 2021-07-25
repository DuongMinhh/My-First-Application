package com.me.webservice.config.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

/**
 * @author DUONG MINH
 */
@Slf4j
@Component
public class JwtUtil {

	private final String JWT_SECRET = "duongnm5SecretKey";
	private final int JWT_EXPIRATION = 86400000;
//	private static final String TOKEN_PREFIX = "Bearer";

	public String generateJwt(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new Date(java.lang.System.currentTimeMillis()))
				.setExpiration(new Date(java.lang.System.currentTimeMillis() + JWT_EXPIRATION))
				.signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
	}

	public String getUsernameFromJwt(String token) {
		return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwt(String token) {
		try {
			log.info("Issuer: " + Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getIssuer());
			log.info("Expiration: " + Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getExpiration());
			log.info("Token is ok");
			return true;
		} catch (MalformedJwtException e) {
			log.info(e.getMessage());
		} catch (ExpiredJwtException e) {
			log.info(e.getMessage());
		} catch (IllegalArgumentException e) {
			log.info(e.getMessage());
		} catch (NullPointerException e) {
			log.info(e.getMessage());
		}
		return false;
	}
}
