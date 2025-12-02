package ch04;

import java.util.Random;
import java.util.Scanner;

/*
0부터 9사이이 임의의 숫자를 채번한다.
기회는 총 5번까지 제공하자.
임의의 숫자를 맞추는 게임을 구현하시오.
힌트는 정답보다 크면 낮춰라
정답보다 적으면 높여라
정답인 경우에는 축하합니다. 종료처리하기
 */
public class For02 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        //채번한 숫자를 담을 변수 선언
        int dap = r.nextInt(10);//
        int my = -1;
        int cnt = 1;
        while(true){//반복문 - 주의: 무한루프에 빠질 수 있다.
            System.out.print("0부터 9사이의 정수를 입력하시오.");
            my = sc.nextInt();
            System.out.println("사용자가 입력한 정수는 "+my + " 입니다.");
            if(cnt == 5){
                System.out.println("5번 기회를 모두 사용하였습니다.");
                sc.close();
                //JVM과 연결고리 끊김-스레드 종료-강제종료처리됨
                System.exit(0);
            }else {
                System.out.println("비교하고 정답이 아니면 힌트문 주고 ..반복");
                cnt++;
            }//end of 조건문
        }//end of while
    }//end of main
}
