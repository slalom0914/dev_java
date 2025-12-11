package ch0708;
//클래스 예약어 앞에 abstract붙이면 추상클래스가 된다.
//추상클래스는 생성자 가질 수 있고, 추상메서드 가질 수 있고
//일반메서드도 가질 수 있다.
//추상클래스는 생성자를 가지지만 단독으로 인스턴스화 할 수 없다.
//List li = new List()
//Duck myDuck = new Duck();
public abstract class Duck {
    FlyBehavior flyBehavior = null;
    QuackBehavior quackBehavior = null;
    //메서드 오버라이딩은 선언부를 손대지 않는다. -> 생성자
    public Duck(){
        System.out.println("Duck디폴트 생성자 호출");
    }
    //추상메서드는 기능에 대해 클래스가 결정되지 않아서 구현할 수 없을 때
    public abstract void fly();
    public abstract void quack();
    public abstract void display();
    public void swimming(){
        System.out.println("모든 오리는 물위에 뜹니다.");
    }
}
