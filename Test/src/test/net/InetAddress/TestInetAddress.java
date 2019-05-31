package test.net.InetAddress;

import java.net.InetAddress;

public class TestInetAddress
{
	public static void main(String[] args) {
		try {
			//获取本机的InetAddress实例
			InetAddress inetAddress =InetAddress.getLocalHost();
			System.out.println(inetAddress.getHostName());
			System.out.println(inetAddress.getHostAddress());
			byte[] bytes = inetAddress.getAddress();//获取字节数组形式的IP地址,以点分隔的四部分
			
			InetAddress inetAddress1 = InetAddress.getByName("391platform.yinshouhn.com");
			System.out.println(inetAddress1.getHostName());
			System.out.println(inetAddress1.getHostAddress());
			
			
			//获取其他主机的InetAddress实例
//			InetAddress address2 =InetAddress.getByName("其他主机名");
//			InetAddress address3 =InetAddress.getByName("IP地址");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
