package ch03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Oper033 implements ActionListener {
    JFrame jf = new JFrame();
    JTextField jtf_first = new JTextField(5);
    JTextField jtf_second = new JTextField(5);
    JButton btn_account = new JButton("계산");
    JTextField jtf_result = new JTextField(10);
    @Override
    public void actionPerformed(ActionEvent e) {
        //이벤트가 감지된 주소번지를 가져온다.
        Object obj = e.getSource();
        //버튼을 클릭한거야?
        //이벤트 소스와 버튼의 주소번지가 같니
        if(obj == btn_account){
            System.out.println("계산버튼 클릭");
        }
        String sFirst = jtf_first.getText();
        int iFrist = Integer.parseInt(sFirst);
        String sSecond = jtf_second.getText();
        int iSecond = Integer.parseInt(sSecond);
        jtf_result.setText("덧셈을 처리한 결과값이 온다.");
        //setText메서드는 JTextField가 제공하는 것이고  파라미터 타입은
        //String타입으로 정해져 있음.
        //jtf_result.setText(100);
        jtf_result.setText(String.valueOf(iFrist+iSecond));
    }

    public static void main(String[] args) {
        Oper033 op033 = new Oper033();
        //아래 코드가 없으면 actionPerformed메서드가 호출되지 않음.
        op033.btn_account.addActionListener(op033);
        op033.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        op033.jf.setLayout(new FlowLayout(FlowLayout.LEFT));
        op033.jf.add(op033.jtf_first);
        op033.jf.add(op033.jtf_second);
        op033.jf.add(op033.btn_account);
        op033.jf.add(op033.jtf_result);
        op033.jf.setSize(400,300);
        op033.jf.setVisible(true);
    }
}
