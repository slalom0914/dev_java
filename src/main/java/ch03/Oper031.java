package ch03;

import javax.swing.*;

public class Oper031 {
    public static void main(String[] args) {
        //첫번째 숫자를 입력 받고 두 번째 숫자도 입력 받아서
        // 두 수의 합을 구하는 프로그램을 작성하시오.
        //첫번째 숫자를 담을 변수 선언
        int first = 0;
        //두번째 숫자를 담을 변수 선언
        int second = 0;
        String sFirst = null;
        String sSecond = null;
        sFirst = JOptionPane.showInputDialog("첫번째 숫자를 입력하세요.");
        first = Integer.parseInt(sFirst);
        //int와 Integer의 경우 오토박싱의 지원으로 타입을 자동으로 전환해줌.
        //원시형타입과 Wrapper클래스는 별도로 타입을 맞춰 주지 않아도 자동으로 처리됨
        sSecond = JOptionPane.showInputDialog("두번째 숫자를 입력하세요.",0);
        //new Integer(괄호안에 정수인 경우) 더 이상 지원하지 않습니다. -Deprecated
        //sSecond = JOptionPane.showInputDialog("메시지",new Integer(0));
        second = Integer.parseInt(sSecond);
        //System.out.println(second);
        System.out.println("두 수의 합은 "+(first+second));
        System.out.println("1"+2);//3이 출력되지 않고 12가 출력됩니다.


    }
}
