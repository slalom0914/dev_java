package dev_java.tables;

import java.util.Vector;

public class Vector7 {
	public static void main(String[] args) {
		DeptVO[] dVOS = new DeptVO[3];
		Vector<DeptVO> vdepts = new Vector<>();
		DeptVO dvo = new DeptVO(10,"개발부","서울");
		dVOS[0] = dvo;
		vdepts.add(dvo);
		dvo = new DeptVO(20,"인사부","인천");
		dVOS[1] = dvo;
		vdepts.add(dvo);
		dvo = new DeptVO(30,"총무부","부산");
		dVOS[2] = dvo;
		vdepts.add(dvo);
	}////////// end of main
}//////////// end of Vector7
