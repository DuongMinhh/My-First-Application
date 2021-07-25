package com.me.webservice.config.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.me.common.entity.UserInformation;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String phoneNumber;
	private String email;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;

	public CustomUserDetails(String phoneNumber, String email, String password, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static CustomUserDetails build(UserInformation user) {

		// Get role name from account and assign to authorites
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

		return new CustomUserDetails(user.getPhoneNumber(), user.getEmail(), user.getPassword(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return "Phone: " + this.phoneNumber + " - Email: " + this.email; 
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
