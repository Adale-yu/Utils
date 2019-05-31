package test.net.UDP_Datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_CS_Server
{
	
	public static void main(String[] args) {
		try {
			//服务器端读取数据，实现基于UDP的用户登录
			//1、创建服务器端DatagramSocket，指定端口
			System.out.println("服务器正在启动---------------");
			DatagramSocket socket = new DatagramSocket(10012);
			System.out.println("服务器已经启动---------------");
			//2、创建数据报，用于接受客户端发送的数据
			byte[] data = new byte[1024];
			DatagramPacket packet = new DatagramPacket(data,data.length);
			//3、接受客户端发送的数据
			socket.receive(packet);	//此方法在接受数据报之前会一直阻塞
			//4、读取数据
			String info = new String(data,0,data.length);
			System.out.println("这里是服务器，客户端传过来的数据为:"+info);
			
			
			//向客户端响应数据
			//1、定义客户端的地址、端口号、回传数据
			InetAddress address = packet.getAddress();
			int port = packet.getPort();
			byte[] data2 = "恭喜，已经成功连接到服务器".getBytes();
			//2、创建数据报，包含响应的数据信息
			DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
			//3、响应客户端
			socket.send(packet2);
			//4、关闭资源
			socket.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
