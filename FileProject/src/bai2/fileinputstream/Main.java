package bai2.fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	static final String FIle_INP = System.getProperty("user.dir") + "\\input\\bai2\\input.txt";

	public static void main(String[] args) {
		System.out.println("Read file by FileInputStream:");
		File file = new File(FIle_INP);
		try {
			@SuppressWarnings("resource")
			FileInputStream fis = new FileInputStream(file);
			
			byte[] bytes = new byte[1020 * 8 * 5];
			fis.read(bytes);
			for (byte b : bytes) {
				System.out.print((char)b);
			}
//			int c;
//			while ((c = fis.read()) != -1) {
//				System.out.print((char) c);
//			}
		} catch (FileNotFoundException e) {
			System.out.println("File input khong ton tai");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Loi IOException");
			e.printStackTrace();
		}

	}
}
