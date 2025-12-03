package ch05;

import javax.swing.*;

public class B3 {
    //변수선언이라 함 - 생성은 아직이다. ->new가 없다.
    JFrame jf = null;
    public static void main(String[] args) {
        //static 영역에서는 non-static변수 jf는 사용이 불가함.
        B3 b3 = new B3();//인스턴스화라고 함. b3을 인스턴스 변수라함
        //주소번지 두 번을 접근해야 호출이 가능함. - 간접 참조방식
        //B3클래스와 JFrame클래스는 서로 의존관계 있다.
        if(b3.jf == null){
            b3.jf = new JFrame();
        }
        b3.jf.setSize(500,400);
        b3.jf.setVisible(true);
    }
}
