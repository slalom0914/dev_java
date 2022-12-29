package dev_java.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest5 {
	public static void main(String[] args) {
		List<Map<String, Object>> fruit = new ArrayList<>();
		Map<String, Object> rmap = new HashMap<>();
		rmap.put("mem_id", "tomato");
		fruit.add(rmap);
		System.out.println("1 :" + rmap);// 변수명은 분명 같은데 13번은 apple출력됨
		rmap = new HashMap<>();// 새로운 객체가 생성됨-타입은 같지만
		rmap.put("mem_id", "apple");
		fruit.add(rmap);
		System.out.println("2 :" + rmap);// apple
		// insert here - 굳이 tomato출력하고 싶다 어떡하지?
		System.out.println(fruit.get(0).get("mem_id"));
		System.out.println(fruit.get(1).get("mem_id"));
	}
}
