package dev_java.week4;

public class DeptVOMain {
	public static void main(String[] args) {
		DeptVO dVo = DeptVO.builder().dname("총무부").build();
		DeptVO dVo2 = DeptVO.builder().deptno(20).loc("부산").dname("총무부").build();
		System.out.println(dVo.getDeptno()+", "+dVo.getDname()+dVo.getLoc());
		System.out.println(dVo2.getDeptno()+", "+dVo2.getDname()+dVo2.getLoc());
	}
}
