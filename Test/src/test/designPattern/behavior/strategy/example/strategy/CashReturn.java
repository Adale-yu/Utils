package test.designPattern.behavior.strategy.example.strategy;

public class CashReturn extends Discount {

	public CashReturn() {
		this.desc = "返现10元";
	}
	
	@Override
	public double discount(double price) {
		return price - 10;
	}

}
