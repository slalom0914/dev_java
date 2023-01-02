package dev_java.basic1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExam1 {
	public static void main(String[] args) {
		// List따로 Map따로 사용하는 경우보다는 주로 List<Map<>>꼴로 많이 사용됨
		// 오라클에서 제공하는 테이블 구조에서 튜플을 구성할때 Map을 사용가능함
		// Member테이블기준
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String, Object> pmap = new HashMap<>();
		System.out.println(pmap);
		pmap.put("mem_id", "kiwi");
		pmap.put("mem_pw", "123");
		pmap.put("mem_nick", "나초보");
		list.add(pmap);//list.get(0)
		pmap = new HashMap<>();// 새로운 주소번지가 할당됨
		System.out.println(pmap);
		pmap.put("mem_id", "tomato");
		pmap.put("mem_pw", "123");
		pmap.put("mem_nick", "나신입");
		System.out.println(pmap);
		list.add(pmap);//list.get(1)
		pmap = new HashMap<>();
		pmap.put("mem_id", "banana");
		pmap.put("mem_pw", "123");
		pmap.put("mem_nick", "나일등");
		list.add(pmap);//list.get(2)
		// Map의 키값은 DB테이블의 컬럼명과 통일하기 - 권장
		// 키값을 출력 - mem_id, mem_pw, mem_nick
		Object key[] = pmap.keySet().toArray();
		/* 
		for (Object s : key) {
			System.out.println(s.toString());
			System.out.println(pmap.get(s));
		}
		*/
		for(int i=0;i<list.size();i++){
			Map<String,Object> rmap = list.get(i);
			System.out.println(rmap.get("mem_id")
			                        +", "+rmap.get("mem_pw")
									+", "+rmap.get("mem_nick"));
		}
	}
}
