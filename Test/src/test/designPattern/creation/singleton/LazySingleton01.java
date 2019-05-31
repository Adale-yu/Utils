package test.designPattern.creation.singleton;

public class LazySingleton01 {

	//懒汉式单例模式最简单写法
	//实现了lazy loading, 确定是线程不安全
	private static LazySingleton01 instance = null; 
	
	private LazySingleton01() {
		
	}
	
	public static LazySingleton01 getInstance() {
		if(instance == null) {
			instance = new LazySingleton01();
		}
		
		return instance;
	}
}
