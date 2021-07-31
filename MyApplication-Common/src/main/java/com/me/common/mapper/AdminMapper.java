package com.me.common.mapper;

import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;
import com.me.common.dto.AdminDto;
import com.me.common.entity.Admin;

@Component
public class AdminMapper {

	public AdminDto entiyToDto(Admin admin) {
		JMapper<AdminDto, Admin> mapper = new JMapper<>(AdminDto.class, Admin.class);
		return mapper.getDestination(admin);
	}
	
	public Admin dtoToEntity(AdminDto admin) {
		JMapper<Admin, AdminDto> mapper = new JMapper<>(Admin.class, AdminDto.class);
		return mapper.getDestination(admin);
	}
}