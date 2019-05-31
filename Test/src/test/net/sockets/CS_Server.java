package test.net.sockets;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CS_Server
{
	public static void main(String[] args) {
		try {
			//1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
			ServerSocket serverSocket = new ServerSocket(10086);
			//2、调用accept()方法开始监听，等待客户端的连接;accept()方法在接受连接之前会一致阻塞
			Socket socket = serverSocket.accept();
			//3、获取输入流，并读取客户端信息
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String info = null;
			while ((info = br.readLine())!= null) {
				System.out.println("我是服务器，客户端说:"+info);
			}
			socket.shutdownInput(); //关闭输入流
			//4、获取输出流，响应客户端的请求
			OutputStream op = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(op);
			pw.println("欢迎你");
			pw.flush();
			
			//5、关闭资源
			pw.close();
			op.close();
			br.close();
			isr.close();
			is.close();
			socket.close();
			serverSocket.close();
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
	}
}
