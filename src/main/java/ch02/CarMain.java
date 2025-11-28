package ch02;
class Sonata{
    int wheelNum = 4;
    int speed = 0;
}
public class CarMain {
    public static void main(String[] args) {
        //참조형 변수 -> 호출하면 주소번지 출력됨
        Sonata myCar = new Sonata();
        myCar.speed = 50;
        //Sonata herCar = new Sonata();
        Sonata herCar = myCar;
        herCar.speed = 60;
        System.out.println(myCar +", "+herCar);
        System.out.println(myCar.speed +", "+herCar.speed);//50, 60
    }
}
