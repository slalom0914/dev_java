package ch0708;

public class FlyWithWing implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("나는 날고 있어요.");
    }
}
