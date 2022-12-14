package dev_java.quiz1213;

class S11 {
	static int i;// 0, 전변성격 - 글로벌하게 사용가능함-인스턴스화 없이 사용이 가능함-복제본만들지 마라
	int j;
}
class S12 {
	void n() {
		S11 s1 = new S11();
		s1.j = 50;
		System.out.println("n() 호출 전 j는 ===> " + s1.j);// 0-> 10-> 100-> 500		
	}
}
public class StaticTest2 {
		public static void main(String[] args) {
		// insert here
		S11.i = 10;
		S11 s1 = new S11();
		s1.j = 100;
		System.out.println(S11.i);
		System.out.println(s1.j);
		S12 s2 = new S12();
		// 메소드이름뒤에 세미콜론이면 메소드 호출임
		s2.n();// n메소드 호출했니? 네 경유했다
		System.out.println("n() 호출 후 j는 ===> " + s1.j);// 0-> 10-> 100-> 500
	}
}
