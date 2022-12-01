package dev_java.ch01;

public class Pride {
  static String carName = "2023년형 프라이드";
  String carColor = "흰색";
  int wheelNum = 4;
  public static void main(String[] args) {
    System.out.println(carName);//
    //인스턴스화 라고 함 - Pride객체가 메모리 상주 -> 호출이 가능한 상태
    Pride myCar = new Pride();//myCar를 인스턴스 변수라 한다.
    //myCar.carColor = "검정색";
    System.out.println(myCar.carColor);
    myCar.carColor = "검정색";
  }
}
