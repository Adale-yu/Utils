package test.designPattern.creation.singleton;

public enum EnumSingleton {

	// 枚举单例模式，效率最好
	//Effective Java推荐尽可能地使用枚举来实现单例。
	INSTANCE;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
