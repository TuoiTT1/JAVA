package main;

import com.vn.SoDoiXung;

public class Main {

	public static void main(String[] args) {

		SoDoiXung soDoiXung = new SoDoiXung();

		System.out.println("Test:");
		soDoiXung.setInput("1234321");
		soDoiXung.kiemTraSoDoiXung();

		System.out.println("Test:");
		soDoiXung.setInput("1234123");
		soDoiXung.kiemTraSoDoiXung();

		System.out.println("Test:");
		soDoiXung.setInput("12344123");
		soDoiXung.kiemTraSoDoiXung();

		System.out.println("Test:");
		soDoiXung.setInput("123440321");
		soDoiXung.kiemTraSoDoiXung();

		System.out.println("Test:");
		soDoiXung.setInput("1203440321");
		soDoiXung.kiemTraSoDoiXung();

	}
}
