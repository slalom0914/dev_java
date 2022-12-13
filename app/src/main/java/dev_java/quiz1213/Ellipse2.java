package dev_java.quiz1213;

import java.util.Scanner;

//접근제한자 private > friendly > protected > public 
//static - 변수앞에 , 메소드 앞에, 클래스 앞에
//final -변수앞에(상수) - 메소드앞에(오버라이딩 불가) -클래스 앞에(상속 안됨- 자손못가짐)
public class Ellipse2 {
	//선언부 - 전변은 초기화를 생략가능함 - 왜냐하면생성자가 해주니까...
	static double area;//0.0
	final double PI = 3.14;
	//자바에서는 같은 이름의 메소드를 중복 선언할 수 있음.
	//단 파라미터의 갯수가 다르거나 또는 타입이 달라야 함 - 메소드오버로딩이라함
	double 면적구하기(){
		return 0.0;
	}
	// 리턴타입을 결정할 수 있니? - 너 메인메소드에서 면적 출력할꺼니? - 그러면 double로 할께
	// 파라미터의 갯수와 타입까지도 선택할 수 있나?
	double 면적구하기(int i1, int i2) {
		area = i1 * i2 * PI;// int*int*double=double
		return 0.0;
		//return (float)3.5;
	}

	public static void main(String[] args) {
		Ellipse2 e2 = new Ellipse2();
		int r1 = 0, r2 = 0;// 반지름 2개 담을 변수 선언

		// new 다음에 오는 클래스가 생성됨 - 이 때 생성자 호출됨(마치 메소드처럼)
		Scanner s = new Scanner(System.in);// 인스턴스화-메모리에 로딩-메소드나 변수 누린다.
		System.out.print("첫번째 반지름  입력하세요");
		String user1 = s.nextLine();
		System.out.println("사용자가 입력한 첫번째 반지름은 ===" + user1);
		System.out.print("두번째 반지름  입력하세요");
		String user2 = s.nextLine();
		int i1 = Integer.parseInt(user1);// 첫번째반지름을 원시형 int로 저장함 - 곱셈해야 하니까
		int i2 = Integer.parseInt(user2);// 두번째반지름을 원시형 int로 저장함 - 곱셈해야 하니까
		e2.면적구하기(i1, i2);
		System.out.println("타원형의 면적은 " + Ellipse2.area + " 입니다.");//공유,하나, 원본이 바뀐다
	}
}
