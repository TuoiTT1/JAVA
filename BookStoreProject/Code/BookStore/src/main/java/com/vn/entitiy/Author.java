package com.vn.entitiy;

import java.io.Serializable;

import lombok.Data;

@Data
public class Author implements Serializable {

	private static final long serialVersionUID = 2754426018554187418L;

	private Integer ID;
	private String AuthorName;
	private String AuthorAddress;

	public Author() {
	}

	public Author(Integer iD, String authorName, String authorAddress) {
		super();
		ID = iD;
		AuthorName = authorName;
		AuthorAddress = authorAddress;
	}

}
