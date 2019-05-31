package test.designPattern.behavior.strategy.example.strategy;

public abstract class Discount {

	protected String desc;
	
	public abstract double discount(double price);

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
