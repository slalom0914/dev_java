package dev_java.quiz1213;

class S1{
	static int i;//0, 전변성격 - 글로벌하게 사용가능함-인스턴스화 없이 사용이 가능함-복제본만들지 마라
	static void m(){

	}
}
class S2{
	void n(){
		S1.i = 500;
	}
}

public class StaticTest {
	public static void main(String[] args) {
		//insert here
		S1.i = 10;
		S1 s1 = new S1();
		s1.i  = 100;
		System.out.println(S1.i);
		System.out.println(s1.i);
		S2 s2 = new S2();
		//메소드이름뒤에 세미콜론이면 메소드 호출임
		s2.n();//n메소드 호출했니?  네 경유했다
		System.out.println("n() 호출 후 ===> "+S1.i);// 0-> 10-> 100-> 500
	}
}
