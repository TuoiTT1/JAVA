package com.vn.dao;

import java.util.List;

import com.vn.entitiy.User;

public interface UserDAO {

	public Integer delete(int id);

	public User create(User user);

	public User update(User user);

	public List<User> getAll();

	public User findById(int id);

	public boolean login(String userName, String password);

}
