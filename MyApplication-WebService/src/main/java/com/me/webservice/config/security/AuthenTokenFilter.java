package com.me.webservice.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.me.common.exceptions.CustomMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenTokenFilter extends OncePerRequestFilter {
	private static final String HEADER_STRING = "Authorization";

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private CustomUserService userService;

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// No need check jwt
		if (WebSecurityConfig.EXCLUSION_URL_MATCHER.matches(request)) {
			filterChain.doFilter(request, response);
		}
		// Check jwt
		else {
			try {
				String jwtToken = request.getHeader(HEADER_STRING).replace("Bearer", "").trim();
				if ((jwtToken != null) && (jwtUtil.validateJwt(jwtToken))) {
					String username = jwtUtil.getUsernameFromJwt(jwtToken);

					UserDetails userDetails = userService.loadUserByUsername(username);

					UsernamePasswordAuthenticationToken authenticatedObject = new UsernamePasswordAuthenticationToken(
							userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
					
					// Add authenticated object to app context
					SecurityContextHolder.getContext().setAuthentication(authenticatedObject);
					
					filterChain.doFilter(request, response);
				} else {
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, CustomMessage.UNAUTHORIZED);
				}
			} catch (Exception e) {
				log.error(e.getMessage());
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, CustomMessage.UNAUTHORIZED);
			}
		}
	}
}
