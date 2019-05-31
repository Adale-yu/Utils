package test.designPattern.creation.builder;

public class TestBuilderPattern {

	public static void main(String[] args) {
		Director director = new Director(new SmartHumanBuilder());
		ProductHuman product1 = director.createProductByDirector();
		System.out.println(product1);
		
		director.setBuilder(new StrongHumanBuilder());
		ProductHuman prduct2 = director.createProductByDirector();
		System.out.println(prduct2);
	}
}
