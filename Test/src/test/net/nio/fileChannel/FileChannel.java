package test.net.nio.fileChannel;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileChannel
{
	private final static String path = "data";
	private final static String test = path + File.separator + "test.txt";	// 服务器配置
	
	//案例1是采用FileInputStream读取文件内容的：
	public static void method1() {
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(test));
			byte[] buf = new byte[1024];
			int bytereadCount = in.read(buf);
			while(bytereadCount != -1) {
				for(int i = 0;i<bytereadCount;i++) {
					System.out.println((char)buf[i]);
				}
				bytereadCount = in.read(buf);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try
			{
				in.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		method1();
	}
}
