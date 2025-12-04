package ch05.aobject2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrame01 implements ActionListener {
    //선언부 - 전변선언하기
    JFrame jf = new JFrame();
    JButton btn = new JButton("조회");
    //디폴트 생성자 - 생략할 수 있다.
    public JFrame01(){
        System.out.println("디폴트 생성자 호출");
        this.initDisplay();
    }
    //화면그리기
    public void initDisplay(){
        System.out.println("initDisplay호출");
        //아래 코드에서 this는 현재 메모리에 로딩된 JFrame01
        //이벤트가 감지된 버튼과 버튼이 클릭되었을 때 처리를 담당할 클래스 연결 필요함
        //만일 아래 코드를 누락하면 이벤트 감지가 일어나지 않음.
        //이벤트 처리를 담당하는 이벤트 핸들러 클래스 연결
        //이벤트 핸들러 클래스란 actionPerformed라는 추상메서드를 구현한 클래스를 말함.
        btn.addActionListener(this);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add("North", btn);
        jf.setSize(500,400);
        jf.setVisible(true);
    }
    //main메서드
    public static void main(String[] args) {
        JFrame01 jFrame01 = new JFrame01();
    }
    //이벤트 처리 메서드(콜백메서드-시스템이 호출해줌,즉 내가 호출못함)
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(command);//클릭할 때 마다 감지되어 해당 메서드를 호출함
        if("조회".equals(command)){
            System.out.println("조회버튼이 클릭");
            getList();
        }
    }
    //오라클 서버에서 select한 결과를 받아오는 메서드
    public Object getList(){
        System.out.println("오라클 연동하여 목록 가져오기 처리");
        return null;
    }
}
