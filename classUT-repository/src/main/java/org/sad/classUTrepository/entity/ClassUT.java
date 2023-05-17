package org.sad.classUTrepository.entity;

import java.util.Date;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "classuts", catalog = "classut_repo")
@Data
public class ClassUT {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idclassUT", unique = true, nullable = false)
	private int id;
	
	@Column(name = "name", nullable = false, length = 45)
	private String name;
	@Column(name = "filetype", nullable = false, length = 45)
	private String type;
	@Column(name = "complexity", nullable = false)
	private int complexity;
	@Column(name = "added_date", nullable = false)
	private Date added;
	@Column(name = "last_update")
	private Date lastupdate;
	@Column(name = "location", nullable = false, length = 45)
	private String location;
	@Column(name = "size", nullable = false)
	private long size;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "admin", nullable = false)
	private Admin admin;
}
 