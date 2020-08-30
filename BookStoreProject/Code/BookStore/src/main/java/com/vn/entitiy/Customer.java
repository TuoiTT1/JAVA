package com.vn.entitiy;

import java.io.Serializable;

import lombok.Data;

@Data
public class Customer implements Serializable {

	private static final long serialVersionUID = 1965647544478830772L;

	private Integer ID;
	private String CustomerName;
	private String CustomerEmail;
	private String CustomerPhone;
	private String CustomerAddress;
	private User user;

	public Customer() {
	}

	public Customer(Integer iD, String customerName, String customerEmail, String customerPhone, String customerAddress,
			User user) {
		super();
		ID = iD;
		CustomerName = customerName;
		CustomerEmail = customerEmail;
		CustomerPhone = customerPhone;
		CustomerAddress = customerAddress;
		this.user = user;
	}

}
