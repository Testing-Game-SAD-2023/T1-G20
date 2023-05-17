package org.sad.classUTrepository.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.management.modelmbean.ModelMBeanAttributeInfo;

import org.modelmapper.ModelMapper;

import org.sad.classUTrepository.dto.ClassUT_DTO;
import org.sad.classUTrepository.entity.Admin;
import org.sad.classUTrepository.entity.ClassUT;
import org.sad.classUTrepository.exception.FileStorageException;
import org.sad.classUTrepository.repository.ClassUTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ClassUTServiceImpl implements ClassUTService{

	@Autowired
	ClassUTRepository classRepository;
	@Autowired
	ModelMapper modelMapper;
	
	private final String FOLDER_PATH = "D:\\Universita\\SAD\\ClassUT\\";

	@Override
	public String save(Admin admin, int complexity, MultipartFile classUT) throws IOException {
		
		String classPath = FOLDER_PATH + classUT.getOriginalFilename();
		try {
			if (classPath.contains("..")) {
				throw new FileStorageException("Invalid path!"+classPath);
			}
			classUT.transferTo(new File(classPath));
			
			ClassUT toSave = new ClassUT();
			toSave.setName(classUT.getOriginalFilename());
			toSave.setType(classUT.getContentType());
			toSave.setSize(classUT.getSize());
			toSave.setLocation(classPath);
			toSave.setComplexity(complexity);
			toSave.setAdded(new Date()); 
			toSave.setLastupdate(toSave.getAdded());
			toSave.setAdmin(admin);
			classRepository.save(toSave);			
		
		return classPath;
		}catch(IOException e) {
			throw new FileStorageException("Could not store file "+classPath+". Try again!",e);
		}
	}

	@Override
	public List<ClassUT_DTO> getAll() {
		
		List<ClassUT> classes = classRepository.findAll();
		List<ClassUT_DTO> classesDTO = new ArrayList<ClassUT_DTO>(classes.size());
		
		classes.forEach(item -> {
			classesDTO.add(modelMapper.map(item, ClassUT_DTO.class));
		});
		return classesDTO;
	}

	@Override
	public void update(int id, String newname) {
		
		classRepository.updateClassUTName(newname, id);
	}

	@Override
	public void delete(int id) {
		ClassUT deleteClass = classRepository.findById(id).get();
		classRepository.delete(deleteClass);
	}

	@Override
	public List<ClassUT_DTO> getClassesbyAdmin(String admin_surname) {
		
		List<ClassUT> classes = classRepository.findAllClassUTByAdmin_Surname(admin_surname);
		List<ClassUT_DTO> classesDTO = new ArrayList<ClassUT_DTO>(classes.size());
		
		classes.forEach(item -> {
			classesDTO.add(modelMapper.map(item, ClassUT_DTO.class));
		});
		return classesDTO;
	}

	@Override
	public List<ClassUT_DTO> getClassesbyComplexity(int complexity) {
		
		List<ClassUT> classes = classRepository.findAllClassUTByComplexity(complexity);
		List<ClassUT_DTO> classesDTO = new ArrayList<ClassUT_DTO>(classes.size());
		
		classes.forEach(item -> {
			classesDTO.add(modelMapper.map(item, ClassUT_DTO.class));
		});
		return classesDTO;
	}

	@Override
	public Resource getClassUTasResource(String fileName) throws ClassNotFoundException {
		try {
			ClassUT toDownload = classRepository.findByname(fileName);
			String classPath = toDownload.getLocation();
			Resource resourceClass = new UrlResource(new File(classPath).toURI());
			if (resourceClass.exists()) {
				return resourceClass;
			}else {
				throw new ClassNotFoundException("Class file not found "+fileName);
			}
		}catch(MalformedURLException e) {
			throw new ClassNotFoundException("Class file not found "+fileName,e);
		}
	}
}
