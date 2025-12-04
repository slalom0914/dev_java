package ch05.aobject2.design;

import javax.swing.*;

//조회버튼에 주소번지를 가짐 -> 클릭하면 -> 감지 ->  actionPerformed메서드 호출
//그런데 내 안에 없다?
public class JFrame01View {
    JFrame jf = new JFrame();
    JButton btn = new JButton("조회");
    JFrame01Event jevent = new JFrame01Event(this);
    JFrame01Logic jlogic = new JFrame01Logic();
    public JFrame01View(){
        initDisplay();
    }
    public void initDisplay(){
        System.out.println("initDisplay호출 성공");
        //아래 코드가 있어야 actionPerformed가 호출될 수 있음.
        btn.addActionListener(jevent);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add("North", btn);
        jf.setSize(500,400);
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame01View jv = new JFrame01View();
    }
}
