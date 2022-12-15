package dev_java.quiz1215;

import java.util.Scanner;

public class Quiz11 {
	// 배열을 선언하자
	int users[] = new int[5];// 0 0 0 0 0

	void average(int hap) {
		double avg = 0.0;
		avg = hap / (double) users.length;// int
		System.out.println("평균은 " + avg + " 입니다.");
	}

	int total() {
		int hap = 0;
		for (int i = 0; i < users.length; i++) {// 0 1 2 3 4
			hap = hap + users[i];
		}
		return hap;
	}

	void initUsers() {
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < users.length; i++) {
			System.out.print("정수를 입력하세요.");
			users[i] = s.nextInt();
			System.out.println(users[i]);// 2 4 6 8 10
		}
		s.close();
	}

	public static void main(String[] args) {
		Quiz11 q11 = new Quiz11();
		q11.initUsers();
		int hap = q11.total();
		System.out.println("총점은 " + hap + " 입니다.");
		q11.average(hap);
	}
}
