package dev_java.ch01;
//static은 변수앞에 메소드 앞에 올 수 있다.

//static이 있으면 정적변수, 정적 메소드라 한다.
//인스턴스화 없이 어디서나 호출할 수 있다.
//non-static에서 호출할 수  있다|없다

public class StaticExam1 {
  int i;// 전역변수는 초기화를 생략할 수 있다. 그러면 디폴트값은 0이다.
  static int j;

  void methodA() {
    i = i + 1;
    j = i * 2;
    System.out.println("i : " + String.valueOf(i));// 1
    System.out.println("j : " + String.valueOf(StaticExam1.j));// 2
  }

  public static void main(String[] args) {
    StaticExam1 staticExam1 = new StaticExam1();
    staticExam1.methodA();
  }
}
