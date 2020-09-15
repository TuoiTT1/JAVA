package com.vn.dao;

import java.util.List;

import com.vn.entity.Employee;

public interface EmployeeDAO {

	public void insert(Employee employee);

	public List<Employee> getAllEmployees();
}
