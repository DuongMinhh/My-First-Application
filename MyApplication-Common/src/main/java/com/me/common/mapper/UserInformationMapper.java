package com.me.common.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.me.common.dto.UserInformationDto;
import com.me.common.entity.UserInformation;

@Component
public class UserInformationMapper {

	@Autowired
	private ModelMapper mapper;

	public UserInformationDto entiyToDto(UserInformation obj) {
		TypeMap<UserInformation, UserInformationDto> typeMap = mapper.addMappings(new PropertyMap<UserInformation, UserInformationDto>() {
			@Override
			protected void configure() {
				skip().setRole(null);
				map(source.getRoleId(), destination.getRoleId());
			}
		});
		return typeMap.map(obj);
	}

	public UserInformation dtoToEntity(UserInformationDto obj) {
		TypeMap<UserInformationDto, UserInformation> typeMap = mapper.addMappings(new PropertyMap<UserInformationDto, UserInformation>() {
			@Override
			protected void configure() {
				skip().setRole(null);
				map(source.getRoleId(), destination.getRoleId());
			}
		});
		return typeMap.map(obj);
	}
}
