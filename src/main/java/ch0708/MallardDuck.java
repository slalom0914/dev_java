package ch0708;
//날 수 있다. ->  FlyWithWing.java
//날지 못합니다. -> FlyNoWay.java
public class MallardDuck extends Duck {
    public MallardDuck() {
        //여기에 flyBehavior변수를 선언하지 않았는데 어떻게 에러가 안나지?
        //Duck에 선언한 변수는 상속받은 클래스에서 사용이 가능함.
        flyBehavior = new FlyWithWing();
    }
    @Override
    public void fly() {
        flyBehavior.fly();//나는 날고 있어요.
    }

    @Override
    public void quack() {

    }

    @Override
    public void display() {
        System.out.println("나는 청둥오리 입니다.");
    }
}
