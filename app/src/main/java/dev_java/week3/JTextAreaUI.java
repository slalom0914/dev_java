package dev_java.week3;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaUI implements ActionListener {
	// 선언부
	JTextAreaUILogic jtaUILogic = new JTextAreaUILogic(this);
	// 인터페이스는 반드시 구현체 클래스가 있어야 한다.
	// 단독으로 인스턴스화 불가함
	// 선언부와 생성부의 타입이 다르다 - 그래서 다형성이 가능함 - 폴리모피즘 - 재사용을 높이고 결합도는 낮춤
	// ActionListener al = new JTextAreaUI();
	JFrame jf = new JFrame();
	JTextArea jta = new JTextArea(10, 20);
	JTextField jtf = new JTextField(10);

	public JTextAreaUI() {
		initDisplay();
	}

	public void initDisplay() {
		// 이벤트소스와 이벤트 핸들러 클래스 매핑하기(매칭)
		jtf.addActionListener(this);
		// 멀티라인 작성 가능한 콤포넌트 배경색 설정
		jta.setBackground(Color.cyan);
		// JFrame은 디폴트 레이아웃이 BorderLayout이라서 동,서,남,북,중앙 배치 가능
		jf.add("Center", jta);// JTextArea는 중앙에 배치함
		jf.add("South", jtf);// 남쪽에는 JTextField배치함
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 윈도창 x버튼 클릭시 자원회수함
		jf.setSize(400, 300);// 윈도창 가로 세로 크기 설정
		jf.setVisible(true);// 화면을 출력함
	}

	public static void main(String[] args) {// 가장 먼저 호출됨 - entry point임
		new JTextAreaUI();// 생성자 호출되고 그 안에 화면 그리는 메소드 호출됨
		// new JTextAreaUI();// 생성자 호출되고 그 안에 화면 그리는 메소드 호출됨
	}

	// annotation- 문법제약을 갖음 - 선언부가 일치해야 함
	@Override
	public void actionPerformed(ActionEvent e) {
		// 추상메소드의 파라미터를 통해서 감지된 컴포넌트의 주소번지를 얻어오는
		// getSource메소드의 소유주 임
		Object obj = e.getSource();
		if (jtf == obj) {// JTextField에 엔터친거야?
			// JTextField에 입력한 문자열 받기
			String input = jtf.getText();
			jta.append("JTextAreaUI원본 : " + input + "\n");
			jtaUILogic.account(input);
			jtf.setText("");
		}
	}
}
