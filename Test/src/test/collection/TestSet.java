package test.collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {
	
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
		
		set.add(12);
		set.add(112);
		set.add(1);
		set.add(102);
		set.add(12132);
		
		set.stream().sorted(Comparator.reverseOrder());
        System.out.println(set);

	}
}
