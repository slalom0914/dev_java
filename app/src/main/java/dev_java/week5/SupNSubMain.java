package dev_java.week5;

class Sup {
	Sup() {// 부모 디폴트 생성자 선언하기

	}

	public void m() {
		System.out.println("Sup m()호출");
	}
}

class Sub extends Sup {
	Sub() {// 자손 디폴트 생성자 선언하기
		this.m();
	}

	@Override
	public void m() {
		System.out.println("Sub m()호출");
	}

}

public class SupNSubMain {
	public static void main(String[] args) {
		// insert here
		Sup sup = new Sup();//
		// sup.m();
		Sub sub = new Sub();//Sub m()호출
		// sub.m();
		// 선언부(Sup) = 생성부(Sub)
		// 부모의 메소드는 shadow메소드(은닉)
		Sup sup2 = new Sub();//Sub m()호출
		//
		// sup2.m();//
		//아래에서 sup을 대입하는 경우에는 실제 생성된 객체도 Super타입입니다.
		//따라서 강제 형전환을 하더라도 그래서 문법적인 문제는 해결을 했어도 실제로 가리키는
		//객체는 상위 객체이므로 에러가 발생합니다.
		//그러나 sup2로 하게 되면 실제 생성된 객체가 자손인 Sub타입이니까
		//타입은 달라서 강제형전환 해야 되지만 실제 가리키는 객체가 자손 타입이므로
		//에러 없이 실행도 잘 됩니다.
		sub  = (Sub)sup2;// sub = new Sup();
		sub.m();
		int i = (int)23.5d;
		System.out.println(i);//23

	}

}
