package test.designPattern.creation.builder;

public abstract class Builder {
	protected ProductHuman product;
	
	public abstract void setHead();
	public abstract void setHand();
	public abstract void setBody();
	public abstract void setFoot();
	
	public ProductHuman getProduct() {
		return product;
	}
}
