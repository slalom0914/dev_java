package dev_java.grade1208;

import java.util.Scanner;

public class Test1 {
    // 선언부

    // 메서스 선언
    public void count() {
        System.out.println("count호출");// 로그에 출력할 값
        Scanner s = new Scanner(System.in);
        boolean isOk = false;
        while (!isOk) {
            System.out.print("문자열을 입력해 주세요. : ");
            String str = s.nextLine();
            if ("exit".equals(str)) {
                break;// while문을 탈출하기
            } else {
                System.out.println(str.length() + "글자 입니다.");
            }
        } // end of while
        s.close();
        System.out.println("프로그램을 종료합니다.");
    }// end of count()

    // 메인메소드
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.count();

    }
}
