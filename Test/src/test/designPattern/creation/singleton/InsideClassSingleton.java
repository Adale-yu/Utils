package test.designPattern.creation.singleton;

public class InsideClassSingleton {

	//静态内部类单例模式
	//实现了lazy loading 和 线程安全，并且不需要加锁
	private static class InsideClass{
		private static InsideClassSingleton instance = new InsideClassSingleton();
	}
	
	private InsideClassSingleton() {
		
	}
	
	public static InsideClassSingleton getInstance() {
		return InsideClass.instance;
	}
}
