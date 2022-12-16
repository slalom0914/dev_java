package dev_java.tables;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Button2 extends JFrame {
	// 선언부
	String jbtn_label[] = { "입력", "수정", "삭제" };// 버튼에 들어갈 라벨 선언 및 초기화
	JPanel jp_north = new JPanel();// 입력,수정,삭제버튼을 붙일 속지 선언 및 생성
	JButton jbtn_ins = new JButton(jbtn_label[0]);// 입력 버튼 생성
	JButton jbtn_upd = new JButton(jbtn_label[1]);// 수정 버튼 생성
	JButton jbtn_del = new JButton(jbtn_label[2]);// 삭제 버튼 생성
	Vector<JButton> vbtns = new Vector<>(jbtn_label.length);
	JButton[] jbtns = {jbtn_ins, jbtn_upd, jbtn_del};
	// 생성자
	public Button2() {
		initDisplay();
	}

	// 화면그리기
	public void initDisplay() {
		
		for (int i = 0; i < jbtns.length; i++) {
			//insert here - 벡터 초기화하기
			vbtns.add(jbtns[i]);
			jp_north.add(vbtns.get(i));
			//System.out.println(jbtns[i]);
			//jp_north.add(jbtns[i]);
		}
		this.add("North", jp_north);
		this.setSize(500, 400);
		this.setVisible(true);
	}

	// 메인메소드
	public static void main(String[] args) {
		new Button2();
	}
}
