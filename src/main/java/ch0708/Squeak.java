package ch0708;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("삑삑~~");
    }
}
