package test.designPattern.behavior.strategy.example.strategy;

public class TwentyPercentDiscount extends Discount {

	public TwentyPercentDiscount() {
		this.desc = "八折优惠";
	}
	
	@Override
	public double discount(double price) {
		return price * 0.8;
	}

}
