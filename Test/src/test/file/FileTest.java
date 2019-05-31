package test.file;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		String basePath = "data";
		
		String newstr = "test";
		try {
			File file = FileUtil.createFile(basePath, "demo.txt");
			FileUtil.writeFileContent(file, newstr);
			
//			FileUtil.copyFileUsingJava7Files(file, new File(basePath+File.separator+"copy_"+file.getName()));
//			FileUtil.copyFileUsingFileStreams(file, new File(basePath+File.separator+"copy_"+file.getName()));
//			FileUtil.copyFileUsingFileChannel(file, new File(basePath+File.separator+"copy_"+file.getName()));
			FileUtil.copyDirectory(basePath, basePath+File.separator+"copy");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
