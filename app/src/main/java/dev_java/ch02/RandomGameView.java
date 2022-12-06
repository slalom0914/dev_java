package dev_java.ch02;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class RandomGameView {
  // 선언부
  JFrame jf_game = new JFrame();
  JPanel jp_east = new JPanel();
  JButton jbtn_new = new JButton("새게임");
  JButton jbtn_dap = new JButton("정답");
  JButton jbtn_clear = new JButton("지우기");
  JButton jbtn_exit = new JButton("종료");

  // 생성자 - 파라미터가 없는 생성자를 디폴트 생성자라 함 - 생략 가능함
  public RandomGameView() {//그러나 화면을 그리는 메소드 호출하기 위해서 굳이 선언하였음
    initDisplay();//내 안에 있는 메소드이므로 인스턴스화 없이도 가능함
  }

  // 화면그리기 구현
  public void initDisplay() {
    //동쪽에 붙일 속지의 레이아웃을 설정함.
    //메소드의 파라미터로 객체를 생성함 - 왜냐하면 딱 한번만 호출하니까...
    GridLayout layout = new GridLayout(4,1);
    jp_east.setLayout(layout);//메소드 호출시 파라미터로 객체생성구문 가능함
    jp_east.add(jbtn_new);
    jp_east.add(jbtn_dap);
    jp_east.add(jbtn_clear);
    jp_east.add(jbtn_exit);
    jf_game.add("East", jp_east);
    jf_game.setSize(450, 400);
    jf_game.setVisible(true);
  }

  // 메인 메소드
  public static void main(String[] args) {
    //생성자 호출하기 - 디폴트 생성자가 호출됨
    new RandomGameView();
  }
}
