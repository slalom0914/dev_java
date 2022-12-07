package dev_java.ch03;

public class Array1 extends Object {// 상속 - 확장, 재사용(오버라이딩경우), 재정의해서 쓴다
  public static void main(String[] args) {
    // 선언과 생성을 나누어 할 수 있다.
    // 이른주입 인가 아니면 게으른 주입인가
    // 게으른 인스턴스화 는 선언과 생성을 분리함
    // 이른 인스턴스화는 선언부에 선언과 생성을 한번(한문장)에 작성함
    int i[];
    // int j[3] = new int[3];
    i = new int[3];
    // 초기화 없다. 아직.... 0 0 0
    // 객체배열 null, null, null
    System.out.println(i[0]);
    int x = 3;
    boolean isOk = false;
    try {
      //문법에러는 Exception과는 상관없다. - 런타임에러
      //예외가 발생할 가능성이 있는 코드를 감싼다
      System.out.println(i[x]);

    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("인덱스가 범위를 넘었다");
    }
    System.out.println("여기");
  }
}
