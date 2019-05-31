package test.designPattern.creation.builder;

public class SmartHumanBuilder extends Builder{

	public SmartHumanBuilder() {
		this.product = new ProductHuman();
	}
	
	@Override
	public void setHead() {
		this.product.setHead("头部安装完毕,智商180...");
	}

	@Override
	public void setHand() {
		this.product.setHand("手安装完毕...");
	}

	@Override
	public void setBody() {
		this.product.setBody("身体安装完毕，状态：手无缚鸡之力...");
	}

	@Override
	public void setFoot() {
		this.product.setFoot("腿安装完毕...");
	}

}
