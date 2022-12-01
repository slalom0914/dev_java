package dev_java.ch01;

public class A1 {
  int x;
  void methodA(){
    System.out.println(x);//0
  }
  public static void main(String[] args) {
    //insert here 
    A1 a1 = new A1();
    a1.methodA();
  }
}
