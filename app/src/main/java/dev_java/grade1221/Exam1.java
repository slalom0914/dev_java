package dev_java.grade1221;
/*
 * 자바에서는 같은 이름의 메소드를 중복 선언 가능하다
 * 메소드오버로딩(MethodOverloading) - 이것과 관계 - 생성자컨셉
 * :무조건 파라미터의 갯수나 타입이 달라야 한다.
 * 접근제한자가 있고 없고는 영향이 없다.
 * 리턴타입이 있고 없고는 영향이 없다.
 * 예외를 던지고 던지지않고는 영향이 없다.
 * 파라미터의 변수이름이 다른것은 영향이 없다.
 * 메소드오버라이딩(MethodOverriding)-문제와 상관없음
 * 
 */
public class Exam1 {
	public void methodA(){}
	public void methodA(int a){}
	//나를 호출한 곳에서 예외처리를 받으세요.
	public void methodA(int a) throws Exception
	{

	}
	public void methodA(double d, String name){
		
	}
	public void methodA(String name, double d){

	}
	//public void methodA(int b){}
	//public int methodA(){ return 1;}
}
