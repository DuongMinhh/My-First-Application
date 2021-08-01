package com.me.webservice.service.impl;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.me.common.entity.ImageStorage;
import com.me.common.enums.ImageEnum;
import com.me.common.exceptions.CustomException;
import com.me.common.exceptions.CustomMessage;
import com.me.common.repository.ImageStorageRepository;
import com.me.webservice.service.ImageStorageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImageStorageServiceImpl implements ImageStorageService {

	@Autowired
	private ImageStorageRepository storageRepository;

	@Override
	public ImageStorage save(MultipartFile image, ImageEnum imageEnum) throws CustomException {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HH-mm-SS");
			String imageName = imageEnum + "_" + LocalDateTime.now().format(formatter) + "_" + image.getOriginalFilename();
			ImageStorage storage = new ImageStorage();

			Path currentFolder = Paths.get(System.getProperty("user.dir"));
			Path imagesFolderPath = Paths.get("src/main/resources/static/images");
			Path path = currentFolder.resolve(imagesFolderPath);
			
			Path productPath = Paths.get("product");
			Path brandPath = Paths.get("brand");
			Path imagePath;
			Path localPath;
			
			if (imageEnum == ImageEnum.BRAND) {
				if (!Files.exists(path.resolve(brandPath))) {
					Files.createDirectories(path.resolve(brandPath));
				}
				localPath = imagesFolderPath.resolve(brandPath);
				imagePath = path.resolve(brandPath).resolve(imageName);
			} else if (imageEnum == ImageEnum.PRODUCT) {
				if (!Files.exists(path.resolve(productPath))) {
					Files.createDirectories(path.resolve(productPath));
				}
				localPath = imagesFolderPath.resolve(productPath);
				imagePath = path.resolve(productPath).resolve(imageName);
			} else {
				throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.IMAGE_TYPE_FAIL);
			}

			InputStream stream = image.getInputStream();
			byte[] data = new byte[stream.available()];
			stream.read(data);

			FileOutputStream fos = new FileOutputStream(imagePath.toString());
			fos.write(data);
			fos.close();

			storage.setLocalPath(localPath.toString());
			storage.setImageName(imageName);
			return storageRepository.save(storage);
		} catch (CustomException ce) {
			log.error(CustomMessage.IMAGE_TYPE_FAIL);
			throw ce;
		} catch (Exception e) {
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.IMAGE_TYPE_FAIL);
		}
	}

	@Override
	public Boolean deleteById(Long id) throws CustomException {
		try {
			storageRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new CustomException(HttpStatus.BAD_REQUEST, CustomMessage.BAD_REQUEST);
		}
	}

}
