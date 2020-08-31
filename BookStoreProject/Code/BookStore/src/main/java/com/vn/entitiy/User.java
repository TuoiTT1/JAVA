package com.vn.entitiy;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = -2503869961148631851L;

	private String userName;
	private String password;
	private Role role;

}
