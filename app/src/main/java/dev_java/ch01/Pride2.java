package dev_java.ch01;

public class Pride2 {

  int speedUp(int speed) {
    speed = speed + 1;
    //
    System.out.println("speedUp메소드 안에서 : " + speed);// 1
    return speed;
  }

  public static void main(String[] args) {
    Pride2 myCar = new Pride2();
    myCar.speedUp(0);

  }
}
