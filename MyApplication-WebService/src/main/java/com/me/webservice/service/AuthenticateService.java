package com.me.webservice.service;

import com.me.common.dto.AdminDto;
import com.me.common.dto.CustomerDto;
import com.me.common.dto.SellerDto;
import com.me.common.exceptions.CustomException;
import com.me.common.model.AdminRegisterRequest;
import com.me.common.model.CustomerRegisterRequest;
import com.me.common.model.LoginRequest;
import com.me.common.model.LoginResponse;
import com.me.common.model.SellerRegisterRequest;

public interface AuthenticateService {

	LoginResponse login(LoginRequest req) throws CustomException;
	
	AdminDto register(AdminRegisterRequest req) throws CustomException;
	
	SellerDto register(SellerRegisterRequest req) throws CustomException;
	
	CustomerDto register(CustomerRegisterRequest req) throws CustomException;
}
