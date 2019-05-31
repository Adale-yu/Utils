package test.designPattern.creation.singleton;

public class LazySingleton02 {

	//懒汉式单例模式，对getInstance方法上锁
	//实现了lazy loading 和 线程安全，但每次访问getInstance方法都要上锁，浪费资源。上锁十分耗时，尽量避免
	private static volatile LazySingleton02 instance = null;
	
	private LazySingleton02() {
		
	}
	
	public synchronized static LazySingleton02 getInstance() {
		 if(instance == null) {
			 instance = new LazySingleton02();
		 }
		 return instance;
	}
}
