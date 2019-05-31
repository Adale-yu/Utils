package test.base.classForName;

public class TestClassForName {

	public static void main(String[] args) throws ClassNotFoundException {
		//得到Class对象的三种方法
		TestClassForName t = new TestClassForName();
		System.out.println(t.getClass().getName());
		
		Class<?> c1 = Class.forName("test.base.classForName.TestClassForName");
		System.out.println(c1.getName());
		
		System.out.println(int[].class.getName());
		
		
		//测试接口
		testExample();
	}
	
	public TestClassForName() {
		System.out.println("创建新实例");
	}
	
	public static void testExample() {
		try {
			ExampleInterface e = (ExampleInterface) Class.forName("test.base.classForName.Example").newInstance();
			e.save();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
