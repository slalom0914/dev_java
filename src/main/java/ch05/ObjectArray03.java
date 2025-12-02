package ch05;

import javax.swing.*;
import java.awt.*;

public class ObjectArray03 {
    public static void main(String[] args) {
        //JFrame의 디폴트 레이아웃은 무엇이었나? - BorderLayout
        JFrame jf = new JFrame();
        jf.setLayout(new GridLayout(3,2));
        //jf.setLayout(new FlowLayout(2));
        JButton btns[] = new JButton[5];
        String btns_label[] = {"동쪽[0]","서쪽[1]","남쪽[2]","북쪽[3]","중앙[4]"};
        for(int i=0;i<btns.length;i++){//btns.length = 5
            btns[i] = new JButton(btns_label[i]);
            jf.add(btns[i]);
        }
        jf.setSize(500,500);
        jf.setVisible(true);
    }
}
