package com.me.webservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.me.common.dto.AdminDto;
import com.me.common.dto.CustomerDto;
import com.me.common.dto.SellerDto;
import com.me.common.entity.Admin;
import com.me.common.entity.Balance;
import com.me.common.entity.Customer;
import com.me.common.entity.Seller;
import com.me.common.entity.UserInformation;
import com.me.common.enums.RoleEnum;
import com.me.common.exceptions.CustomException;
import com.me.common.exceptions.CustomMessage;
import com.me.common.mapper.AdminMapper;
import com.me.common.mapper.CustomerMapper;
import com.me.common.mapper.SellerMapper;
import com.me.common.mapper.UserInformationMapper;
import com.me.common.model.AdminRegisterRequest;
import com.me.common.model.CustomerRegisterRequest;
import com.me.common.model.LoginRequest;
import com.me.common.model.LoginResponse;
import com.me.common.model.SellerRegisterRequest;
import com.me.common.repository.AdminRepository;
import com.me.common.repository.BalanceRepository;
import com.me.common.repository.CustomerRepository;
import com.me.common.repository.SellerRepository;
import com.me.common.repository.UserInformationRepository;
import com.me.webservice.config.security.JwtUtil;
import com.me.webservice.service.AuthenticateService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthenticateServiceImpl implements AuthenticateService {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private UserInformationRepository userInformationRepository;
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private UserInformationMapper userInfomationMapper;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private BalanceRepository balanceRepository;
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private SellerMapper sellerMapper;

	@Override
	public LoginResponse login(LoginRequest req) throws CustomException {
		try {
			Authentication rawAuthenObject = new UsernamePasswordAuthenticationToken(req.getLoginInfo(),
					req.getPassword());
			Authentication resultAuthenObject = authenticationManager.authenticate(rawAuthenObject);

			String jwtToken = jwtUtil.generateJwt(resultAuthenObject.getPrincipal().toString());
			List<String> roles = resultAuthenObject.getAuthorities().stream().map(i -> i.getAuthority())
					.collect(Collectors.toList());

			return new LoginResponse(jwtToken, resultAuthenObject.getName(), roles);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.LOGIN_INFO_INVALID);
		}
	}
	
	@Transactional
	@Override
	public AdminDto register(AdminRegisterRequest req) throws CustomException {
		try {
			Admin admin = new Admin();
			admin.setFirstName(req.getFirstName());
			admin.setLastName(req.getLastName());
			admin.setAddress(req.getAddress());
			
			UserInformation adminInfo = userInfomationMapper.modelToEntity(req);
			adminInfo.setPassword(encoder.encode(adminInfo.getPassword()));
			adminInfo.setRoleId(RoleEnum.ROLE_ADMIN.value);
			adminInfo.setIsEnable(false);
			
			admin.setUserInformationId(userInformationRepository.save(adminInfo).getId());
			return adminMapper.entiyToDto(adminRepository.save(admin));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}
	
	@Transactional
	@Override
	public CustomerDto register(CustomerRegisterRequest req) throws CustomException {
		try {
			Customer customer = new Customer();
			customer.setFirstName(req.getFirstName());
			customer.setLastName(req.getLastName());
			customer.setAddress(req.getAddress());

			UserInformation customerInfo = userInfomationMapper.modelToEntity(req);
			customerInfo.setPassword(encoder.encode(customerInfo.getPassword()));
			customerInfo.setRoleId(RoleEnum.ROLE_CUSTOMER.value);
			customerInfo.setIsEnable(true);
			
			Balance balance = new Balance(0.0);

			customer.setBalanceId(balanceRepository.save(balance).getId());
			customer.setUserInformationId(userInformationRepository.save(customerInfo).getId());
			return customerMapper.entiyToDto(customerRepository.save(customer));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}
	
	@Transactional
	@Override
	public SellerDto register(SellerRegisterRequest req) throws CustomException {
		try {
			Seller seller = new Seller();
			seller.setName(req.getName());
			seller.setAddress(req.getAddress());
			seller.setIntroduction(req.getIntroduction());

			UserInformation sellerInfo = userInfomationMapper.modelToEntity(req);
			sellerInfo.setPassword(encoder.encode(sellerInfo.getPassword()));
			sellerInfo.setRoleId(RoleEnum.ROLE_SELLER.value);
			sellerInfo.setIsEnable(true);

			Balance balance = new Balance(0.0);

			seller.setBalanceId(balanceRepository.save(balance).getId());
			seller.setUserInformationId(userInformationRepository.save(sellerInfo).getId());
			return sellerMapper.entiyToDto(sellerRepository.save(seller));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}
}
