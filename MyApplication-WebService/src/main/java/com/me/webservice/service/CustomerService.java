package com.me.webservice.service;

import com.me.common.dto.CustomerDto;
import com.me.common.exceptions.CustomException;
import com.me.common.model.CustomerRegisterRequest;

public interface CustomerService {

	CustomerDto register(CustomerRegisterRequest req) throws CustomException;
}
