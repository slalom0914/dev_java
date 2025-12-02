package ch05;

import javax.swing.*;

public class ObjectArray01 {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        JButton btns[] = new JButton[5];
        String btns_label[] = {"동쪽[0]","서쪽[1]","남쪽[2]","북쪽[3]","중앙[4]"};
        for(int i=0;i<btns.length;i++){//btns.length = 5
            btns[i] = new JButton(btns_label[i]);
        }
        jf.add("East", btns[0]);
        jf.add("West",btns[1]);
        jf.add("South", btns[2]);
        jf.add("North",btns[3]);
        jf.add("Center", btns[4]);
        jf.setSize(500,500);
        jf.setVisible(true);
    }
}
