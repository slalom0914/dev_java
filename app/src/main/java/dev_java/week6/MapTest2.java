package dev_java.week6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest2 {
	public static void main(String[] args) {
		List<Map<String, Integer>> list = new ArrayList<>();
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("one", 1);
		map1.put("two", 2);
		map1.put("three", (int) 3.0);
		Map<String, Double> map2 = new HashMap<>();
		map2.put("one1", new Double(1));
		map2.put("two1", new Double(2));
		map2.put("three1", 3.0);
		Map<String, Object> map3 = new HashMap<>();
		map3.put("one2", 1);
		map3.put("two2", 2);
		map3.put("three2", 3.0);		
		int i = 2;
		double d = i;
	}
}
