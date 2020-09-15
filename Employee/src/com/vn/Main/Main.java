package com.vn.Main;

import java.util.List;

import com.vn.controller.EmployeeController;
import com.vn.entity.Employee;

public class Main {

	public static void main(String[] args) {
		EmployeeController controller = new EmployeeController();
		String pathFileCsv = System.getProperty("user.dir") + "\\input\\employee.csv";

		// 1. Tạo ra 1 list danh sách nhân viên tùy ý
		System.out.println("\n========1. List origin=========");
		List<Employee> emps = controller.readDataCSV(pathFileCsv);
		System.out.println("Size: " + emps.size());
		controller.showAllEmployees(emps);

		// 2. Sắp xếp theo thứ tự của name trong employee

		System.out.println("\n========2. List sort by name========");
		List<Employee> empsSortByName = controller.sortByName(emps);
		System.out.println("Size: " + empsSortByName.size());
		controller.showAllEmployees(empsSortByName);

		// 3. Sắp xếp theo mức lương tư cao tới thấp
		System.out.println("\n========3. List sort by salary (Desc)========");
		List<Employee> empsSortBySalaryDESC = controller.sortBySalaryDESC(emps);
		System.out.println("Size: " + empsSortBySalaryDESC.size());
		controller.showAllEmployees(empsSortBySalaryDESC);

		// 4. Lọc ra 3 người trẻ nhất vào có mức lương cao nhất
		System.out.println("\n========4. List three employees have best salary========");
		List<Employee> filterAndGroups = controller.filterThreeYoungersHaveBestSalary(emps,
				empsSortBySalaryDESC.get(0).getSalary());
		System.out.println("Size: " + filterAndGroups.size());
		controller.showAllEmployees(filterAndGroups);

		// 5. Tìm ra các Employee có tên chứa kí tự N
		String s = "N";
		System.out.println("\n========5. List of employee contain character " + s + " in Name ========");
		List<Employee> containNameList = controller.containNameList(emps, "N");
		System.out.println("Size: " + containNameList.size());
		controller.showAllEmployees(containNameList);
	}
}
