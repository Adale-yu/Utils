package test.net.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientHandler extends IoHandlerAdapter {    
    private final static Logger LOGGER = LoggerFactory.getLogger(ClientHandler.class);    
    private final String values;
    
    public ClientHandler(String values) {    
        this.values = values;    
    }
    
    @Override    
    public void sessionOpened(IoSession session) {
    	
    	
    	session.write(values);
    }
    
    @Override
	public void messageReceived(IoSession session, Object message)    
	throws Exception {
    	String str = message.toString();
    	LOGGER.info("The message received is [" + str + "]");
    	LOGGER.info(session.getRemoteAddress().toString());
    	/*String cmd = str.substring(0, 4);
    	if(cmd.equals("MLOI")) {
    		session.write("GMCD1012|快乐的狮鹫|2|2|0|1");
    		session.getService().dispose();
    	}*/
	}
}    