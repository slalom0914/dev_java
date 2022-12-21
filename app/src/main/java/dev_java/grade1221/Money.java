package dev_java.grade1221;

public class Money {
	public static final String UNIT = "원";
	public int money;

	public Money(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public static String getUnit() {
		return UNIT;
	}

	public void print() {
		System.out.println(money + UNIT + "이 있습니다.");
	}
}
