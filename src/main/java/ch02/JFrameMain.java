package ch02;

import javax.swing.*;

public class JFrameMain {
    public static void main(String[] args) {
        //인스턴스화를 각각 하였으므로 타입은 같지만
        //서로 다른 객체입니다.
        JFrame jf1 = new JFrame();
        JFrame jf2 = new JFrame();
        jf1.setTitle("회원가입");
        jf1.setSize(500,300);
        jf1.setVisible(true);
        jf2.setTitle("로그인");
        jf2.setSize(300,500);
        jf2.setVisible(true);
    }
}
