package ch05.aobject2.design;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//생성자는 리턴타입이 올 수 없다.
public class JFrame01Event implements ActionListener {
    public JFrame01Event(){
        System.out.println("JFrame01Event 생성자 호출 성공");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
