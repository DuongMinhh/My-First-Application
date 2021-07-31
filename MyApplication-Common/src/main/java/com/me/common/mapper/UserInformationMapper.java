package com.me.common.mapper;

import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;
import com.me.common.dto.UserInformationDto;
import com.me.common.entity.UserInformation;

@Component
public class UserInformationMapper {

	public UserInformationDto entiyToDto(UserInformation obj) {
		JMapper<UserInformationDto, UserInformation> mapper = new JMapper<>(UserInformationDto.class, UserInformation.class);
		return mapper.getDestination(obj);
	}

	public UserInformation dtoToEntity(UserInformationDto obj) {
		JMapper<UserInformation, UserInformationDto> mapper = new JMapper<>(UserInformation.class, UserInformationDto.class);
		return mapper.getDestination(obj);
	}
}
