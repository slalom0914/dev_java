package dev_java.ch01;

public class Pride1 {
  int speed = 0;//현재 나는 전시장에 서있어요
  int speedUp(){
    speed = speed + 1;
    //
    System.out.println("speedUp메소드 안에서 : "+speed);//1
    return speed;
  }
  public static void main(String[] args) {
    Pride1 myCar = new Pride1();
    myCar.speedUp();
    //
    System.out.println("main 메소드 안에서 : "+myCar.speed);//1
  }
}
