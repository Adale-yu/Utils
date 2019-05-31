package test.file;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		String basePath = "data";
		
		String newstr = "test";
		try {
//			File file = FileUtil.createFile(basePath, "demo.txt");
//			FileUtil.writeFileContent(file, newstr);
			
//			FileUtil.copyFileUsingJava7Files(file, new File(basePath+File.separator+"copy_"+file.getName()));
//			FileUtil.copyFileUsingFileStreams(file, new File(basePath+File.separator+"copy_"+file.getName()));
//			FileUtil.copyFileUsingFileChannel(file, new File(basePath+File.separator+"copy_"+file.getName()));
//			FileUtil.copyDirectory(basePath+File.separator+"java", basePath+File.separator+"copy");
			FileUtil.deleteDirectory(new File("C:\\Users\\Administrator\\eclipse-test\\Test\\data"));
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
