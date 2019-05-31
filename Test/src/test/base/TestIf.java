package test.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestIf {

	public static void main(String[] args) {
		testIf();
	}
	
	public static void testIf() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		
		Map<Integer, Integer> map = null;
		
		if((map == null || map.size() == 0) && 
				(list == null || list.size() == 0)) {
			System.out.println("null");
		}else {
			System.out.println("not null");
		}
	}

}
