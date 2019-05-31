package test.base;

public class TestBitOperation {

	public static void main(String[] args) {
		test1();
	}
	
	public static void test1() {
		String content = "content";
		
		byte[] bytes = content.getBytes();
		
		for(byte b : bytes) {
			int num = 0xff & b;
			String hex = Integer.toHexString(0xff & b);
			
			System.out.println(hex + "--" + num);
		}
	}
}
