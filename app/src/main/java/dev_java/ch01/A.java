package dev_java.ch01;

public class A {
  int i = 1;
  static int  j = 2;
  void methodA(){//non-static메소드선언이다.
    System.out.println(i);
  }
  public static void main(String[] args) {
    A a = new A();
    System.out.println(a.i);//1
    System.out.println(j);//2
  }
}
