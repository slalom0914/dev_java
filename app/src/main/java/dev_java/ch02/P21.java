package dev_java.ch02;

public class P21 {
  void methodA(int i, int j){//call by value -  지변의 값은 호출될 때 결정됨
    j = ++i;
    System.out.println("i : "+i+", j : "+j);
  }
  void methodB(int i, int j){//call by value -  지변의 값은 호출될 때 결정됨
    j *= i;
    System.out.println("i : "+i+", j : "+j);
  }
  public static void main(String[] args) {
    P21 p21 = new P21();
    p21.methodA(1, 2);
    p21.methodB(1, 2);
    int i = 1;//i = 1
    int j = i++;//2, 1
    System.out.println(i+", "+j);
  }
}
