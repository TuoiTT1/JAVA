package com.vn.dao;

import java.util.List;

import com.vn.entitiy.Role;

public interface RoleDAO {

	public Integer delete(int id);

	public Role create(Role role);

	public Role update(Role role);

	public List<Role> getAll();

	public Role findById(int id);

	public boolean isRole(String roleName);

}
