package test.net.mina;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LogLevel;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.filter.util.ReferenceCountingFilter;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class TCPServer
{
	public static void init() {
		IoAcceptor acceptor=new NioSocketAcceptor();
		//acceptor.getSessionConfig().setReadBufferSize(2048);
		//acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);	//读写通道均在10 秒内无任何操作就进入空闲状态
		
		SocketSessionConfig ssc = ((NioSocketAcceptor)acceptor).getSessionConfig();
		ssc.setReadBufferSize(1024);
		ssc.setReceiveBufferSize(2048);
		ssc.setSendBufferSize(4096);
		ssc.setReuseAddress(true);
		ssc.setTcpNoDelay(true);
		ssc.setSoLinger(0);	// 不进入time_wait状态
		ssc.setIdleTime(IdleStatus.READER_IDLE, 300);
		
		//设置过滤链
		//设置解码器过滤链
		/*acceptor.getFilterChain().addLast("codec",  new ProtocolCodecFilter(new TextLineCodecFactory(
				Charset.forName("UTF-8"),
				LineDelimiter.WINDOWS.getValue(),
				LineDelimiter.WINDOWS.getValue()))    
				);*/
		PrefixedStringCodecFactory prefixed = new PrefixedStringCodecFactory(Charset.forName("UTF-8"));
        prefixed.setEncoderPrefixLength(4);
        prefixed.setDecoderPrefixLength(4);
        prefixed.setDecoderMaxDataLength(2048);			// 接收最大2K
        prefixed.setEncoderMaxDataLength(100*1024);
        acceptor.getFilterChain().addLast("profixed", new ProtocolCodecFilter(prefixed));
		//添加log过滤链
		LoggingFilter lf = new LoggingFilter();
		lf.setSessionOpenedLogLevel(LogLevel.DEBUG);//默认是debug级别
		//acceptor.getFilterChain().addLast("logger", lf);
		
		//添加自定义过滤链
		//acceptor.getFilterChain().addLast("MyIoFilter", new ReferenceCountingFilter(new MyIoFilter()));
		
		//设置handler
		acceptor.setHandler(new TCPServerHandler());
		try
		{
			acceptor.bind(new InetSocketAddress(9123));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		init();
	}
}
