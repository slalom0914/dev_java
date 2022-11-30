package dev_java.ch01;

public class Hello {

  int methodA(int i, int j){
    int hap;
    hap = i + j;
    return hap; 
  }
  // 오늘은 개발 환경 다시 설정
  public static void main(String[] args) {
    Hello hello = new Hello();
    hello.methodA(2, 3);  
    System.out.println("git설정 추가");
    System.out.println("Hello Java!!!");
    System.out.println("111");
  }
}
