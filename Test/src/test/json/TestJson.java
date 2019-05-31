package test.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class TestJson {

	public static void main(String[] args) {
		testListToJson();
		testParseObject();
		
		Map<Integer, Map<String, Object>> luckMap = new HashMap<Integer, Map<String, Object>>();
		
		for(int i = 1; i<=3; i++) {
			Map<String, Object> map1 = new HashMap<String, Object>();
			String[] hids = {"101","102","103"};
			List<Integer> list = new ArrayList<Integer>();
			list.add(101);
			list.add(102);
			list.add(103);
			map1.put("list", list);
			map1.put("hids", hids);
			map1.put("power", i*10000);
			luckMap.put(i, map1);
		}
		
		String jsonStr = JSON.toJSONString(luckMap, SerializerFeature.WriteNonStringKeyAsString);
		
		System.out.println(jsonStr);
	}
	
	public static void testParseObject() {
		String str = "{}";
		JSONObject json = JSON.parseObject(str);
		/*for(String key : json.keySet()) {
			json.put(key, (int) json.get(key)*10);
		}*/
		System.out.println(json.toJSONString());
	}
	
	public static void testListToJson() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(101);
		list.add(102);
		list.add(103);
		
		String jsonData = JSON.toJSONString(list, SerializerFeature.WriteNonStringKeyAsString);
		
		System.out.println(jsonData);
	}
}
