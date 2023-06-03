package org.sad.classUTrepository;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.sad.classUTrepository.dto.ClassUT_DTO;
import org.sad.classUTrepository.entity.Admin;
import org.sad.classUTrepository.entity.ClassUT;
import org.sad.classUTrepository.service.AdminService;
import org.sad.classUTrepository.service.ClassUTService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.deser.impl.JavaUtilCollectionsDeserializers;

@SpringBootApplication
public class ClassUtRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassUtRepositoryApplication.class, args);
		
		//System.out.print("Hello\n");
	}
	
//	@Bean
//	public CommandLineRunner demo (ClassUTService classService,
//										AdminService adminService) {
//		return (args) -> {
//			
//			/*//creo un amministratore
//			/*Admin A1 = new Admin();
//			A1.setName("Marco"); A1.setSurname("Rocchi");
//			adminService.save(A1);
//			//salvo una classe
//			Date D = new Date();
//			ClassUT C1 = new ClassUT();
//			C1.setName("Prova2");
//			C1.setComplexity(10);
//			C1.setLocation("Casa tua");
//			C1.setAdmin(A1);;
//			C1.setAdded(D);
//			
//			classService.save(C1);
//			
//			ClassUT C2 = new ClassUT();
//			C2.setName("Prova3");
//			C2.setComplexity(4);
//			C2.setLocation("Casa mia");
//			C2.setAdmin(A1);
//			C2.setAdded(D);
//			
//			classService.save(C2);*/		
//			//getALL
//			/*
//			System.out.print("------------\n");
//			List<ClassUT_DTO> items = classService.getClassesbyAdmin("Rocchi");
//			if (items.isEmpty())
//				System.out.print("Vuota\n");
//			else {
//					System.out.print("Non vuota\n");
//					for (int i = 0; i < items.size(); i++) {
//						System.out.print(items.get(i).getId()+"|");
//						System.out.print(items.get(i).getName()+"|");
//						System.out.print(items.get(i).getComplexity()+"\n");
//					}
//				}
//			System.out.print("------------\n");
//			List<ClassUT_DTO> items2 = classService.getClassesbyComplexity(4);
//			if (items2.isEmpty())
//				System.out.print("Vuota\n");
//			else {
//					System.out.print("Non vuota\n");
//					for (int i = 0; i < items2.size(); i++) {
//						System.out.print(items2.get(i).getId()+"|");
//						System.out.print(items2.get(i).getName()+"|");
//						System.out.print(items2.get(i).getComplexity()+"\n");
//					}
//				}
//			/*classService.update(25, "Updated");*/
//			/*System.out.print("------------\n");
//			List<ClassUT_DTO> items3 = classService.getAll();
//			if (items3.isEmpty())
//				System.out.print("Vuota\n");
//			else {
//					System.out.print("Non vuota\n");
//					for (int i = 0; i < items3.size(); i++) {
//						System.out.print(items3.get(i).getId()+"|");
//						System.out.print(items3.get(i).getName()+"|");
//						System.out.print(items3.get(i).getComplexity()+"\n");
//					}
//				}*/
//			/*classService.getAll().forEach(p->{
//				System.out.print("Dettaglio classe: "+p);
//			System.out.print("Ho stampato------------\n");
//			});*/
//		adminService.update(1, "Mario", "Rossi");	
//		};
//	}
}
