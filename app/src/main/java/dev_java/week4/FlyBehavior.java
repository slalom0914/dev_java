package dev_java.week4;
//인터페이스가 정의하는 메소드는 모두 추상메소드이다.
//추상메소드는 세미콜론으로 끝남
//구현체 클래스에서 오버라이딩 해서 써야하는 것임
//모두가 추상메소드이므로  abstract예약어는 생략이 가능함
//단독으로 인스턴스화 불가함
public interface FlyBehavior {
	public abstract void fly();
}
