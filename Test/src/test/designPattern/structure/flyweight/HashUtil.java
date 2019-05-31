package test.designPattern.structure.flyweight;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

	public static String getHashId(String content) {
		String hashId = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(content.getBytes());
			hashId = bytesToHexString(digest.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hashId;
	}
	
	public static String bytesToHexString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for(byte b:bytes) {
			String hex = Integer.toHexString(0xff & b);
			if(hex.length() == 1) {
				sb.append("0");
			}
			sb.append(hex);
		}
		
		return sb.toString();
	}
}
