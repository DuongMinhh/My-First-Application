package com.me.webservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.me.common.dto.BrandDto;
import com.me.common.entity.Brand;
import com.me.common.entity.ImageStorage;
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

	@Override
	public BrandDto save(BrandDto brand) throws CustomException {
		try {
			Brand brandEntity = new Brand();
			brandEntity.setName(brand.getName());
			brandEntity.setIntroduction(brand.getIntroduction());
			return brandMapper.entityToDto(brandRepository.save(brandEntity));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Transactional
	@Override
	public BrandDto addImage(Long brandId, List<MultipartFile> images) throws CustomException {
		try {
			Brand brandDb = brandRepository.getById(brandId);
			List<ImageStorage> listImageStorage = new ArrayList<ImageStorage>();

			images.forEach(img -> {
				try {
					listImageStorage.add(imageStorageService.save(img, ImageEnum.BRAND));
				} catch (CustomException e) {
					log.error(e.getMessage());
				}
			});
			listImageStorage.addAll(brandDb.getListImageStorage());
			brandDb.setListImageStorage(listImageStorage);
			return brandMapper.entityToDto(brandRepository.save(brandDb));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Override
	public BrandDto update(BrandDto brand) throws CustomException {
		try {
			Brand brandDb = brandRepository.getById(brand.getId());
			brandDb.setName(brand.getName());
			brandDb.setIntroduction(brand.getIntroduction());
			return brandMapper.entityToDto(brandRepository.save(brandDb));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Override
	public BrandDto getById(Long id) throws CustomException {
		try {
			Brand brand = brandRepository.findById(id).orElseGet(() -> new Brand());
			return brandMapper.entityToDto(brand);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Override
	public List<BrandDto> getAll() throws CustomException {
		try {
			List<Brand> listBrands = brandRepository.findAll();
			return listBrands.stream().map(brandMapper::entityToDto).collect(Collectors.toList());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Override
	public Boolean deleteById(Long id) throws CustomException {
		try {
			brandRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

	@Modifying
	@Override
	public Boolean deleteImage(Long brandId, Long imageId) throws CustomException {
		try {
			Brand brand = brandRepository.getById(brandId);
			brand.getListImageStorage().removeIf(i -> i.getId() == imageId);
			brandRepository.save(brand);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

}
