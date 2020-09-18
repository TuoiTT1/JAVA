package bai3.create_folder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {

	static final String FOLDER_OUTPUT = System.getProperty("user.dir") + "\\output\\bai3\\output";

	public static void main(String[] args) throws IOException {
		// Tao 1 thu muc chua ton tai
		File file = new File(FOLDER_OUTPUT);
		if (!file.exists()) {
			Files.createDirectories(Paths.get(FOLDER_OUTPUT));
			
			Files.write(Paths.get(FOLDER_OUTPUT, "output.txt"),
					"Bài Tập 3\ncreate directory\n".getBytes(StandardCharsets.UTF_8), 
					StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
			System.out.println("done");
			
		}
	}
}
