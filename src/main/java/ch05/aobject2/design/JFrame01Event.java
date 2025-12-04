package ch05.aobject2.design;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Spring Boot에서는 개발자가 직접 인스턴스화 하지 않습니다.
//생성자는 리턴타입이 올 수 없다.
public class JFrame01Event implements ActionListener {
    JFrame01View jv = null;
    public JFrame01Event(JFrame01View jv){
        System.out.println("JFrame01Event 생성자 호출 성공");
        this.jv = jv;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(command);//클릭할 때 마다 감지되어 해당 메서드를 호출함
        if("조회".equals(command)){
            System.out.println("조회버튼이 클릭");
            jv.jlogic.getList();
        }
    }
}
