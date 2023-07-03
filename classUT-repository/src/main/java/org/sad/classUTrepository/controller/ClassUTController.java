package org.sad.classUTrepository.controller;

import java.util.List;

import org.sad.classUTrepository.dto.ClassUT_DTO;
import org.sad.classUTrepository.dto.UploadClassResponse;
import org.sad.classUTrepository.entity.Admin;
import org.sad.classUTrepository.service.AdminServiceImpl;
import org.sad.classUTrepository.service.ClassUTServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.sad.classUTrepository.exception.ClassNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/classut_repo")
public class ClassUTController {

	@Autowired ClassUTServiceImpl classService;
	@Autowired AdminServiceImpl adminService;
	

	@PostMapping("/uploadClass")
	public UploadClassResponse uploadClassUT(@RequestParam("class_file") MultipartFile class_file, @RequestParam("complexity") int compl, @ModelAttribute("email") String email){
		
		UploadClassResponse response = new UploadClassResponse();
		//TODO: aggiornare dopo aver realizzato login e registrazione dell'admin
		Admin A = adminService.findByEmail(email);
		try {
			String fileName = classService.save(A, compl, class_file);
			String downloadURI = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/downloadClass/")
					.path(fileName).toUriString();
			response.setFileName(fileName);
			response.setFileType(class_file.getContentType());
			response.setFileDownloadURI(downloadURI);
			response.setSize(class_file.getSize());
			response.setNotes("OK");
		}
		catch (Exception e) {
			e.printStackTrace();
			response.setNotes("ERROR DURING SAVING!");
		}
		return response;
		
	}
	
	@GetMapping("/downloadClass/{fileName:.+}")
	public ResponseEntity<Resource> downloadClassUT(@PathVariable String fileName) throws java.lang.ClassNotFoundException{
		
		Resource resource = classService.getClassUTasResource(fileName);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+resource.getFilename()+"\"")
				.body(resource);
	}
	
	@GetMapping(value = "/viewAll", produces = MediaType.APPLICATION_XML_VALUE)
	public List<ClassUT_DTO> viewClasses(){
		return classService.getAll();
	}
}
