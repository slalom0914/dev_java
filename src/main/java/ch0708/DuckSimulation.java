package ch0708;

public class DuckSimulation {
    public static void main(String[] args) {
        //Duck duck = new Duck();
        //FlyBehavior fb = new FlyBehavior();
        Duck myDuck = new MallardDuck();
        myDuck.display();//나는 청둥오리 입니다.
        myDuck.fly();//나는 날고 있어요
        Duck himDuck = new WoodDuck();
        himDuck.fly();//나는 날지 못합니다.
        himDuck.display();//나는 나무오리 입니다.
    }
}
//같은 이름의 메서드 이지만 구현체 클래스에 따라 기능이 달라진다.-다형성
//선언부 타입과 생성부의 타입이 다르면 기대할 수 있다.
//추상클래스와 인터페이스는 모두 추상메서드를 가질 수 있다.
//추상메서드는 이름과 리턴타입, 파라미터만 결정되어 있을 뿐
//기능에 대해서는 구현체 클래스에서 메서드 오버라이딩 한다.