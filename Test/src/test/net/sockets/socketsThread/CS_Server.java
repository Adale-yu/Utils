package test.net.sockets.socketsThread;

import java.net.*;

public class CS_Server 
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket ss = new ServerSocket(38380);//是一个能够接受其他通信实体请求的类
        System.out.println("服务器正在等待客户端的连接请求----");
        //用一个while循环可以同时响应多个客户端的请求
        //应用多线程实现服务器与多客户端之间的通信
        while(true){
             Socket sk= ss.accept();//服务器监听对应端口的输入
             ServerThread  st = new ServerThread(sk);//创建一个线程，用线程创建一个套接字
             st.start();
        }
    }
}
