package com.me.common.mapper.model;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.me.common.dto.AdminDto;
import com.me.common.entity.Admin;

@Component
public class AdminMapper {

	@Autowired
	private ModelMapper mapper;
	
	public AdminDto entiyToDto(Admin admin) {
		TypeMap<Admin, AdminDto> typeMap = mapper.addMappings(new PropertyMap<Admin, AdminDto>() {
			@Override
			protected void configure() {
				skip().setUserInformation(null);
				map(source.getUserInformationId(), destination.getUserInformationId());
			}
		});
		return typeMap.map(admin);
	}
	
	public Admin dtoToEntity(AdminDto admin) {
		TypeMap<AdminDto, Admin> typeMap = mapper.addMappings(new PropertyMap<AdminDto, Admin>() {
			@Override
			protected void configure() {
				skip().setUserInformation(null);
				map(source.getUserInformationId(), destination.getUserInformationId());
			}
		});
		return typeMap.map(admin);
	}
}
