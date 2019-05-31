package test.string;

public class StringUtil {

	/**
	 *  DESC:首字母转小写
	 * 
	 * @param str
	 * @return
	 */
	public static String toLowerCaseFirstOne(String str) {
		if(Character.isLowerCase(str.charAt(0))) {
			return str;
		}
		
		return new StringBuffer().append(Character.toUpperCase(str.charAt(0))).append(str.substring(1)).toString();
	}
	
	
	/**
	 * DESC:首字母转大写
	 * 
	 * @param str
	 * @return
	 */
	public static String toUpperCaseFirstOne(String str) {
		if(Character.isUpperCase(str.charAt(0))) {
			return str;
		}
		
		return new StringBuffer().append(Character.toUpperCase(str.charAt(0))).append(str.substring(1)).toString();
	}
}
