package ch0708;

public class RubberDuck extends Duck {
    //생성자는 전역변수에 대한 초기화를 담당함.
    //전역변수는 보통 고유명사 선택함 - > 사물에대한 특성을 갖는변수
    //추상 클래스를 상속받아 만들어진 고무오리는 생성자 안에서
    //특성을 결정지을 수 있다.
    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
        //flyBehavior = new FlyWithWing();
    }
    @Override
    public void fly() {
        flyBehavior.fly();//나는 날지 못합니다.
    }

    @Override
    public void quack() {
        quackBehavior.quack();
    }

    @Override
    public void display() {

    }
}
