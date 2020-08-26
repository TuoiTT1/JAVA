package com.vn;

import com.vn.controller.Calculator;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello!");

		float result;
		Calculator calculator = new Calculator();

		calculator.setNumber1(7);
		calculator.setNumber2(5);
		calculator.setOperation("+");
		result = calculator.calculator();
		System.out.println(calculator.getNumber1() + " " + calculator.getOperation() + " " + calculator.getNumber2()
				+ " = " + result);
		
		calculator.setNumber1(7);
		calculator.setNumber2(5);
		calculator.setOperation("-");
		result = calculator.calculator();
		System.out.println(calculator.getNumber1() + " " + calculator.getOperation() + " " + calculator.getNumber2()
				+ " = " + result);
		
		calculator.setNumber1(7);
		calculator.setNumber2(5);
		calculator.setOperation("*");
		result = calculator.calculator();
		System.out.println(calculator.getNumber1() + " " + calculator.getOperation() + " " + calculator.getNumber2()
				+ " = " + result);
		
		calculator.setNumber1(7);
		calculator.setNumber2(5);
		calculator.setOperation("/");
		result = calculator.calculator();
		System.out.println(calculator.getNumber1() + " " + calculator.getOperation() + " " + calculator.getNumber2()
				+ " = " + result);

	}
}
