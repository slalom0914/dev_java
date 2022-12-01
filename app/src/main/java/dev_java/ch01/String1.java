package dev_java.ch01;

public class String1 {
  public static void main(String[] args) {
    String s1 = "안녕";
    String s2 = "안녕";
    // 주소번지가 가리키는 값을 비교하려면 equals라는 메소드를 찾아볼것.
    // 주소번지를 비교할 수 있는 것은 참조형 타입인 경우만 가능해요.
    // 원시형 변수는 주소번지를 비교할 수 없어요.
    String s3 = new String("안녕");
    String s4 = new String("안녕");
    // insert here
    // s1와 s2의 주소번지는 같니? 참 혹은 거짓 선택하기
    // 그리고 이유에 대해 옆사람과 토론해 보세요
    // String 클래스는 new를 사용하지 않고 객체를 생성하면 이미 같은 값이 존재할때
    // 기존에 값을 참조한다.
    // 완결편 : 참조형 변수는 new를 사용하므로 무조건 새로운 객체가 만들어 진다.
    System.out.println(s1 == s2);// s1이 가리키는 주소번지와 s2가 가리키는 주소번지가 같니? true
    System.out.println(s1 == s3);
    System.out.println(s1 == s4);
    System.out.println(s2 == s3);
    System.out.println(s2 == s4);
    // s3과 s4의 주소번지가 같니? 다르니? 선택한 후 결과에 대해 말해보세요
    System.out.println(s3 == s4);

    // 만일 s3이 가리키는 문자열이 s4와 같은지를 비교하려면 어떡하지? 구글링 해서 확인해 보기
    System.out.println(s3.equals(s4));
  }
}
