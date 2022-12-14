package dev_java.quiz1213;
//메소드이름을 같은 이름으로 하였다. - 이럴 경우 메소드 오버로딩을 따져야함
class RectAngle2 {
	void area(int w, int h){
		int area = w * h;
		System.out.println("면적은 "+area);
	}
	/* 
	int area(int w, int h, int result){
		result = w * h;
		return result;
	}
	*/
	long area(long w, long h){
		return w*h;
	}
}

public class RectAngle2Main {
	public static void main(String[] args) {
		RectAngle2 r2 = new RectAngle2();
		r2.area(2, 3);//값에 의한 호출 - call by value
		//insert here
		double result = r2.area(2L, 3L);
		System.out.println("return타입이 있는 메소드 : "+result);
		int result2 = (int)r2.area(2L, 3L);
		System.out.println("return타입이 있는 메소드2 : "+result2);
	}
}

/*
 * 메소드 꺼낸다 - 사용자 정의 메소드 구현
 * 리턴타입을 결정하자
 * void일 때
 * 
 * int일 때
 * 
 * 출력하기 - where?
 * 
 * 파라미터는 갯수를 나는 결정할 수 있다.
 * 또 파라미터의 타입도 선택할 수 있다.
 */