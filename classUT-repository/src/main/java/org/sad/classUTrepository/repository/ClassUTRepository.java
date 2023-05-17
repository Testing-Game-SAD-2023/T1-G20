package org.sad.classUTrepository.repository;

import java.util.List;
import java.util.Optional;

import org.sad.classUTrepository.entity.ClassUT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ClassUTRepository extends JpaRepository<ClassUT, Integer> {
	
	List<ClassUT> findAllClassUTByAdmin_Surname(String surname);
	List<ClassUT> findAllClassUTByComplexity(int complexity);
	ClassUT findByid(int id);
	ClassUT findByname(String className);
	@Transactional
	@Modifying
	@Query("UPDATE ClassUT c set c.name = ?1 where c.id = ?2")
	void updateClassUTName(String name, int id);
}
