package com.vn.dao;

import java.util.List;

import com.vn.entitiy.Customer;

public interface CustomerDAO {

	public Integer delete(int id);

	public Customer create(Customer customer);

	public Customer update(Customer customer);

	public List<Customer> getAll();

	public Customer findById(int id);

}
