package com.vn.entitiy;

import java.io.Serializable;

import lombok.Data;

@Data
public class Publisher implements Serializable {

	private static final long serialVersionUID = -1073365573102415372L;

	private Integer ID;
	private String PublisherName;
	private String URL;
	private String PublisherAddress;
	private String PublisherPhone;

	public Publisher() {
	}

	public Publisher(Integer iD, String publisherName, String uRL, String publisherAddress, String publisherPhone) {
		super();
		ID = iD;
		PublisherName = publisherName;
		URL = uRL;
		PublisherAddress = publisherAddress;
		PublisherPhone = publisherPhone;
	}

}
