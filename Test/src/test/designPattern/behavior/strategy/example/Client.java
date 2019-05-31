package test.designPattern.behavior.strategy.example;

import test.designPattern.behavior.strategy.example.strategy.CashReturn;
import test.designPattern.behavior.strategy.example.strategy.NoDiscount;
import test.designPattern.behavior.strategy.example.strategy.TenPercentDiscount;
import test.designPattern.behavior.strategy.example.strategy.TwentyPercentDiscount;

public class Client {

	public static void main(String[] args) {
		Shopping shopping = new Shopping("华为pro30", 3600.0, new TwentyPercentDiscount());
		shopping.discount();
		
		shopping = new Shopping("戴尔手提电脑", 5600.0, new TenPercentDiscount());
		shopping.discount();
		
		shopping = new Shopping("蓝牙耳机", 99.0, new CashReturn());
		shopping.discount();
		
		shopping = new Shopping("手机壳", 25.0, new NoDiscount());
		shopping.discount();
	}
}
