package com.vn;

public class Main {

	public static void main(String[] args) {
		String beforeCode = null;
		String prefix = "P";
		int uperUnit = 10;
		int length = 10;
		String charCode;

		// test with charCode = "0"
		charCode = "0"; // charCode co 1 ky tu
		String id1 = generateID(beforeCode, prefix, uperUnit, length, charCode);
		String id2 = generateID(id1, prefix, uperUnit, length, charCode);
		System.out.println(id1);
		System.out.println(id2);

		// test with charCode <> "0"
		charCode = "O";
		String id3 = generateID(beforeCode, prefix, uperUnit, length, charCode);
		String id4 = generateID(id3, prefix, uperUnit, length, charCode);
		System.out.println(id3);
		System.out.println(id4);
	}

	public static String generateID(String beforeCode, String prefix, int uperUnit, int length, String charCode) {
		String id = null;
		if (charCode.equals("0")) {
			String formatStr = prefix + "%0" + (length - prefix.length()) + "d";
			if (beforeCode == null) {
				id = String.format(formatStr, uperUnit);
			} else {
				beforeCode = beforeCode.replaceAll("[^0-9]", "0");
				int number = Integer.parseInt(beforeCode);
				number = number + uperUnit;
				id = String.format(formatStr, number);
			}
		} else {
			String formatStr = prefix + "%" + (length - prefix.length()) + "s";
			if (beforeCode == null) {
				id = String.format(formatStr, uperUnit);
				id = id.replace(" ", charCode);
			} else {
				beforeCode = beforeCode.replaceAll("[^0-9]", "0");
				int number = Integer.parseInt(beforeCode);
				number = number + uperUnit;
				id = String.format(formatStr, number);
				id = id.replace(" ", charCode);
			}
		}
		return id;
	}
}
