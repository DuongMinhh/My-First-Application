package com.me.webservice.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.me.common.dto.SellerDto;
import com.me.common.entity.Balance;
import com.me.common.entity.Seller;
import com.me.common.entity.UserInformation;
import com.me.common.enums.RoleEnum;
import com.me.common.exceptions.CustomException;
import com.me.common.exceptions.CustomMessage;
import com.me.common.mapper.SellerMapper;
import com.me.common.mapper.UserInformationMapper;
import com.me.common.model.SellerRegisterRequest;
import com.me.common.repository.BalanceRepository;
import com.me.common.repository.SellerRepository;
import com.me.common.repository.UserInformationRepository;
import com.me.webservice.service.SellerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private UserInformationRepository userInformationRepository;
	@Autowired
	private SellerMapper sellerMapper;
	@Autowired
	private UserInformationMapper userInfomationMapper;
	@Autowired
	private BalanceRepository balanceRepository;
	@Autowired
	private PasswordEncoder encoder;

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
