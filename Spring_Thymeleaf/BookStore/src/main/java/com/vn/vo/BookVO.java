package com.vn.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String author;

	private String description;

	private String imageURL;

	private byte isDeleted;

	private String name;

	private Float price;

	private String publisher;

	private Integer quantity;

	private Integer yearOfPublication;
}
