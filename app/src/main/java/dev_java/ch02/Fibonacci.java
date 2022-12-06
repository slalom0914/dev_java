package dev_java.ch02;

public class Fibonacci {
  public static void main(String[] args) {
    int a1 = 1;
    int a2 = 1;
    int a3 = 0;
    System.out.print(a1+" "+a2+" ");
    for(int i=0;i<8;i++){
      a3 = a2 + a1;
      System.out.print(a3 + " ");
      a1 = a2;//두번째 수를 세번째수로
      a2 = a3;//현재의 수를 첫번째수로
    }
  }
}
