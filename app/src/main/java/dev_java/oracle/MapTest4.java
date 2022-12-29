package dev_java.oracle;

import java.util.HashMap;
import java.util.Map;

public class MapTest4 {
	public static void main(String[] args) {
		Map<String, Object> rmap = new HashMap<>();
		rmap.put("mem_id", "tomato");
		System.out.println("1 :"+rmap);//변수명은 분명 같은데 13번은 apple출력됨
		rmap = new HashMap<>();//새로운 객체가 생성됨-타입은 같지만
		rmap.put("mem_id", "apple");
		System.out.println("2 :"+rmap);
		rmap = new HashMap<>();
		System.out.println("3 :"+rmap);
	}
}
