package com.vn.entitiy;

import java.io.Serializable;

import lombok.Data;

@Data
public class Author implements Serializable {

	private static final long serialVersionUID = 2754426018554187418L;

	private Integer id;
	private String authorName;
	private String authorAddress;

}
