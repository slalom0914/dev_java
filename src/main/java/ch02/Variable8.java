package ch02;

import java.util.Scanner;
// 자바가상머신이 제공하는 클래스가 있다.
// 클래스 구성 요소 중 한 가지는 메서드 이다.
// 제공되는 parseInt메서드를 나는 활용할 수 있다.
public class Variable8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("0부터 9사이의 숫자를 입력하시오 \n");
        String userInput = sc.nextLine();
        System.out.println("당신이 입력한 숫자는 "+userInput + " 입니다.");
        //userInput이 String 타입입니까? true이면 그렇다, false이면 String타입이 아니다
        System.out.println(userInput instanceof  String);
        System.out.println(Integer.parseInt(userInput)+2);//5가 출력된다.
        int imsi = Integer.parseInt(userInput);
        System.out.println(imsi);
        //문자열+숫자=문자열이다.
        System.out.println("5"+2);//52
        //원시형 타입에는 8가지가 있다.
        //char, byte, short, int, long, float, double, boolean(if,for, 조건문사용)
        //원시형 타입은 호출하면 값이 출력된다.
        //참조형 타입은 호출하면 주소번지가 16진수로 출력된다.
    }
}
