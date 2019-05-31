package test.net.mina;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class TCPClient
{
	public static void init() {
		IoConnector connector=new NioSocketConnector();    
		connector.setConnectTimeoutMillis(30000);
		
		try
		{
			org.apache.mina.filter.codec.Code.key2 = "yingshou".getBytes("UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		
		//设置过滤链
		/*connector.getFilterChain().addLast("codec",new ProtocolCodecFilter(
				new TextLineCodecFactory(
						Charset.forName("UTF-8"),
						LineDelimiter.WINDOWS.getValue(),
						LineDelimiter.WINDOWS.getValue())));*/
		//解码器过滤链
		PrefixedStringCodecFactory prefixed = new PrefixedStringCodecFactory(Charset.forName("UTF-8"));
        prefixed.setEncoderPrefixLength(4);
        prefixed.setDecoderPrefixLength(4);
        prefixed.setDecoderMaxDataLength(2048);			// 接收最大2K
        prefixed.setEncoderMaxDataLength(100*1024);
        connector.getFilterChain().addLast("profixed", new ProtocolCodecFilter(prefixed));
        
        //设置handle
		connector.setHandler(new ClientHandler("GMCD1012|持盾的老头|2|2|0|1"));
		
		//connect()方法返回ConnectFuture实例，利用ConnectFuture可以在连接成功后进行操作
		ConnectFuture future = connector.connect(new InetSocketAddress("localhost", 30004));
		/*第一种方法，awaitUninterruptibly()，相当于是转异步执行为同步执行。
		 * future.awaitUninterruptibly();
		IoSession session = future.getSession();
		System.out.println(session.getRemoteAddress());*/
		
		//第二种方法，添加监听器，异步执行，不会阻塞主线程
		future.addListener(new IoFutureListener<ConnectFuture>() {
			@Override
			public void operationComplete(ConnectFuture arg0)
			{
				try
				{
					Thread.sleep(1);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				IoSession session = future.getSession();
				System.out.println(session.getRemoteAddress());
				System.out.println("+++++++++++++++++++++++");
			}
		});
		
		System.out.println("*************");
	}
	
	public static void main(String[] args) {
		init();
	}
}
