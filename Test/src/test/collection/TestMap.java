package test.collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		testPutAll();
	}
	
	public static void testPutAll() {
		Map<Integer, Integer> addItemMap = new HashMap<Integer, Integer>();
		for(int i=1; i<=10; i++) {
			Map<Integer, Integer> tempItemMap = new HashMap<Integer, Integer>();
			tempItemMap.put(101, 2);
			tempItemMap.put(102, 2);
			/*if(addItemMap.containsKey(101)) {
				addItemMap.put(101, addItemMap.get(101)+tempItemMap.get(101));
			}else {
				addItemMap.put(101, tempItemMap.get(101));
			}*/
		}
		System.out.println(addItemMap);
	}
}
