package com.me.webservice.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.me.common.repository.AdminRepository;
import com.me.common.repository.CustomerRepository;
import com.me.common.repository.SellerRepository;


@Service
public class CustomUserService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private SellerRepository sellerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// User from DB
		User user = userRepo.findByUsername(username);

		// Return custom user
		return user.getStatus() ? CustomUserDetails.build(user) : null;
	}
}
