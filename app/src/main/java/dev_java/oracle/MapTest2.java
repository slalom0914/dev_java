package dev_java.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapTest2 {
	List<Map<String, Object>> list = new ArrayList<>();
	Map<String, Object> rMap = new HashMap<>();// rMap.size() = 0

	public void setMap() {
		rMap.put("deptno", 10);
		rMap.put("dname", "인사부");
		rMap.put("loc", "서울");
		list.add(rMap);// list.get(0)
		rMap = new HashMap<>();
		rMap.put("deptno", 20);
		rMap.put("dname", "개발부");
		rMap.put("loc", "부산");
		list.add(rMap);// list.get(1)
		rMap = new HashMap<>();
		rMap.put("deptno", 30);
		rMap.put("dname", "총무부");
		rMap.put("loc", "제주");
		list.add(rMap);// list.get(2)
	}

	public void mapPrint() {
		// 각 로우안에 key가 세개있다.(컬럼-deptno, dname, loc)
		// Map m1 = get(0):컬럼3개, Map m2 = get(1):컬럼3개, Map m3 = get(2):컬럼3개
		// 아래에서 반복해야 되는 건 List이다.(ArrayList이다)
		for (int i = 0; i < list.size(); i++) {// 반복해서 처리할 것은 로우값이다.get(0), get(1), get(2)
			Map<String, Object> m1 = list.get(i);
			// 컬럼의 수를 반복해서 출력하기
			Object[] keys = m1.keySet().toArray();
			for (int j = 0; j < keys.length; j++) {
				String key = (String) keys[j];
				System.out.print(m1.get(key) + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		MapTest2 mt1 = new MapTest2();
		mt1.setMap();
		mt1.mapPrint();
		/*
		 * // Map의 size는 세로방향이다. 컬럼의 수이다
		 * System.out.println(mt1.rMap.size());// 0->3
		 * Set<String> set = mt1.rMap.keySet();
		 * Iterator<String> iter = set.iterator();
		 * while (iter.hasNext()) {// 자료구조안에 값이 있는지 체크해서 있으면 true를 반환,없으면 false
		 * String key = iter.next();
		 * // String value = (String)mt1.rMap.get(key);
		 * Object value = mt1.rMap.get(key);
		 * System.out.println(key + " : " + value);
		 * }
		 */
	}
}
