package com.me.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.me.common.dto.AdminDto;
import com.me.common.entity.Admin;

@Mapper(componentModel = "spring")
public interface AdminMapper {

	@Mapping(target = "userInformation", ignore = true)
	Admin dtoToEntity(AdminDto admin);
	
	@Mapping(target = "userInformation", ignore = true)
	AdminDto entityToDto(Admin admin);
}
