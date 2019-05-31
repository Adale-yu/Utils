package test.designPattern.creation.prototype.deepClone;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {
		ConcretePrototype prototype1 = new ConcretePrototype();
		prototype1.setNum(1);
		prototype1.setStr("prototype");
		OneObject oneObject = new OneObject();
		prototype1.setOneObject(oneObject);
		System.out.println(prototype1);
		
		ConcretePrototype prototype2 = (ConcretePrototype) prototype1.deepClone();
		System.out.println(prototype2);
		
		System.out.println("克隆对象中的引用类型地址值：" + prototype2.getOneObject());
        System.out.println("原对象中的引用类型地址值：" + prototype1.getOneObject());
        System.out.println("没有深克隆："+(prototype2.getOneObject() == prototype1.getOneObject()));
	}
}
