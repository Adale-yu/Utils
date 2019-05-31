package test.designPattern.behavior.strategy.comparator;

import java.util.Arrays;

public class TestArraysSort {

	public static void main(String[] args) {
		Student[] students = {
				new Student(1, "张三"),
				new Student(3, "李四"),
				new Student(4, "王五"),
				new Student(2, "刘六")
		};
		
		System.out.println("排序前......");
		toString(students);
		
		Arrays.sort(students, new StudentComparatorAsc());
		System.out.println("升序后......");
		toString(students);
		
		Arrays.sort(students, new StudentComparatorDesc());
		System.out.println("降序后......");
		toString(students);
		
	}
	
	public static String toString(Student[] student) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<student.length; i++) {
			sb.append(student[i].toString());
			sb.append(",");
		}
		
		String retStr = sb.toString().substring(0, sb.toString().length()-1);
		System.out.println(retStr);
		return retStr;
	}
}
