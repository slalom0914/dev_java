package dev_java.quiz1215;

import java.util.Scanner;

public class Quiz1 {
	int users[] = new int[5];// 0 0 0 0 0
	//배열을 초기화하는 메소드 선언
	void setArray(){
		Scanner s = new Scanner(System.in );
		//5개방에 값을 초기화해주기
		//insert here

		s.close();
	}
	int total(){
		int hap = 0;
		// hap = hap + i;
		return hap;
	}
	void avg(int hap){
		double result = hap/5.0;
		System.out.println("평균은 "+result);
	}
	void usersPrint(){
		for(int i=0;i<users.length;i++){
			System.out.println(users[i]);
		}
	}
	public static void main(String[] args) {
		Quiz1 q1 = new Quiz1();
		q1.setArray();
	}
}
