package ch06;

import javax.swing.*;
//서로 다른 두 개의 클래스가 변수를 공유하고자 한다면 전변으로 선언함.
class C2{
     int width = 200;
     int height = 300;
}
public class C2Main {
    JFrame jf1 = new JFrame();
    JFrame jf2 = new JFrame("제목");
    public static void main(String[] args) {
        C2Main cm = new C2Main();
        C2 c2 = new C2();
        cm.jf1.setSize(c2.width,c2.height);
        cm.jf1.setVisible(true);
        cm.jf2.setSize(400,300);
        cm.jf2.setVisible(true);

    }
}
