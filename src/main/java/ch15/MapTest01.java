package ch15;

import java.util.HashMap;
import java.util.Map;
//List만 따로 사용하고 Map만 따로 사용하고 보다는
//List와 Map을 섞어쓰기 -> JSON으로 만들어진다.
//deptno number, dname varchar2, loc varchar2
public class MapTest01 {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        map1.put("deptno", "10");
        System.out.println(map1.get("deptno") instanceof  String);//true
        map2.put("deptno", 10);
        System.out.println(map2.get("deptno") instanceof  String);
    }
}
