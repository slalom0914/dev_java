package dev_java.ch01;

public class Wrappper1 {

  public static void main(String[] args) {
    Integer i = new Integer(10);
    int j = i;
    System.out.println(i);
    System.out.println(j);
    String x = String.valueOf(j);
    // String y = j;
    String y = x;
    System.out.println(y);// 10
    if (y instanceof String) {
      System.out.println("y는 String 타입 입니다.");
    }
    if (i instanceof Integer) {
      System.out.println("i는 Integer 타입 입니다.");
    }
  }
}
