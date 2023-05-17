package org.sad.classUTrepository.service;

import java.io.IOException;
import java.util.List;

import org.sad.classUTrepository.dto.ClassUT_DTO;
import org.sad.classUTrepository.entity.Admin;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ClassUTService {
	
	String save(Admin admin, int complexity, MultipartFile classUT) throws IOException;
	List<ClassUT_DTO> getAll();
	void update(int id, String newname);
	void delete(int id);
	List<ClassUT_DTO> getClassesbyAdmin(String admin_surname);
	List<ClassUT_DTO> getClassesbyComplexity(int complexity);
	Resource getClassUTasResource(String fileName)throws ClassNotFoundException;
}
