package com.me.webservice.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.me.common.dto.BrandDto;
import com.me.common.dto.ImageStorageDto;
import com.me.common.entity.Brand;
import com.me.common.enums.ImageEnum;
import com.me.common.exceptions.CustomException;
import com.me.common.exceptions.CustomMessage;
import com.me.common.mapper.BrandMapper;
import com.me.common.repository.BrandRepository;
import com.me.webservice.service.BrandService;
import com.me.webservice.service.ImageStorageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private ImageStorageService imageStorageService;
	@Autowired
	private BrandMapper brandMapper;

	@Transactional
	@Override
	public BrandDto save(BrandDto brand, MultipartFile image) throws CustomException {
		try {
			// Save multipartfile
			ImageStorageDto imageStorage = imageStorageService.save(image, ImageEnum.BRAND);

			Brand brandEntity = new Brand();
			brandEntity.setName(brand.getName());
			brandEntity.setIntroduction(brand.getIntroduction());
			brandEntity.setImageStorageId(imageStorage.getId());

			return brandMapper.entityToDto(brandRepository.save(brandEntity));
		} catch (CustomException ce) {
			log.error(ce.getMessage());
			throw ce;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Override
	public BrandDto update(BrandDto brand) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BrandDto getById(Integer id) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BrandDto> getAll() throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteById(Integer id) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

}
