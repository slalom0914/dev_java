package dev_java.grade1208;

public class Test15_1 {
	public static void main(String[] args) {
		// if else
		int a;
		if (5 < 4) {
			a = 50;
		} else {
			a = 40;
		}
		System.out.println(a); // 결과 = 40

		// 삼항연산자
		int b = (5 > 4) ? 50 : 40;
		System.out.println(b); // 결과 = 40

	}
}
