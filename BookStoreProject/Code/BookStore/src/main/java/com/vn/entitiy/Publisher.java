package com.vn.entitiy;

import java.io.Serializable;

import lombok.Data;

@Data
public class Publisher implements Serializable {

	private static final long serialVersionUID = -1073365573102415372L;

	private Integer id;
	private String publisherName;
	private String url;
	private String publisherAddress;
	private String publisherPhone;

}
