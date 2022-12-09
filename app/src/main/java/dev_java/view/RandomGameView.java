package dev_java.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomGameView implements ActionListener {
    // 선언부
    JFrame jf = new JFrame();
    // 남쪽에 붙임
    JTextField jtf_input = new JTextField(5);// 생성자 파라미터는 int
    // 중앙에 붙임
    JTextArea jta_display = new JTextArea(10, 20);// 생성자 파라미터는 int2개
    JScrollPane jsp_display = new JScrollPane(jta_display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    // 생성자

    public RandomGameView() {
        System.out.println("디폴트 생성자 호출 성공");
        initDisplay();
    }

    // 화면처리부
    public void initDisplay() {
        System.out.println("initDisplay 호출");
        jtf_input.requestFocus();
        jtf_input.addActionListener(this);
        jta_display.setEditable(false);
        jf.add("South", jtf_input);
        jf.add("Center", jsp_display);
        jf.setSize(300, 400);
        jf.setVisible(true);
    }

    // UI API를 활용하여 공부를 하면
    // 1. 초기화를 활용할 수 있게 됨
    // 2. 생성자 역할에 대해 알게 됨
    // 3. 사용자 정의 메소드를 많이 만들어 볼 수 있음
    // 4. 파라미터와 리턴타입에 대해 확실해짐
    // 5. 전역변수와 지역변수를 구분하여 코딩을 전개하게 됨
    // 6. 클래스를 나누는 조건을 갖게 됨
    // 7. 이벤트 처리를 사전학습 할 수 있음
    // 8. 익명클래스를 활용할 수 있음 - 익명함수, arrow function 등 신 문법을 공부하는데 도움됨
    // 메인메소드
    public static void main(String[] args) {
        new RandomGameView();
        // 선언부 없이 생성자만 호출 할 수 있다. 인스턴스변수를 재사용할 일이 없다면 괜찮아
        // new RandomGameView();//복제본이 생성됨. 그러나 서로 다른 객체임
        // new RandomGameView();//마찬가지 . 타입은 동일 그러나 다른 객체???
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 엔터의 주소번지를 가져온다
        Object obj = e.getSource();
        if (jtf_input == obj) {
            System.out.println("사용자가 입력한 값은 " + jtf_input.getText());
            jta_display.append(jtf_input.getText() + "\n");
            jtf_input.setText("");// 지우기는 더블쿼테이션으로 대체함

        }
    }
}
