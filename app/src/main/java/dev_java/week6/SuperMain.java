package dev_java.week6;

class Sup {
	void go() {
		System.out.println("Sup go호출");
	}

	void stop() {
		System.out.println("Sup stop호출");
	}
}

class Sub extends Sup {
	Sub(){
		//super.stop();
		//현재 활성화되어 있는....
		//this.stop();//현재 인스턴스화 되어 있는- 생성되어진 객체
	}
	@Override
	void stop() {
		System.out.println("Sub stop호출");
	}
}

public class SuperMain {
	public static void main(String[] args) {
		Sup sup = new Sup();
		System.out.println(sup);
		// sup.stop();
		Sub sub = new Sub();
		// sub.go();
		System.out.println(sub);
		sup = sub;
		System.out.println(sup);
		// sup = new Sub();
		//이럴때 부모가 가진 stop메소드는 은닉메소드라고 한다. shadow method라고 함
		//sup.stop();
		//this나 super예약어는 static이 있는 메소드 영역에서 사용불가함-컴파일에러발생함
		//super.stop();
		// sub.stop();
	}
}
