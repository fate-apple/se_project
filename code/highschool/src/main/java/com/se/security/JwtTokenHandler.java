package com.se.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.se.service.UserService;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;

@Component
public final class JwtTokenHandler {
	private final String secret;
	private final UserService userService;

	public JwtTokenHandler(@Value("${app.blog.jwt.secret}") String secret, UserService userService) {
		this.secret = secret;
		this.userService = userService;
	}

	Optional<UserDetails> parseUserFromToken(String token) {
		String userName = Jwts.parser()
			.setSigningKey(secret)
			.parseClaimsJws(token)
			.getBody()
			.getSubject();
		return Optional.ofNullable(userService.loadUserByUsername(userName));
	}

	public String createTokenForUser(UserDetails user) {
		final ZonedDateTime afterOneWeek = ZonedDateTime.now().plusWeeks(1);
		return Jwts.builder()
			.setSubject(user.getUsername())
			.signWith(SignatureAlgorithm.HS512, secret)
			.setExpiration(Date.from(afterOneWeek.toInstant()))
			.compact();
	}
}
