package test.net.mina;

import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.WriteRequest;

public class MyIoFilter implements IoFilter
{

	@Override
	public void destroy() throws Exception
	{
		System.out.println("----destroy----");
	}

	@Override
	public void exceptionCaught(NextFilter arg0, IoSession arg1, Throwable arg2) throws Exception
	{
		System.out.println("----exceptionCaught----");
		arg0.exceptionCaught(arg1, arg2);
	}

	@Override
	public void filterClose(NextFilter arg0, IoSession arg1) throws Exception
	{
		System.out.println("----filterClose----");
		arg0.filterClose(arg1);
	}

	@Override
	public void filterWrite(NextFilter arg0, IoSession arg1, WriteRequest arg2) throws Exception
	{
		System.out.println("----filterWrite----");
		arg0.filterWrite(arg1, arg2);
	}

	@Override
	public void init() throws Exception
	{
		System.out.println("----init----");
	}

	@Override
	public void inputClosed(NextFilter arg0, IoSession arg1) throws Exception
	{
		System.out.println("----inputClosed----");
		arg0.inputClosed(arg1);
	}

	@Override
	public void messageReceived(NextFilter arg0, IoSession arg1, Object arg2) throws Exception
	{
		System.out.println("----messageReceived----");
		arg0.messageReceived(arg1, arg2);
	}

	@Override
	public void messageSent(NextFilter arg0, IoSession arg1, WriteRequest arg2) throws Exception
	{
		System.out.println("----messageSent----");
	}

	@Override
	public void onPostAdd(IoFilterChain arg0, String arg1, NextFilter arg2) throws Exception
	{
		System.out.println("----onPostAdd----");
	}

	@Override
	public void onPostRemove(IoFilterChain arg0, String arg1, NextFilter arg2) throws Exception
	{
		System.out.println("----onPostRemove----");
	}

	@Override
	public void onPreAdd(IoFilterChain arg0, String arg1, NextFilter arg2) throws Exception
	{
		System.out.println("----onPreAdd----");
	}

	@Override
	public void onPreRemove(IoFilterChain arg0, String arg1, NextFilter arg2) throws Exception
	{
		System.out.println("----onPreRemove----");
	}

	@Override
	public void sessionClosed(NextFilter arg0, IoSession arg1) throws Exception
	{
		System.out.println("----sessionClosed----");
		arg0.sessionClosed(arg1);
	}

	@Override
	public void sessionCreated(NextFilter arg0, IoSession arg1) throws Exception
	{
		System.out.println("----sessionCreated----");
		arg0.sessionCreated(arg1);
	}

	@Override
	public void sessionIdle(NextFilter arg0, IoSession arg1, IdleStatus arg2) throws Exception
	{
		System.out.println("----sessionIdle----");
		arg0.sessionIdle(arg1, arg2);
	}

	@Override
	public void sessionOpened(NextFilter arg0, IoSession arg1) throws Exception
	{
		System.out.println("----sessionOpened----");
		arg0.sessionOpened(arg1);
	}

}
