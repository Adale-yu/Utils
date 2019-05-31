package test.designPattern.structure.proxy.staticProxy;

import test.designPattern.structure.proxy.UserDao;
import test.designPattern.structure.proxy.UserDaoImpl;

public class ProxyUserDao implements UserDao{

	UserDaoImpl userDao;
	
	public ProxyUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save() {
		System.out.println("开始事务......");
		this.userDao.save();
		System.out.println("提交事务......");
	}
}
