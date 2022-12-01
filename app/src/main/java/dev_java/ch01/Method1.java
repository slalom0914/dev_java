package dev_java.ch01;

public class Method1 {
  // 파라미터 자리에는 비워두거나 원시형을 쓰거나 참조형도 올 수 있다.
  // 파라미터 자리는 호출하는 곳에서 결정이 된다.
  // 파라미터 자리에 변수는 언제 초기화가 될까요? - 메소드가 호출될 때 결정됨
  // 메소드 호출은 어디서 하지? - main메소드 안에서 해야 호출된다.
  // 메소드의 파라미터 자리는 오직 선언만 가능함. - 초기화는 불가하다. - 불법이다.
  // 증명해 봐
  // 값에 의한 호출이다.
  void m(int i) {// 파라미터 자리에는 사용자가 입력한 값이 담김 // 5가 복사된다
    i = i + 2;
    i = (i*0) + 10;
    //insert here - 10이 출력되도록 코드를 추가해 보세요
    // i = 5;
    System.out.println(i);//5
  }//////// end of m

  double m1(double d) {
    return 3.5;
  }//////// end of m1

  void m() {
  }

  public static void main(String[] args) {
    // Method1클래스 안에 정의된 메소드만 호출이 가능함.
    Method1 method1 = new Method1();
    // 자바에서는 같은 이름의 메소드를 중복선언 할 수 있음.
    // 파라미터의 갯수가 다르거나 또는 타입이 다르면 인정해줄께 - 메소드 오버로딩
    method1.m(5);// 메소드 호출
  }//////// end of main
}
