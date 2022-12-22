package dev_java.grade1221;

import java.util.Arrays;

public class ArrayCopy1 {
	String fruit[] = { "사과", "딸기", "바나나" };
	String fruit2[];

	// public ArrayCopy1() {
	// }

	public ArrayCopy1() {
		fruit2 = fruit;
		fruit2[1] = "키위";
		System.out.println(Arrays.toString(fruit));
		System.out.println(Arrays.toString(fruit2));
	}

	public static void main(String[] args) {
		new ArrayCopy1();
	}
}
