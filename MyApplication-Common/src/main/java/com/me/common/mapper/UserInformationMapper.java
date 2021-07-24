package com.me.common.mapper;

import org.mapstruct.Mapper;

import com.me.common.dto.UserInformationDto;
import com.me.common.entity.UserInformation;

@Mapper(componentModel = "spring")
public interface UserInformationMapper {

	UserInformation dtoToEntity(UserInformationDto userInformation);
	
	UserInformationDto entityToDto(UserInformation userInformation);
}
