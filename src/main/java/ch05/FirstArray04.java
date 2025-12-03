package ch05;

import javax.swing.*;
import java.awt.*;
/*
배열(Array) : 같은 타입의 데이터 여러 개를 한 번에 저장하기 위한 변수 선언
이름 하나로 여러 개를 관리함- 이름으로 판단이 안됨
배열을 사용할 땐 항상 반복문 같이 사용됨
한계 : 제한된 크기, 끼워넣기 안됨, 같은 타입만 담음, 인덱스로 접근하므로 변수명이 직관적이지 않음
*/
public class FirstArray04 {
    public static void main(String[] args) {
        JFrame  jf              = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new GridLayout(3,2));
        JButton btns[]          = new JButton[6];
        String  btns_label[]    = new String[]
                {"1:1대화","대화명변경","나가기","글자색변경","이모티콘","방만들기"};
        for(int i=0;i<btns.length;i++){//6번을 반복합니다. 0,1,2,3,4,5
            btns[i] = new JButton(btns_label[i]);
            jf.add(btns[i]);
        }
        jf.setSize(600,700);
        jf.setVisible(true);
    }
}
