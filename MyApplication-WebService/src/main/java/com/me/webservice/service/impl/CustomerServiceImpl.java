package com.me.webservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.me.common.dto.CustomerDto;
import com.me.common.entity.Balance;
import com.me.common.entity.Customer;
import com.me.common.entity.UserInformation;
import com.me.common.enums.RoleEnum;
import com.me.common.exceptions.CustomException;
import com.me.common.exceptions.CustomMessage;
import com.me.common.mapper.CustomerMapper;
import com.me.common.mapper.UserInformationMapper;
import com.me.common.model.CustomerRegisterRequest;
import com.me.common.repository.BalanceRepository;
import com.me.common.repository.CustomerRepository;
import com.me.common.repository.UserInformationRepository;
import com.me.webservice.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private UserInformationRepository userInformationRepository;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private UserInformationMapper userInfomationMapper;
	@Autowired
	private BalanceRepository balanceRepository;
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public CustomerDto register(CustomerRegisterRequest req) throws CustomException {
		try {
			Customer customer = new Customer();
			customer.setFirstName(req.getFirstName());
			customer.setLastName(req.getLastName());
			customer.setAddress(req.getAddress());

			UserInformation sellerInfo = userInfomationMapper.modelToEntity(req);
			sellerInfo.setPassword(encoder.encode(sellerInfo.getPassword()));
			sellerInfo.setRoleId(RoleEnum.ROLE_CUSTOMER.value);

			Balance balance = new Balance(0.0);

			customer.setBalanceId(balanceRepository.save(balance).getId());
			customer.setUserInformationId(userInformationRepository.save(sellerInfo).getId());

			return customerMapper.entiyToDto(customerRepository.save(customer));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

}
