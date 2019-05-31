package test.net.mina.codec;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TCPClientHandler extends IoHandlerAdapter {    
    private final static Logger LOGGER = LoggerFactory.getLogger(TCPClientHandler.class);    
    private final SmsObject values;
    
    public TCPClientHandler(SmsObject values) {    
        this.values = values;    
    }
    
    @Override    
    public void sessionOpened(IoSession session) {    
    	session.write(values);
    	session.getService().dispose();
    }
}    