package dev_java.design;
//추상클래스
//단독으로 인스턴스화 할 수 없다. 반드시 구현체 클래스 있어야 함. 메소드 오버라이딩
//인터페이스가 추상클래스 보다 더 추상적이다 - 생성자 일반메소드도 갖음 -> 그러니까 덜 추상적임
//생성자는 전변의 디폴트값을 결정할 수 있으니까...
public abstract class Duck {		
	FlyBehavior flyBehavior;	//인터페이스 - 날다, 날지 못한다.
	QuackBehavior quackBehavior;	//인터페이스 - 무음 MuteQuack, 삐~이익 Squeak,  꽥꽥 Quack
	public Duck(){}	//생성자
	public abstract void display();	
	public void performFly(){	
		//FlyWithWings.java, FlyNoWay.java
		flyBehavior.fly();//추상메소드이다.-> Override필요함->구현체클래스가 필요함
	}	
	public void performQuack(){	
		quackBehavior.quack();
	}	
	public void swimming(){	
		System.out.println("모든 오리는 물위에 뜬다");
	}   	
}		

