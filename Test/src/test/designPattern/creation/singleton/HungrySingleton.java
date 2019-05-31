package test.designPattern.creation.singleton;

public class HungrySingleton {
	
	// 饿汉式单例模式
	// 在第一次引用该类时创建实例，好处是线程安全，缺点是不能做到lazy loading
	private static HungrySingleton instance = new HungrySingleton();
	
	private HungrySingleton() {
		
	}
	
	public static HungrySingleton getInstance() {
		return instance;
	}
}
