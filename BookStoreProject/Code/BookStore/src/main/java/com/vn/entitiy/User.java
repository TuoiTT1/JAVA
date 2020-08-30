package com.vn.entitiy;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = -2503869961148631851L;

	private Integer ID;
	private String UserName;
	private String Password;
	private Role role;

	public User() {
	}

	public User(Integer iD, String userName, String password, Role role) {
		super();
		ID = iD;
		UserName = userName;
		Password = password;
		this.role = role;
	}

}
