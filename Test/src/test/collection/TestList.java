package test.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestList {

	public static void main(String[] args) {
		m1();
	}
	
	public static void m1() {
		//list排序取前几个，用到了stream
		Map<Integer, Integer> hurtCidRank = new HashMap<Integer, Integer>();
		hurtCidRank.put(7000, 7);
		hurtCidRank.put(1000, 1);
		hurtCidRank.put(9000, 9);
		hurtCidRank.put(5000, 5);
		hurtCidRank.put(2000, 2);
		hurtCidRank.put(3000, 3);
		hurtCidRank.put(4000, 4);
		hurtCidRank.put(6000, 6);
		hurtCidRank.put(8000, 8);
		List<Integer> hurtRankList = hurtCidRank.keySet().stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
		List<Integer> cidList = new ArrayList<Integer>();
		for (Integer hurt : hurtRankList) {
			if (hurtCidRank.containsKey(hurt))
				cidList.add(hurtCidRank.get(hurt));
		}
		
		System.out.println(cidList.toString());
	}
}
