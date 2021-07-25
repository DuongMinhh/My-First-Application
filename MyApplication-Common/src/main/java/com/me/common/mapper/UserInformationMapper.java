package com.me.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.me.common.dto.UserInformationDto;
import com.me.common.entity.UserInformation;

@Mapper(componentModel = "spring")
public interface UserInformationMapper {

	@Mapping(target = "role", ignore = true)
	UserInformation dtoToEntity(UserInformationDto userInformation);
	
	@Mapping(target = "role", ignore = true)
	UserInformationDto entityToDto(UserInformation userInformation);
}
