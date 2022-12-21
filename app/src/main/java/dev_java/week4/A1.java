package dev_java.week4;

import java.util.Vector;

public class A1 {
	int ival = 1;

	public static void main(String[] args) {
		A1 a1 = new A1();
		a1.ival = 10;
		System.out.println("8번 주소번지 ==> " + a1);
		Vector<A1> va1 = new Vector<>();
		va1.add(a1);
		a1 = null;// 객체 초기화하면 다음 라인 넘어갈때 캔디데이트 상태가 됨
		a1 = new A1();
		a1.ival = 20;
		System.out.println(a1);
		// insert here
		System.out.println("8번 주소번지 ==> " + va1.get(0));
		A1 a2 = va1.get(0);
		System.out.println("8번 주소번지 ==> " + a2);
		//System.out.println("8번 주소번지 ==> " + a2);
		System.out.println(va1.get(0).ival);
		System.out.println(a1.ival);
		Vector<Integer> v = new Vector<>;
		v.add(1);
		System.out.println(v.get(0));
	}
}
