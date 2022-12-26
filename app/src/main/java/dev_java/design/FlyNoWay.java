package dev_java.design;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("날지 못합니다.");
	}

}
