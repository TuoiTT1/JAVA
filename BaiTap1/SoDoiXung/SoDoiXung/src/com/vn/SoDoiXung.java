package com.vn;

import java.util.HashMap;
import java.util.Map;

public class SoDoiXung {
	private String input;

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public void kiemTraSoDoiXung() {
		// Kiem tra so doi xung
//		StringBuilder sBuilder = new StringBuilder(input);
//		String reverseInput = sBuilder.reverse().toString();
//
//		if (reverseInput.equals(input)) {
//			System.out.println("So " + input + " la so doi xung");
//			return;
//		} else {
//			System.out.println("So " + input + " khong phai so doi xung");
//		}
		
		char[] arr = input.toCharArray();
		if (isSoiDoiXung(arr)) {
			System.out.println("So " + input + " la so doi xung");
			return;
		} else {
			System.out.println("So " + input + " khong phai so doi xung");
		}
		// Bien doi so doi xung
		// Dem so lan xuat hien cua cac chu so
		Map<Character, Integer> countMap = new HashMap<Character, Integer>();
		int n = arr.length;
		int count;
		boolean isCountLe = false;
		char charLe = 0;
		char[] b = new char[n];

		for (int i = 0; i < n; i++) {
			if (countMap.containsKey(arr[i])) {
				count = countMap.get(arr[i]);
				countMap.replace(arr[i], count + 1);
			} else {
				countMap.put(arr[i], 1);
			}
		}
		// xet truong hop dac biet voi chu so 0
		if (countMap.get('0') != null && countMap.get('0') >= 2) {
			System.out.println("So " + input + " khong the bien doi thanh so doi xung");
			return;
		}

		// tim so lan xuat hien le lan
		for (Map.Entry<Character, Integer> key : countMap.entrySet()) {
			if (key.getValue() % 2 == 1) {
				charLe = key.getKey();
				isCountLe = true;
				break;
			}
		}
		// Truong hop tat ca so lan xuat hien cua 1 so deu la so chan
		// thi co the bien doi thanh so doi xung
		if (!isCountLe) {
			int j = 0;
			for (Map.Entry<Character, Integer> key : countMap.entrySet()) {
				for (int i = 1; i <= key.getValue() / 2; i++) {
					b[j] = key.getKey();
					b[n - j - 1] = key.getKey();
					j++;
				}
			}

			System.out.print("Bien doi so " + input + " thanh so doi xung: ");
			printCharArr(b);
		}
		// Truong hop co so xuat hien le lan
		else {
			int j = 0;
			for (Map.Entry<Character, Integer> key : countMap.entrySet()) {
				if (key.getKey().equals('0')) {
					continue;
				}
				for (int i = 1; i <= key.getValue() / 2; i++) {
					b[j] = key.getKey();
					b[n - j - 1] = key.getKey();
					j++;
				}
			}
			b[n / 2] = charLe;

			// xet tinh doi xung
			if (isSoiDoiXung(b)) {
				System.out.print("Bien doi so " + input + " thanh so doi xung: ");
				printCharArr(b);
			} else {
				System.out.println("Khong the bien doi " + input + " thanh so doi xung");
			}

		}
	}

	public static boolean isSoiDoiXung(char[] a) {
		int n = a.length;
		if (n == 1) {
			return true;
		}
		for (int i = 0; i < n / 2; i++) {
			if (a[i] != a[n - i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static void printCharArr(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}
}
