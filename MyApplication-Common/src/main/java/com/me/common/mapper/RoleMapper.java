package com.me.common.mapper;

import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;
import com.me.common.dto.RoleDto;
import com.me.common.entity.Role;

@Component
public class RoleMapper {

	Role dtoToEntity(RoleDto obj) {
		JMapper<Role, RoleDto> mapper = new JMapper<>(Role.class, RoleDto.class);
		return mapper.getDestination(obj);
	}

	RoleDto entityToDto(Role obj) {
		JMapper<RoleDto, Role> mapper = new JMapper<>(RoleDto.class, Role.class);
		return mapper.getDestination(obj);
	}
}
