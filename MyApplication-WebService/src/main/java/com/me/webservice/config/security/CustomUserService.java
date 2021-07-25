package com.me.webservice.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.me.common.entity.UserInformation;
import com.me.common.repository.UserInformationRepository;

@Service
public class CustomUserService implements UserDetailsService {

	@Autowired
	private UserInformationRepository userInformationRepository;

	@Override
	public UserDetails loadUserByUsername(String loginInfo) throws UsernameNotFoundException {

		// User from DB
		UserInformation user = userInformationRepository.findByUsernameOrEmailOrPhoneNumber(loginInfo, loginInfo, loginInfo).orElseThrow(() -> {
			throw new UsernameNotFoundException("User not found");
		});
		
		if (!user.getIsEnable()) throw new UsernameNotFoundException("User is locked!");

		// Return custom user
		return CustomUserDetails.build(user);
	}
}
