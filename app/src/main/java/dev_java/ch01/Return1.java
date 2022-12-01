package dev_java.ch01;

public class Return1 {
  void m() {

  }

  int m1() {
    return 2;
  }

  double m2() {
    return 2.5;
  }

  boolean isView() {
    return false;
  }

  boolean isView1() {
    boolean bool = true;
    return bool;
  }

  String getName() {
    String name = "이순신";
    return name;
  }

  public static void main(String[] args) {
    Return1 r1 = new Return1();
    // int x = r1.m();
    int y = r1.m1();
    // System.out.println(r1.m());
    System.out.println("r1.m1() : " + r1.m1());
  }
}
