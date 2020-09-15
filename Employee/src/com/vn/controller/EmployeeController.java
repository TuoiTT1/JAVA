package com.vn.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
			FileReader fr = new FileReader(pathFileCsv);
			BufferedReader br = new BufferedReader(fr);
			String line;
			Employee employee;
			String[] arrSplits;

			int i = 0;
			while ((line = br.readLine()) != null) {
				if (i > 0) {
					arrSplits = line.split(",");

					employee = new Employee();
					employee.setId(Integer.valueOf(arrSplits[0].trim()));
					employee.setName(arrSplits[1].trim());
					employee.setAge(Integer.valueOf(arrSplits[2].trim()));
					employee.setSalary(Float.valueOf(arrSplits[3].trim()));
					employee.setBirthDay(arrSplits[4].trim());
					employeeDAO.insert(employee);
				}
				i++;
			}

			System.out.println("ArrayList -> size of list: " + employeeDAO.getAllEmployees().size());

			Set<Employee> setEmps = new HashSet<Employee>(employeeDAO.getAllEmployees());
			System.out.println("HashSet -> size of list: " + setEmps.size());

			Set<Employee> treeSetEmps = new TreeSet<Employee>(employeeDAO.getAllEmployees());
			System.out.println("Tree Set -> size of list: " + treeSetEmps.size());

			return new ArrayList<Employee>(setEmps);

		} catch (Exception e) {
			System.out.println("Something when read file csv: " + e.getMessage());
			return null;
		}
	}

	public void showAllEmployees(List<Employee> emps) {
		emps.forEach(System.out::println);
	}

	public List<Employee> sortByName(List<Employee> emps) {
		emps.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				if (o1.getName().compareTo(o2.getName()) < 0)
					return -1;
				if (o1.getName().compareTo(o2.getName()) > 0)
					return 1;
				return 0;
			}
		});
		return emps;
	}

	public List<Employee> sortBySalaryDESC(List<Employee> emps) {
		emps.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				if (o1.getSalary().compareTo(o2.getSalary()) > 0)
					return -1;
				if (o1.getSalary().compareTo(o2.getSalary()) < 0)
					return 1;
				return 0;
			}
		});
		return emps;
	}

	public List<Employee> filterThreeYoungersHaveBestSalary(List<Employee> emps, Float bestSalary) {
		List<Employee> list = emps.stream()
				.sorted(Comparator.comparing(Employee::getAge)
						.thenComparing(Comparator.comparing(Employee::getSalary).reversed()))
				.collect(Collectors.toList());
		return list.subList(0, 3);

	}

	public List<Employee> containNameList(List<Employee> emps, String s) {
		return emps.stream().filter(emp -> emp.getName().contains(s)).collect(Collectors.toList());
	}
}
