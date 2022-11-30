package dev_java.ch01;

public class Variable1 {
  int x;

  // 나는 파라미터가 없는 메소드 입니다.
  // 나는 반환형이 없다.
  void methodA() {
    int i;
    i = 1;
    x = i;
    System.out.println("i: " + i);
  }

  public static void main(String[] args) {
    // insert here
    Variable1 variable1 = new Variable1();
    variable1.methodA();
    System.out.println("x는 " + variable1.x);
  }
}
