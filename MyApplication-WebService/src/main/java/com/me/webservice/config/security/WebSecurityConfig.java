package com.me.webservice.config.security;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * Configurer for security filters
 * 
 * @author DuongMinh
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	static final RequestMatcher SECURITY_EXCLUSION_MATCHER;
	static {
        String[] urls = new String[] {
        		"/**"
        };
        LinkedList<RequestMatcher> matcherList = new LinkedList<>();
        for (String url : urls) {
            matcherList.add(new AntPathRequestMatcher(url));
        }

        //Link Matchers in "OR" config.
        SECURITY_EXCLUSION_MATCHER = new OrRequestMatcher(matcherList);
	}
	
	@Autowired
	CustomUserService userService;

	@Autowired
	AuthenEntryPoint authenEntryPoint;

	@Bean
	AuthenTokenFilter authenTokenFilter() {
		return new AuthenTokenFilter();
	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
				.exceptionHandling().authenticationEntryPoint(authenEntryPoint)
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				
				.and()
				.authorizeRequests()
//				.antMatchers("/management/**")
//				.hasAnyAuthority("ROLE_ADMIN", "ROLE_NORMAL")
//				
//				.and()
//				.authorizeRequests()
//				.antMatchers("/admin/**")
//				.hasAnyAuthority("ROLE_ADMIN")
				
				.anyRequest()
				.permitAll()
	
				;
		http.addFilterBefore(authenTokenFilter(), UsernamePasswordAuthenticationFilter.class)
				;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
