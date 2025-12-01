package ch03;

import javax.swing.*;

// 대화형 프로그래밍 연습해 보기
public class Oper02 {
    public static void main(String[] args) {
        //메서드를 호출할 때 파라미터 갯수와 타입을 맞춰야 합니다.
        //이 말은 같은 이름의 메서드를 허용함
        //자바에서는 같은 이름의 메서드를 중복하여 선언할 수 있다.
        //단 파라미터의 갯수가 다르거나 또는 타입이 다르면 된다.(합법)
        //내가 구현하는 능력을 키우기위해 라이브러리를 적극적으로 활용해 보시라.
        String r1 = JOptionPane.showInputDialog("1부터 9사이의 숫자를 입력하세요.");
        String r2 = JOptionPane.showInputDialog
                ("1부터 9사이의 숫자를 입력하세요.",0);
        if(1<= Integer.parseInt(r1) && Integer.parseInt(r1) <=9){
            System.out.println(r1);
        }else{
            System.out.println("1부터 9사이의 숫자만 입력해야 합니다.");
            return;//다음 로직으로 이동할 수 없다. - 유효성체크 - Front-End - 자바스크립트
        }
        System.out.println("else인 경우 여기가 실행기회를 갖지 못합니다. return을 만나니까");
        System.out.println(r2);


    }
}
