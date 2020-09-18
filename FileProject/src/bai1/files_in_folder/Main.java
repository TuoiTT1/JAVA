package bai1.files_in_folder;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

public class Main {

	public static void main(String[] args) {
		// Tìm tất cả các đường dẫn có đuôi là .txt trong Folder lớn
		String folder = System.getProperty("user.dir") + "\\input\\bai1";
		File dir = new File(folder);

		searchFile(dir);
	}

	public static void searchFile(File dir) {
		File[] list = dir.listFiles();
		for (File file : list) {
			if (file.isDirectory()) {
				searchFile(file);
			} else {
				if (FilenameUtils.getExtension(file.getName()).equals("txt")) {
					System.out.println(file.getAbsolutePath());
				}
			}
		}

	}
}
