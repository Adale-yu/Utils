package test.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestStream {

	public static void main(String[] args) {
		Map<Integer, Example> map = new HashMap<Integer, Example>();
		@SuppressWarnings("unused")
		Example e1 = new Example(101);
		Example e2 = new Example(121);
		Example e3 = new Example(111);
		Example e4 = new Example(131);
		
		map.put(1, e1);
		map.put(2, e2);
		map.put(3, e3);
		map.put(4, e4);
		
		ExampleNumComparator comparator = new ExampleNumComparator();
		List<Example> list = map.values().stream().sorted(comparator).limit(4).collect(Collectors.toList());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getNum());
		}
	}
	
	public static class Example{
		private int num = 0;
		
		public Example(int num) {
			this.num = num;
		}
		
		public int getNum() {
			return num;
		}
		
		public void setNum(int num) {
			this.num = num;
		}
	}
	
	public static class ExampleNumComparator implements Comparator<Example>{

		@Override
		public int compare(Example o1, Example o2) {
			if(o1 != null && o2 != null) {
				if(o1 == o2) {
					return 0;
				}
				
				if(o1.getNum() > o2.getNum()) {
					return -1;
				}else if(o1.getNum() < o2.getNum()) {
					return 1;
				}
			}
			
			return 0;
		}
		
	}
}
