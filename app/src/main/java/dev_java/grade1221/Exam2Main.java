package dev_java.grade1221;
//클래스 하나에 기능은 하나만...
class Exam2{
	public void methodA(){
		System.out.println("methodA호출 성공");
		//while문 사용시 무한루프 방지코드를 작성할 것.
		//while문안에 증감연산자 있는지 파악할것.
		while(0<2){
			if(2==2) break;
		}
		//여기 오고 싶은데.....
	}
}

public class Exam2Main {
	public static void main(String[] args) {
		Exam2 e2 = new Exam2();
		e2.methodA();
	}
}
