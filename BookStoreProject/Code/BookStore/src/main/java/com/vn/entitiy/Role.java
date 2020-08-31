package com.vn.entitiy;

import java.io.Serializable;

import lombok.Data;

@Data
public class Role extends Object implements Serializable {

	private static final long serialVersionUID = 7421689016963724957L;

	private Integer id;
	private String roleName;

	public Role() {
	}

	public Role(Integer id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

}
