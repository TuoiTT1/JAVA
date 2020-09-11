package com.vn.Main;

import com.vn.controller.EmployeeController;

public class Main {

	public static void main(String[] args) {
		EmployeeController controller = new EmployeeController();
		String pathFileCsv = System.getProperty("user.dir") + "\\input\\employee.csv";
		
		controller.readDataCSV(pathFileCsv);
		
		controller.showAllEmployees();

	}
}
