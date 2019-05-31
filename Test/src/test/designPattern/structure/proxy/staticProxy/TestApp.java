package test.designPattern.structure.proxy.staticProxy;

import test.designPattern.structure.proxy.UserDao;
import test.designPattern.structure.proxy.UserDaoImpl;

public class TestApp {

	public static void main(String[] args) {
		UserDaoImpl userDao = new UserDaoImpl();
		
		UserDao proxyUserDao = new ProxyUserDao( userDao);
		
		proxyUserDao.save();
	}
}
