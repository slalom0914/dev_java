package dev_java.grade1221;

import java.util.Scanner;

//클래스 하나에 기능은 하나만...
class Exam2{
	public void methodA(){
		//절차적 사고 - 스토리텔링 - 소통 - 파라미터와 리턴타입
		System.out.print("수정이면 1, 삭제이면 2를 누르세요.");
		Scanner s = new Scanner(System.in);
		int choice = 0;
		choice = s.nextInt();
		if(choice >2 || choice < 0 ){
			System.out.println("1 혹은 2 중에서 입력하세요.");
			//return;
		}else{
			System.out.println("정상인 경우");
		}
	}
}

public class Exam2Main {
	public static void main(String[] args) {
		Exam2 e2 = new Exam2();
		e2.methodA();
	}
}
