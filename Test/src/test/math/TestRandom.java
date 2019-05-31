package test.math;


public class TestRandom {

	public static void main(String[] args) {
		testMin();
	}
	
	public static void testMin() {
		int random = (int) ((Math.min(Math.random() + 0.01d, 1.0d)) * 1000);
		System.out.println(random);
	}
	
	
}
