package dev_java.grade1221;

public class Run {
	public static void main(String[] args) {
		//클래스는 여러개의 인스턴스를 가질 수 있다.
		Money m = new Money(1000);
		//잔액 - 1000원
		m.setMoney(50);
		//잔액 - 50원
		System.out.println(m.money);
		m.pay(30);
		System.out.println(m.money);
		//Money m1 = new Money(1000);
		//Money m2 = new Money(10000);
	}
}
