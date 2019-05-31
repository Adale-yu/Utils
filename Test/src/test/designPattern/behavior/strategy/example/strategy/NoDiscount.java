package test.designPattern.behavior.strategy.example.strategy;

public class NoDiscount extends Discount {

	public NoDiscount() {
		this.desc = "没有优惠";
	}
	
	@Override
	public double discount(double price) {
		return price;
	}

}
