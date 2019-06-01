package test.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	
	public final static String lineSeparator = System.getProperty("line.separator");

	/**
	 * Desp 获取path文件夹下所有的xls和xlsx文件
	 * @param path
	 * @return
	 */
	public static List<File> getFileList(String path){
		List<File> list = new ArrayList<File>();
		File dir = new File(path);
		File[] files = dir.listFiles();
		
		if(files != null) {
			for(File file : files) {
				if(file.isFile()) {
					String fileName = file.getName();
					if(fileName.endsWith("xlsx") || fileName.endsWith("xls")) {
						System.out.println(file.toString());
						list.add(file);
					}
				}
				if(file.isDirectory()) {
					//文件夹，不做处理
				}
			}
		}
		
		return list;
	}
	
	/**
	 * 使用FileInputStream读取文件
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String readFromFileUsingInputStream(File file) throws IOException {
		if(!file.exists() || file.isDirectory()) {
			throw new FileNotFoundException();
		}
		StringBuffer sb = new StringBuffer();
		FileInputStream fis = new FileInputStream(file);
		//解决结尾空字符
		//1.获取文件的大小
		/*byte[] buff = new byte[(int) file.length()];
		fis.read(buff);
		sb.append(new String(buff, "GBK"));*/
		
		//2.fis.read(byte[])方法返回读取的字符数组长度
		byte[] buff2 = new byte[1024];
		int temp = 0;
		while((temp=fis.read(buff2)) != -1) {
			sb.append(new String(buff2, 0 ,temp, "GBK"));
			buff2 = new byte[1024];
		}
		
		fis.close();
		return sb.toString();
	}
	
	/**
	 * 用BufferedReader读取文件
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String readFromFileUsingBufferedReader(File file) throws IOException {
		if(!file.exists() || file.isDirectory()) {
			throw new FileNotFoundException();
		}
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
		String temp = "";
		while((temp=br.readLine())!=null) {
			sb.append(temp).append(lineSeparator);
		}
		
		br.close();
		return sb.toString();
	}
	
	 /**
	 * Desp 向文件中写入内容
	 * @param file
	 * @param newstr
	 * @return
	 * @throws IOException
	 */
	public static boolean writeFileContent(File file,String newstr) throws IOException{
		 if(!file.exists() || !file.isFile()) {
			 System.out.println("文件不存在，请先创建文件");
			 return false;
		 }
		 
		 FileInputStream fis = null;
		 InputStreamReader isr = null;
		 BufferedReader br = null;
		 
		 FileOutputStream fos = null;
		 PrintWriter pw = null;
		 try {
			 fis = new FileInputStream(file);
			 isr = new InputStreamReader(fis);
			 br = new BufferedReader(isr);
			 
			//添加原有内容
			StringBuffer sb = new StringBuffer();
			String tempStr = "";
			while((tempStr = br.readLine()) != null) {
				 sb.append(tempStr).append(lineSeparator);
			}
			 
			//添加新内容
			sb.append(newstr);
			 
			//1.用FileOutputStream输出，字节流输出
			fos = new FileOutputStream(file);
			/*fos.write(sb.toString().getBytes("GBK"));
			fos.flush();*/
			 
			//2.用PrintWriter输出，字符流输出
			pw = new PrintWriter(new OutputStreamWriter(fos, "GBK"));
			pw.write(sb.toString());
			pw.flush();
		} finally {
			//关闭资源
			if (pw != null) {
			    pw.close();
			}
			if (fos != null) {
			    fos.close();
			}
			if (br != null) {
			    br.close();
			}
			if (isr != null) {
			    isr.close();
			}
			if (fis != null) {
			    fis.close();
			}
		}
		return true;
		 
	}
	
	/**
	 * Desp 创建文件
	 * @param path
	 * @param fileName
	 * @return
	 */
	public static File createFile(String path, String fileName) {
		File file = new File(path+ File.separator + fileName);
		try {
			if(!file.exists()) {
				file.createNewFile();
				System.out.println("成创建文件：" + file.getPath());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return file;
	}
	
	/**
	 * 创建文件夹
	 * @param path
	 * @param fileName
	 * @return
	 */
	public static File createDirectory(String path, String fileName) {
		File file = new File(path + File.separator + fileName);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		return file;
	}
	
	/**
	 * Desp 使用fileStreams复制文件
	 * targetFile 不一定需要存在，创建FileOutputStream(targetFile)会创建该文件
	 * targetFile 可以存在，存在则覆盖原数据
	 * @param sourceFile
	 * @param targetFile
	 * @throws IOException 
	 */
	public static void copyFileUsingFileStreams(File sourceFile, File targetFile) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(sourceFile);
			fos = new FileOutputStream(targetFile);
			
			byte[] buf = new byte[1024];
			int bytesRead = 0;
			while((bytesRead=fis.read(buf)) != -1) {
				fos.write(buf, 0, bytesRead);
			}
		} finally {
			fis.close();
			fos.close();
		}
	}
	
	/**
	 * Desp 使用fileChannel.transferFrom复制文件
	 * targetFile 不一定需要存在，创建FileOutputStream(targetFile)会创建该文件
	 * targetFile 可以存在，存在则覆盖原数据
	 * @param sourceFile
	 * @param targetFile
	 * @throws IOException
	 */
	public static void copyFileUsingFileChannel(File sourceFile, File targetFile) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel input = null;
		FileChannel output = null;
		try {
			fis = new FileInputStream(sourceFile);
			fos = new FileOutputStream(targetFile);
			input = fis.getChannel();
			output = fos.getChannel();
			
			output.transferFrom(input, 0, input.size());
		} finally {
			fis.close();
			fos.close();
			input.close();
			output.close();
		}
	}
	
	/**
	 * Desp 使用Apache Commons IO包
	 * @param sourceFile
	 * @param targetFile
	 */
	public static void copyFileUsingApacheCommonsIO(File sourceFile, File targetFile) {
//		FileUtils.copyFile(sourceFile, targetFile);
	}
	
	/**
	 * Desp 使用java7的Files类复制
	 * targetFile不能已存在
	 * @param sourceFile
	 * @param targetFile
	 * @throws IOException
	 */
	public static void copyFileUsingJava7Files(File sourceFile, File targetFile) throws IOException {
		Files.copy(sourceFile.toPath(), targetFile.toPath());
	}
	
	/**
	 * Desp 复制文件夹
	 * @param sourcePath
	 * @param targetPath
	 * @throws IOException
	 */
	public static void copyDirectory(String sourcePath, String targetPath) throws IOException {
		if(targetPath.contains(sourcePath)) {
			//target文件夹不能在源文件下,递归调用会有bug
			System.out.println("Failing...");
			System.out.println("target文件夹不能在源文件下...");
			return;
		}
		File targetDir = new File(targetPath);
		if(!targetDir.exists()) {
			targetDir.mkdirs();
		}
		
		File[] sourceFiles = new File(sourcePath).listFiles();
		for(File sourceFile:sourceFiles) {
			if(sourceFile.isFile()) {
				File targetFile = new File(targetDir.getAbsolutePath() + File.separator + sourceFile.getName());
				copyFileUsingFileStreams(sourceFile, targetFile);
			}
			
			if(sourceFile.isDirectory()) {
				String sPath = sourceFile.getAbsolutePath();
				String tPath = targetDir.getAbsolutePath() + File.separator + sourceFile.getName();
				copyDirectory(sPath, tPath);
			}
		}
	}
	
	/**
	 * Desp 删除文件
	 * @param file
	 */
	public static void deleteFile(File file) {
		if(file.exists()) {
			file.delete();
		}
	}
	
	/**
	 * Desp 删除文件夹
	 * @param fileDir
	 */
	public static void deleteDirectory(File fileDir) {
		if(fileDir.exists() && fileDir.isDirectory()) {
			File[] files = fileDir.listFiles();
			for(File file : files) {
				if(file.isFile()) {
					file.delete();
				}
				
				//要利用File类的delete()方法删除目录时，必须保证该目录下没有文件或者子目录，否则删除失败
				if(file.isDirectory()) {
					deleteDirectory(file);
					file.delete();
				}
			}
		}
	}
	
	/**
	 * 重命名文件
	 * @param path
	 * @param oldName
	 * @param newName
	 */
	public static void renameFile(String path, String oldName, String newName) {
		if(!oldName.equals(newName)) {
			File oldFile = new File(path + File.separator + oldName);
			File newFile = new File(path + File.separator + newName);
			if(newFile.exists()) {
				System.out.println("已存在同名的文件...重命名失败");
				return;
			}
			
			oldFile.renameTo(newFile);
		}
	}
	
	/**
	 * 转移文件目录
	 * @param fileName
	 * @param oldPath
	 * @param newPath
	 * @param cover
	 */
	public static void changeDirectory(String fileName, String oldPath, String newPath, boolean cover) {
		if(!oldPath.equals(newPath)) {
			File oldFile = new File(oldPath + File.separator + fileName);
			File newFile = new File(newPath + File.separator + fileName);
			if(newFile.exists()) {
				if(cover) {
					oldFile.renameTo(newFile);
				}else {
					System.out.println("文件已存在，不能覆盖...");
				}
			} else {
				oldFile.renameTo(newFile);
			}
		}
	}
	
}
