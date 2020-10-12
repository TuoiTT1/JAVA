package com.vn.dao;

import com.vn.entity.Account;

public interface AccountDAO {

	public Account findByEmail(String email);

	public Account login(String userName, String password);

}
