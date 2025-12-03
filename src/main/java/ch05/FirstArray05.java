package ch05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//내 안에 actionPerformed메서드가 들어왔다.
//내(FirstArray05)가 ActionListener인터페이스에 구현체 클래스가 되었다.
//인터페이스는 단독으로 인스턴스화 할 수 없다.왜냐면 구현체 클래스가 있어야 하니까
//인터페이스 안에 있는 메서드는 추상 메서드 이다.- 기능에 대해 결정할 수가 없다.
//왜 결정할 수  없지? 어느 device에 들어갈지 모른다. 인터페이스에 정의된 메서드는
//그 장치에서 그 기능이 필요하다는 가이드 이다.- 메서드 오버라이딩 이라함.
//원형은 훼손하지 않고서 기능만 구현해줘 -> 리턴타입, 파라미터 갯수, 타입 포함
public class FirstArray05 implements ActionListener {
    public static void main(String[] args) {
        FirstArray05 fa = new FirstArray05();
        JFrame  jf              = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new GridLayout(3,2));
        JButton btns[]          = new JButton[6];
        String  btns_label[]    = new String[]
                {"1:1대화","대화명변경","나가기","글자색변경","이모티콘","방만들기"};
        for(int i=0;i<btns.length;i++){//6번을 반복합니다. 0,1,2,3,4,5
            btns[i] = new JButton(btns_label[i]);
            jf.add(btns[i]);
            btns[i].addActionListener(fa);
        }
        jf.setSize(600,700);
        jf.setVisible(true);
    }
    //부모 가진 메서드 원형을 재정의한다. - 메서드 오버라이드
    //아래 메서드는 개발자가 직접 호출할 수 없다. - main- 콜백(Callback)
    @Override
    public void actionPerformed(ActionEvent e) {
        //6개 버튼중에서 누가 눌렸지? - 구분(if문-event)
        Object obj = e.getSource();
        String buttonLabel = e.getActionCommand();
        System.out.println(buttonLabel+", "+obj);
        if("글자색변경". equals(buttonLabel)){
        //if("글자색변경"==buttonLabel){
            System.out.println("글자색변경을 눌렀니");
        }
    }
}
