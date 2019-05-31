package test.net.sockets.socketsThread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread
{
	private Socket sk;
	public ServerThread(Socket sk) {
		this.sk = sk;
	}
	
	@Override
	public void run() {
		//利用线程
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream(),"UTF-8"));
			String data = null;
			while((data = br.readLine())!=null) {
				System.out.println("来自客户端的数据"+data);
			}
			sk.shutdownInput();
			
			OutputStream os = sk.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.println("恭喜你,admin：");
			pw.println("你已经成功连接到服务器");
			
			//关闭资源
			pw.close();
			os.close();
			br.close();
			sk.close();
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
}
