package ch03;

import javax.swing.*;

public class Oper03 {
    public static void main(String[] args) {
        //첫번째 숫자를 입력 받고 두 번째 숫자도 입력 받아서
        // 두 수의 합을 구하는 프로그램을 작성하시오.
        //첫번째 숫자를 담을 변수 선언
        int first = 0;
        //두번째 숫자를 담을 변수 선언
        int second = 0;
        String sFirst = null;
        sFirst = JOptionPane.showInputDialog("첫번째 숫자를 입력하세요.");
        System.out.println(sFirst);
        //Integer는 int원시타입에 대한 래퍼클래스임.
        //왜 필요하지? - 원시형타입은 메서드나 field를 소유할 수  없다.
        //왜냐면 클래스가 아니라서...
        //메서드 선언부에 static붙어 있으면(main) 인스턴스화 없이도 바로 사용 가능함
        //static이 붙은 메서드는 복제본을 만들지 않음 -  싱글턴 패턴
        first = Integer.parseInt(sFirst);
        System.out.println("당신이 입력한 숫자?는 "+first+ " 입니다.");
        //만일 사용자가 숫자가 아닌 다른 문자를 입력을 한다면???
        System.out.println("여기");

    }
}
