package com.vn.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Serializable, Comparable<Employee>{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Integer age;
	private Float salary;
	private Date birthDay;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	public void setBirthDay(String birthDayStr) {
		this.birthDay = convertStringToDate(birthDayStr);
	}
	
	
	public String convertDateToString(Date date) {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-dd-MM");
		return formatDate.format(date);
	}

	public Date convertStringToDate(String str) {
		try {
			return new SimpleDateFormat("yyyy/MM/dd").parse(str);
		} catch (Exception e) {
			System.out.println("Something when convert String to Date: " + e.getMessage());
			return null;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (this == o)
			return true;

		if (!(o instanceof Employee))
			return false;

		Employee emp = (Employee) o;
		if (this.getId().equals(emp.getId()) && this.getName().equals(emp.getName())
				&& this.getBirthDay().equals(emp.getBirthDay()) && this.getAge().equals(emp.getAge())
				&& this.getSalary().equals(emp.getSalary()))
			return true;

		return false;
	}

	@Override
	public int hashCode() {
		int result = 17;
		if (this.getId() != null) {
			result = 31 * result + this.getId().hashCode();
		}
		if (this.getName() != null) {
			result = 31 * result + this.getName().hashCode();
		}
		if (this.getBirthDay() != null) {
			result = 31 * result + this.getBirthDay().hashCode();
		}
		if (this.getAge() != null) {
			result = 31 * result + this.getAge().hashCode();
		}
		if (this.getSalary() != null) {
			result = 31 * result + this.getSalary().hashCode();
		}
		return result;
	}

	@Override
	public int compareTo(Employee o) {
		return this.hashCode() - o.hashCode();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", birthDay="
				+ convertDateToString(birthDay) + "]";
	}

	
}
