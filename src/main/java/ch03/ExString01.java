package ch03;

import javax.swing.*;

class D {
}
public class ExString01 {
    public static void main(String[] args) {
        D d = new D();
        System.out.println(d+", "+d.toString());
        JButton btn = new JButton("로그인");
        System.out.println(btn);
        String s = new String("문자열");
        System.out.println(s);
    }
}
