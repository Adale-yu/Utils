package test.time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TsetDemo {
	
	public static void main(String[] args) {
		m13();
	}
	
	public static void m13() {
		int num1 = 1000;
		int num2 = 166;
		float num = (float) (num2*1.0/num1);
		System.out.println(num);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void m12() {
		Map<String, Integer> maps = (Map<String, Integer>) JSON.parse("{\"B\":745,\"F\":610,\"H\":197,\"I\":8,\"J\":74,\"K\":50,\"L\":200,\"M\":200,\"Q\":40,\"S\":17,\"T\":30}");
		for (Object map : maps.entrySet()){  
            System.out.println(((Map.Entry)map).getKey()+"     " + ((Map.Entry)map).getValue());  
        } 
		int num = maps.get("Q");
		System.out.println(num);	
	}
	
	public static void m11() {
		String missionId = "\"21001,21002,21003,21004,21005\"";
		
		String param = missionId.replaceAll("\"", "");
		System.out.println(param);
	}
	
	public static void m10() {
		String str = "pid:606,p:com.fengbao.wangzuo.500z,zid:1,cid:116764";
		String[] param = str.split(",");
		JSONObject ext = new JSONObject();
		for(int i = 0;i<param.length;i++) {
			String[] values = param[i].split(":");
			ext.put(values[0], values[1]);
		}
		
		int pid = ext.getIntValue("pid");
		int zid = ext.getIntValue("zid");
		int cid = ext.getIntValue("cid");
		String productId = ext.getString("p");
		
		System.out.println(pid + "," + productId);
	}
	
	public static void m9() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 2);
		int num = map.get(10001);
		System.out.println(num);
	}
	
	public static void m8() {
		String value = "0.5,20,6";
		List<String> valueStr = Arrays.asList(value.split(","));
		System.out.println(valueStr.toString());
		float num = Float.parseFloat(valueStr.get(0));
		System.out.println(num);
	}
	
	public static void m7() {
		List<Integer> cardIdList = new ArrayList<Integer>();
		List<Integer> cardsList = new ArrayList<Integer>();
		//只有16个卡片位置，id 1到8 每个id放两个
		for(int i=1;i<=8;i++) {
			cardIdList.add(i);
			cardIdList.add(i);
		}
		cardIdList.set(2, 100);
		String cardStr = cardIdList.toString();
		System.out.println(cardStr);
		
		int size = cardIdList.size();
		for(int i=0;i<size;i++) {
			int randomNum = (int) (cardIdList.size()*Math.random());
			cardsList.add(cardIdList.get(randomNum));
			cardIdList.remove(randomNum);
		}
		
		System.out.println(cardsList.toString());
	}
	
	public static void m6() {
		Integer num = 100 + 5/2 * 20;
		int n1 = 100;
		int n2 = 1;
		int n3 = 1;
		int n4 = 0;
		num = n1+ n2/n3*n4;
		float num2 = n1+ n2/n3*n4;
		System.out.println(num);
		System.out.println(num2);
	}
	
	public static void m5() {
		String rateStr = "0.9";
		
		double rate = Double.parseDouble(rateStr);
		
		System.out.println(rate);
	}
	
	public static void m4() {
		JSONObject json = new JSONObject();
		
		for(int i = 1;i<=3;i++) {
			Map<String, Object> retMap = new HashMap<String, Object>();
			retMap.put("type", i);
			retMap.put("quality", i);
			retMap.put("level", i);
			retMap.put("exp", i);
			json.put(""+i, retMap);
		}
		
		System.out.println(json.toString());
	}
	
	public static void m3() {
		Item item1 = new Item();
		item1.setCount(22);
		item1.setMoney(22);
		
		Item item2 = item1;
		item2.setCount(33);
		
		System.out.println(item1.getCount());
	}
	
	public static void m1() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(11);
		list.add(12);
		list.add(13);
		
		for(int i = 0; i<list.size();i++) {
			list.set(i, list.get(i)+10);
		}
		
		System.out.println(list.toString());
		
	}
	
	public static void m2()
	{
		Integer[] items = {1,2,3,4,5};
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(items)) ;
		System.out.println(list.toString().replace("[", "").replace("]", ""));
		System.out.println(list.toString().substring(1, list.toString().length()-1 ));
		
		
		
		
		Integer[] arr = new Integer[list.size()];
		list.toArray(arr);
		System.out.println(arr[3]);
		
		list.clear();
		System.out.println(list.toString());
		
	}
}
