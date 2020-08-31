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

	public Publisher() {
	}

	public Publisher(Integer id, String publisherName, String url, String publisherAddress, String publisherPhone) {
		super();
		this.id = id;
		this.publisherName = publisherName;
		this.url = url;
		this.publisherAddress = publisherAddress;
		this.publisherPhone = publisherPhone;
	}

}
