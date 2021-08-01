package com.me.webservice.service;

import com.me.common.dto.SellerDto;
import com.me.common.exceptions.CustomException;
import com.me.common.model.SellerRegisterRequest;

public interface SellerService {

	SellerDto register(SellerRegisterRequest req) throws CustomException;
}
