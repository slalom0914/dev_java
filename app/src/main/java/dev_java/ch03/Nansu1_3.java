package dev_java.ch03;

import java.util.Scanner;

public class Nansu1_3 {
  int com = -1;

  public void ranCom() {
    com = (int) (Math.random() * 10);// 10을 곱하는 이유는 구간을 늘리기 위함
  }

  // user변수때문에 변수 my를 삭제하였다.
  // 사용자가 입력한 값을 지변에 담아야 하는 이유에 대해 설명하시오.
  // ==> 게임이 진행되는 동안에 계속 바뀌어야 하니까
  // 또 com변수는 왜 전역변수 이어야만 하는지에 대해서도 말해보시오.
  // ==> 정답을 맞출 때까지는 값이 유지되어야 하니까
  public String 판정하기(int user) {
    String msg = null;
    // 정답보다 입력한 값이 작니?
    if (com > user) {
      msg = "높여라";
    }
    // 정답보다 입력한 값이 크니?
    else if (com < user) {
      msg = "낮춰라";
    } else if (com == user) {
      msg = "정답";
      // return msg;if문에서 해당메소드를 탈출할 때 return예약어 사용가능함
      // 반복문에서는 break문 사용한다.
    }
    return msg;
    // return null;
  }

  public static void main(String[] args) {
    // 실행하자 마자 채번하도록 코딩하시오. - 생성자활용
    // 생성자 역할 - 전변 초기화, 부모클래스 초기화 포함 - 상속
    Nansu1_3 n = new Nansu1_3();
    // 컴터가 채번한 값을 초기화하는 메소드 호출하기
    n.ranCom();// 새게임을 누르면 - 재사용성, 정답을 봤니?
    // 컴터가 채번한 숫자를 출력하시오.
    System.out.println("컴터가 채번한 숫자는 ===> " + n.com);// 전변이다. 그리니까 인스턴스변수. 유지
    // Scanner를 활용하여 사용자가 입력한 값을 받으시오.
    Scanner s = new Scanner(System.in);// 장치로부터 듣기 - 소통 - 매번 새로 받아옴 - 반복문안에 올것
    int i = 1;// 회차 표시함
    String 입력값 = null;
    String 반환값 = null;
    // 게임 기회는 5회로 제한하시오.
    while (i < 4) {// 주의사항 - 무한루프 방지코드를 작성할 것. - break;
      System.out.print("0부터 9사이의 숫자를 입력하세요");
      입력값 = s.nextLine();// 사용자가 입력한 값 받아오기 - nextLine()반환값이 있다
      System.out.println(입력값);// null이 아닌지 확인한다
      // 알면서도 잡지 못하는 Exception -> NullPointerException
      int user = Integer.parseInt(입력값);// NumberFormatException
      반환값 = n.판정하기(user);
      i++;
      if ("정답".equals(반환값)) {
        // 정답을 맞추었을 경우 축하합니다. 라고 말한 뒤
        // 새 게임 진행 여부를 물어보시오.
        System.out.println("축하합니다.");
        // 정답을 맞췄는데 왜 4를 주나요?
        i = 4;
        // break;
      }
      // 시도 할 때 마다 몇번째 기회를 사용하는지 출력하시오.
      System.out.println(user + " : " + 반환값);

      // 주어진 기회를 모두 사용하였습니다.
      if (i == 4) {
        System.out.println("주어진 기회(또는 맞추었음)를 모두 사용하였다.\n 새게임을 시작하려면 Y아님N을 입력하시요.");
        String choice = s.nextLine();
        if ("Y".equals(choice)) {
          n.ranCom();
          // 새게임 시작 - 채번을 다시 해야 함 - ranCom()호출하기
          System.out.println("새게임을 시작합니다. ==> 정답: " + n.com);
          i = 1;
        } else if ("N".equals(choice)) {
          System.out.println("종료합니다.\n");
          System.exit(0);// JVM과의 연결고리 끊김
        }
      }
    } // end of while
    s.close();// Stream, I/O, network, 사용 후 반드시 닫는다.
  }
}
