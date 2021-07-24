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

		// Trekkin method and url
		log.info(request.getMethod());
		log.info(request.getRequestURI());

		// No need check jwt
		if (WebSecurityConfig.SECURITY_EXCLUSION_MATCHER.matches(request)) {
			log.info("===========================Bypass filer=========================\n");
			filterChain.doFilter(request, response);
		}

		// Check jwt
		else {
			log.info("===========================Start filter=========================\n");
			try {
				String jwtToken = request.getHeader(HEADER_STRING).replace("Bearer", "").trim();
				if ((jwtToken != null) && (jwtUtil.validateJwt(jwtToken))) {
					String username = jwtUtil.getUsernameFromJwt(jwtToken);

					UserDetails userDetails = userService.loadUserByUsername(username);

					UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails,
							null, userDetails.getAuthorities());
					log.info("========================Finishing filter========================\n");
					SecurityContextHolder.getContext().setAuthentication(token);
					filterChain.doFilter(request, response);
				} else {
					log.info("Jwt token is null or cannot pass the validation");
				}
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}
}
