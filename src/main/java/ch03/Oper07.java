package ch03;

import java.util.Scanner;

/*
문제 요구사항
점수가 60점 이상이면 합격을 출력하고
그렇지 않으면 불합격을 출력하는 문장을 완성하시오.
- 필요한 변수는 몇 개 입니까?
- 필요한 변수의 타입은 무엇입니까?
 */
public class Oper07 {
    public static void main(String[] args) {
        int score = 0;
        System.out.print("당신의 점수를 입력하세요. : ");
        // 사용자로 부터 점수를 입력받는 코드는?
        Scanner sc = new Scanner(System.in);
        score = sc.nextInt();
        if(score >=60){
            System.out.println("합격");
        }else{//위 조건을 제외한 나머지 모두인 경우
            System.out.println("불합격");
        }
    }//end of main
}//end of Oper07
