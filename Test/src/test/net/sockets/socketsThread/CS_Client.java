package test.net.sockets.socketsThread;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class CS_Client
{
	public static void main(String[] args) {
		try {
			Socket sk = new Socket("127.0.0.1",38380);
			System.out.println("客户端已经开启----");
			
			//输出字符到服务器
			OutputStream os = sk.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.println("user:admin,password:123456");
			pw.flush();
			sk.shutdownOutput();
			
			//读取服务器回传的字符
			//BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream(),"UTF-8"));
			//利用socket.getInputStream()方法获取资源的字节输入流
			InputStream is = sk.getInputStream();
    		//将字节输入流转换为字符输入流,如果不指定编码，中文可能会出现乱码
    		InputStreamReader isd = new InputStreamReader(is,"UTF-8");
    		//为字符输入流添加缓冲，提高读取效率
    		BufferedReader br = new BufferedReader(isd);
    		
			String data = null;
			while((data = br.readLine())!=null) {
				System.out.println(data);
			}
			
			is.close();
			isd.close();
			br.close();
			pw.close();
			sk.close();
		}catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
}
