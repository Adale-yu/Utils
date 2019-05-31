package test.designPattern.behavior.strategy.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCollectionsSort {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student(1, "张三"),
				new Student(3, "李四"),
				new Student(4, "王五"),
				new Student(2, "刘六")
		);
		
		System.out.println("排序前......");
		toString(list);
		
		Collections.sort(list, new StudentComparatorAsc());
		System.out.println("升序后......");
		toString(list);
		
		Collections.sort(list, new StudentComparatorDesc());
		System.out.println("降序......");
		toString(list);
	}
	
	public static String toString(List<Student> list) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i).toString());
			sb.append(",");
		}
		
		String retStr = sb.toString().substring(0, sb.toString().length()-1);
		System.out.println(retStr);
		return retStr;
	}
}
