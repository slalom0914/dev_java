package ch0708;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("무음");
    }
}
