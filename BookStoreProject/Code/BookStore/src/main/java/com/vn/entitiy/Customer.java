package com.vn.entitiy;

import java.io.Serializable;

import lombok.Data;

@Data
public class Customer implements Serializable {

	private static final long serialVersionUID = 1965647544478830772L;

	private Integer id;
	private String customerName;
	private String customerEmail;
	private String customerPhone;
	private String customerAddress;
	private User user;

	public Customer() {
	}

	public Customer(Integer id, String customerName, String customerEmail, String customerPhone, String customerAddress,
			User user) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.user = user;
	}

}
