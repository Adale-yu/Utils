package test.designPattern.creation.singleton;

public class LazySingleton03 {

	//懒汉式单例模式3，两次判断instance是否为空
	//实现了lazy loading 和 线程安全，同时也会在创建实例是加锁，其他时候调用getInstance方法不会加锁
	private static volatile LazySingleton03 instance = null;
	
	private LazySingleton03() {
		
	}
	
	public static LazySingleton03 getInstance() {
		if(instance == null) {
			synchronized(LazySingleton03.class) {
				if(instance == null) {
					instance = new LazySingleton03();
				}
			}
		}
		
		return instance;
	}
	
}
