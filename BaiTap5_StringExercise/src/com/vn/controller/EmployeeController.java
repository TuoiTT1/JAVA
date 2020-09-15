package com.vn.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.vn.dao.EmployeeDAO;
import com.vn.dao.EmployeeDAOImpl;
import com.vn.entity.Employee;

public class EmployeeController {

	private EmployeeDAO employeeDAO;

	public EmployeeController() {
		employeeDAO = new EmployeeDAOImpl();
	}

	@SuppressWarnings("resource")
	public List<Employee> readDataCSV(String pathFileCsv) {
		try {
			File file = new File(pathFileCsv);
			Scanner inp = new Scanner(file);
			String line;
			Employee employee;
			String[] arrSplits;

			int i = 0;
			while (inp.hasNext()) {
				line = inp.nextLine();
				if (i > 0) {
					arrSplits = line.split(",");

					employee = new Employee();
					employee.setId(Integer.valueOf(arrSplits[0].trim()));
					employee.setName(arrSplits[1].trim());
					employee.setAge(Integer.valueOf(arrSplits[2].trim()));
					employee.setSalary(Float.valueOf(arrSplits[3].trim()));
					employee.setBirthDay(convertStringToDate(arrSplits[4].trim()));
					employeeDAO.insert(employee);
				}
				i++;
			}
			return employeeDAO.getAllEmployees();

		} catch (Exception e) {
			System.out.println("Something when read file csv: " + e.getMessage());
			return null;
		}
	}

	public void showAllEmployees() {
		for (Employee employee : employeeDAO.getAllEmployees()) {
			System.out.println("Employee: " + employee.getId());
			System.out.println("\tName: " + employee.getName());
			System.out.println("\tAge: " + employee.getAge());
			System.out.println("\tSalary: " + employee.getSalary());
			System.out.println("\tBirth day: " + convertDateToString(employee.getBirthDay()));

			System.out.println();
		}
	}

	private String convertDateToString(Date date) {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-dd-MM");
		return formatDate.format(date);
	}

	private Date convertStringToDate(String str) {
		try {
			return new SimpleDateFormat("yyyy/MM/dd").parse(str);
		} catch (Exception e) {
			System.out.println("Something when convert String to Date: " + e.getMessage());
			return null;
		}
	}
}
