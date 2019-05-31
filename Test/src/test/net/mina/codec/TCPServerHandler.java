package test.net.mina.codec;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TCPServerHandler extends IoHandlerAdapter
{
	// 这里我们使用的SLF4J作为日志门面，至于为什么在后面说明。    
	private final static Logger log = LoggerFactory.getLogger(TCPServerHandler.class);
	
	@Override
	public void messageReceived(IoSession session, Object message)    
	throws Exception {
    	String str = message.toString();
    	log.info("The message received is [" + str + "]");
    	log.info(session.getRemoteAddress().toString());
    	if (str.endsWith("quit")) {    
        	session.close(true);	//IoSession 都用于表示底层的一个TCP 连接，IoSession 的close()仅仅是关闭了TCP的连接通道，并没有关闭Server 端、Client 端的程序。
        	session.getService().dispose();	//IoService 的dispose()方法停止Server 端、Client 端。
        	return;
    	}
	}
	
	@Override
    public void sessionCreated(IoSession session) throws Exception {
        System.out.println("server session created");
        super.sessionCreated(session);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("server session Opened");
        super.sessionOpened(session);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("server session Closed");
        super.sessionClosed(session);
    }
}
