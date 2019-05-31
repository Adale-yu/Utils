package test.designPattern.structure.proxy;

public class UserDaoImpl implements UserDao {

	@Override
	public void save() {
		System.out.println("save.......");
	}

}
