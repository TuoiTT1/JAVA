package com.vn.dao;

import java.util.ArrayList;
import java.util.List;

import com.vn.entity.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	private List<Employee> employees;

	public EmployeeDAOImpl() {
		employees = new ArrayList<Employee>();
	}

	@Override
	public void insert(Employee employee) {
		if (employees == null) {
			employees = new ArrayList<Employee>();
		}
		employees.add(employee);

	}

	@Override
	public List<Employee> getAllEmployees() {
		return employees;
	}

}
