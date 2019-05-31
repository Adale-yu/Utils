package test.base.UUID;

import java.util.Random;
import java.util.UUID;

public class TestUUID {

	public static void main(String[] args) {
		for(int i=0; i<=100; i++) {
			System.out.println(createSessionID());
		}
	}
	
	public static long createSessionID() {
		Random random = new Random();
		long t1 = 0x7FFFFFFF & System.currentTimeMillis();
		return t1 << 32 | Math.abs(random.nextInt());
	}
	
	/**
	 * @返回固定长度的随机字符串
	 */
	public static String getRandomStr(int length) {
		String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<length; i++) {
			int num = random.nextInt(str.length());
			sb.append(str.charAt(num));
		}
		
		return sb.toString();
	}
	
	/**
	 * @使用UUID获取得到唯一字符串
	 */
	public static void testUUID() {
		for(int i=1; i<=100; i++) {
			UUID uuid = UUID.randomUUID();
			String str =uuid.toString().replace("-", "");
			System.out.println(uuid);
			System.out.println(str);
			System.out.println("---------");
		}
	}
}
