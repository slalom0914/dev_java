package dev_java.ch02;

import java.util.Random;
import java.util.Scanner;

public class Nansu1 {
  public static void main(String[] args) {
    //랜덤하게 채번하는 메소드를 제공하는 클래스 선언 및 생성하기
    Random r = new Random();//new 다음에 오는 이름의 객체가 로딩 -> 생성자 호출도 일어남
    //Scanner클래스를 사용하면 입력장치로 입력된 정보를 받아올 수 있다. - 듣기
    //생성자의 파라미터에 입력장치에 대한 코드가 필요함
    //System - 내가 사용하는 컴터의 장치
    //그 뒤에 변수 in을 붙이면 입력장치를 나타냄
    //사용자로 부터 입력받는 장치를 생성자 파라미터에 적어준다.
    Scanner s = new Scanner(System.in);
    //nextInt메소드는 Scanner클래스가 소유주이다.
    int com = r.nextInt(10);// 0~10
    System.out.println("채번한 숫자는 ===> " + com);
    int my = -1;
    boolean isOk = false;
    while (!isOk) {//무한루프에 빠지는 코드
      //사용자에게 입력받아야 하는 유효한 값에 범위를 출력하기
      System.out.println("0부터 9사이의 정수를 입력하세요");
      //Scanner 클래스가 소유한 nextInt메소드 호출하기
      //nextInt():int 이다.
      my = s.nextInt();
      System.out.println("사용자가 입력한 값 : " + my);
      //컴터가 채번한 값과 사용자가 입력한 값이 같니?
      if (com == my) {// 맞다- 변수가 가리키는 값이 같은지를 비교하는 것임 -  원시형 변수이다. - 직접접근방식
        System.out.println("축하합니다.");
        s.close();//사용한 Scanner의 주소번지는 반드시 닫아줌 - 왜냐하면 위변조를 막기 위해서
        break;
      } else if (com > my) {// 컴터가 채번한 숫자가 사용자가 입력한 값보다 크니?
        System.out.println("높여라");
      } else if (com < my) {
        System.out.println("낮춰라");
      } else if (my == 10) {
        s.close();
        System.exit(0);
      }
    }

  }
}
