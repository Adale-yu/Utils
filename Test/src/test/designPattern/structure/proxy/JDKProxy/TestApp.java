package test.designPattern.structure.proxy.JDKProxy;

import test.designPattern.structure.proxy.UserDao;
import test.designPattern.structure.proxy.UserDaoImpl;

public class TestApp {

	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		
		System.out.println(userDao.getClass());
		ProxyFactory proxyFactory = new ProxyFactory(userDao);
		
		UserDao proxy = (UserDao) proxyFactory.getInstanceProxy();
		
		System.out.println(proxy.getClass());
		proxy.save();
	}
}
