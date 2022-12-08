package dev_java.grade1208;

public class Test1 {
  //선언부

  //메서스 선언
  public void count() {

  }
  //메인메소드
  public static void main(String[] args) {
    String s1 = new String("안녕");
    String s2 = new String("안녕");
    String s3 = "안녕";
    String s4 = "안녕";
    if(s1 == s2) System.out.println("주소번지가 같니?");
    if(s1.equals(s2)) System.out.println("주소번지가 같니?");
    if(s3 == s4) System.out.println("주소번지가 같니?");
    if(s3.equals(s4)) System.out.println("주소번지가 같니?");
    
  }
}
