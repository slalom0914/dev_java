package dev_java.network3;

public abstract class MyCar {
	public abstract void display();

	private int wheelNum = 0;//바퀴수

	public MyCar() {
		System.out.println("MyCar() 호출");
	}

	public MyCar(int wheelNum) {
		System.out.println("MyCar(int) 호출");
		this.wheelNum = wheelNum;
	}

	public void go() {
		System.out.println("나는 앞으로 간다.");
	}
}
