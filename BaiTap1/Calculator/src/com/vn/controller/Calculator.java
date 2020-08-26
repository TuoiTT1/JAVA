package com.vn.controller;

public class Calculator {
	private float number1;
	private float number2;
	private String operation;

	public Calculator() {
	}

	public Calculator(float number1, float number2, String operation) {
		super();
		this.number1 = number1;
		this.number2 = number2;
		this.operation = operation;
	}

	public float calculator() {
		switch (operation) {
		case "+":
			return number1 + number2;
		case "-":
			return number1 - number2;
		case "*":
			return number1 * number2;
		default:
			return number1 / number2;
		}
	}

	public float getNumber1() {
		return number1;
	}

	public void setNumber1(float number1) {
		this.number1 = number1;
	}

	public float getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
