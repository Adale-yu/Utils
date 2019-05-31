package test.designPattern.creation.builder;

public class Director {
	private Builder builder;
	
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	public ProductHuman createProductByDirector() {
		this.builder.setHead();
		this.builder.setBody();
		this.builder.setHand();
		this.builder.setFoot();
		
		return this.builder.getProduct();
	}
	
	public void setBuilder(Builder builder) {
		this.builder = builder;
	}
}
