package test.designPattern.behavior.strategy.example;

import test.designPattern.behavior.strategy.example.strategy.Discount;

public class Shopping {

	private String productName;
	private String desc;
	private double price;
	private Discount discount;
	
	
	public Shopping(String productName, double price, Discount discount) {
		this.productName = productName;
		this.price = price;
		this.discount = discount;
	}
	
	public double discount() {
		double finalPrice = this.discount.discount(price);
		desc = String.format("%s原价为%f元，使用了优惠：%s，最终价格为%f", productName, price, discount.getDesc(), finalPrice);
		System.out.println(desc);
		
		return finalPrice;
	}
}
