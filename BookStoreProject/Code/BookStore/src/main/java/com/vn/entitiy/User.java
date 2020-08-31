package com.vn.entitiy;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = -2503869961148631851L;

	private Integer id;
	private String userName;
	private String password;
	private Role role;

	public User() {
	}

	public User(Integer id, String userName, String password, Role role) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

}
