package org.sad.classUTrepository.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "administrators", catalog = "classut_repo")
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;
	
	@Column(name = "NAME", nullable = false, length = 45)
	private String name;
	@Column(name = "SURNAME",nullable = false, length = 45)
	private String surname;
	@OneToMany(mappedBy = "admin", 
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<ClassUT> classes;
}
