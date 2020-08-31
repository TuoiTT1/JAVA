package com.vn.entitiy;

import java.io.Serializable;

import lombok.Data;

@Data
public class Book implements Serializable {

	private static final long serialVersionUID = 760670554899843542L;

	private Integer id;
	private String title;
	private Integer year;
	private Float price;
	private Author author;
	private Publisher publisher;

}
