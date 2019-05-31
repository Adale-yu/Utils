package test.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试求余数
 * @author Administrator
 *
 */
public class TestMo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("aaa");
		list.add("aaa");
		list.add("aaa");
		
		System.out.println(list.toString().substring(1, list.toString().length()-1));
		
		
		String[] ss = new String[4];
		ss[0] = "bb";
		ss[1] = "bb";
		ss[2] = "bb";
		ss[3] = "bb";
		
		list = Arrays.asList(ss);
		
		System.out.println(list.toString());
		
		String awakeStr = "";
		for(int i=0; i<4; i++) {
			awakeStr = awakeStr + i + ",";
		}
		
		System.out.println(awakeStr.substring(0, awakeStr.length()-1));
	}
}
