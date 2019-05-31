package test.designPattern.behavior.strategy.example.strategy;

public class TenPercentDiscount extends Discount {

	
	public TenPercentDiscount() {
		this.desc = "九折优惠";
	}
	
	@Override
	public double discount(double price) {
		return price * 0.9;
	}

}
