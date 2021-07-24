package com.me.common.mapper;

import org.mapstruct.Mapper;

import com.me.common.dto.RoleDto;
import com.me.common.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {

	Role dtoToEntity(RoleDto role);
	
	RoleDto entityToDto(Role role);
}
