package test.designPattern.structure.proxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

	private Object target;
	public ProxyFactory(Object target) {
		this.target = target;
	}
	
	public Object getInstanceProxy() {
		return Proxy.newProxyInstance(
				this.target.getClass().getClassLoader(), 
				this.target.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("开始事务......");
						Object returnValue = method.invoke(target, args);
						System.out.println("结束事务......");
						return returnValue;
					}
				});
	}
}
