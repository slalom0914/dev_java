package dev_java.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//회원정보 담기
public class MapTest3 {
	public static void main(String[] args) {
		List<Map<String, Object>> list = new ArrayList<>();
		System.out.println(list);//
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("mem_id", "tomato");
		pMap.put("mem_pw", "123");
		// pMap.put("mem_name", "토마토");
		// pMap.put("mem_gender", "남자");
		list.add(pMap);
		System.out.println(list);//
		// insert here
		// List<Map<>> - 밖에 있는 List는 대괄호로 묶음
		// 제네릭은 {} 좌중괄호 우중괄호로 묶음
		// list이용
		System.out.println("1 :" + list.get(0));// Map출력 - {mem_name=토마토}
		System.out.println("2 :" + list.get(0).get("mem_name"));// Map출력
		System.out.println("3 :" + list.get(0).get("mem_pw"));// Map출력
		// System.out.println(pMap);// @abcd1234
		// System.out.println(pMap.toString());// @abcd1234
		// System.out.println(pMap.get("mem_name"));
		// 회원아이디, 회원이름, 회원비번, 성별
		// mem_id, mem_name, mem_pw, mem_gender
		// tomato, 토마토, 123, 남자
		// banana, 바나나, 123, 여자
		// kiwi, 키위, 123, 남자
	}
}
