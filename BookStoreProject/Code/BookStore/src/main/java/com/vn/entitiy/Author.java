package com.vn.entitiy;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "author")
public class Author implements Serializable {

	private static final long serialVersionUID = 2754426018554187418L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "AuthorName")
	private String authorName;

	@Column(name = "AuthorAddress")
	private String authorAddress;

}
