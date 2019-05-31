package test.net.sockets;

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
			//1、创建客户端Socket，指定服务器地址和端口
			Socket sk = new Socket("127.0.0.1",10086);
			//2、获取输出流，向服务器端发送信息
			OutputStream os = sk.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.println("user:admin,password:123456");
			pw.flush();
			sk.shutdownOutput();
			//3、获取输入流，并读取服务器端的响应信息
			InputStream is = sk.getInputStream();
			InputStreamReader isd = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(isd);
			String info = null;
			while ((info = br.readLine())!=null) {
				System.out.println("我是客户端，服务端说："+info);
			}
			//4、关闭资源
			br.close();
			isd.close();
			is.close();
			pw.close();
			os.close();
			sk.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
