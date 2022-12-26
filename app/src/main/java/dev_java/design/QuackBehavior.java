package dev_java.design;

//단독으로 인스턴스화 불가함 - 구현체클래스가 있어야 함
// QuackBehavior qb = new MuteQuack();
// QuackBehavior qb = new Quack();
// QuackBehavior qb = new Squeak();
public interface QuackBehavior {
	// public QuackBehavior(){}
	// 메소드 선언시 추상클래스와는 다르게 abstract예약어를
	// 생략할 수 있다. 왜냐면 추상만 가능하니까.... 나는
	public abstract void quack();
}
