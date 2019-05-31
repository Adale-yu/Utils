package test.designPattern.behavior.observer;

public class WechatClientApp implements Subsriber {

	private String name;
	
	public WechatClientApp(String name) {
		this.name = name;
	}
	
	@Override
	public int receive(String publisher, String article) {
		System.out.println(String.format("公众号%s向用户%s推送了一篇文章，标题为：%s", publisher, name, article));
		return 1;
	}

}
