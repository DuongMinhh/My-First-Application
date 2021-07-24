package com.me.webservice.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("authenticationManager")
public class AuthenManagerImpl implements AuthenticationManager {
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private CustomUserService userService;

	public Authentication authenticate(Authentication auth) throws AuthenticationException {

		UserDetails userDetails = userService.loadUserByUsername(auth.getName());

		if (userDetails != null) {
			if (passwordEncoder.matches((CharSequence) auth.getCredentials(), userDetails.getPassword())) {

				// Username, password and authorities
				return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(),
						userDetails.getAuthorities());
			}
		}
		throw new BadCredentialsException("Bad Credentials");
	}
}
