package org.sad.classUTrepository.repository;

import org.sad.classUTrepository.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	Admin findByid(int id);
	
}
