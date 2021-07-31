package com.me.common.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.me.common.dto.RoleDto;
import com.me.common.entity.Role;

@Component
public class RoleMapper {

	@Autowired
	private ModelMapper mapper;

	Role dtoToEntity(RoleDto obj) {
		return mapper.map(obj, Role.class);
	}

	RoleDto entityToDto(Role obj) {
		return mapper.map(obj, RoleDto.class);
	}
}
