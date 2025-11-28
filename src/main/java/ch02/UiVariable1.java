package ch02;

import javax.swing.*;

public class UiVariable1 {
    public static void main(String[] args) {
        //윈도우가 제공하는 창을 구현한 클래스가 JFrame이다.
        JFrame jf = new JFrame();
        //JFrame클래스에는 setSize와 setVisible메서드가 선언되어 있음.
        //인스턴스변수로 호출이 가능하다.
        //호출할 때는 파라미터의 타입과 갯수를 맞추어야 한다.
        //insert here
        //창의 가로크기를 정하는 변수를 선언하시오
        int width = 500;
        //창의 세로크기를 정하는 변수도 선언하시오
        int height = 400;
        width = 900;
        jf.setSize(width, height);
        boolean isView = true;
        // 같은 이름의 변수를 두 번 선언은 불가합니다.
        // 재정의할 땐 타입을 떼고 작성하세요.
        isView = false;
        isView = true;
        //jf.setVisible(상수값 대신에 변수를 쓰시오.);
        //setVisible()의 파라미터 자리에는 boolean타입이 와야 합니다.
        //만일 true이면 화면에 보여지고 false이면 화면에 안보입니다.
        jf.setVisible(isView);
    }
}
