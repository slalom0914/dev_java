package dev_java.quiz1213;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//기본 패키지인 java.lang이외에는 모두 import필요함 
//인터페이스를 implements하면 반드시 추상메소드를 재정의해야 함 - Overriding이라고 함
public class Sub1 implements ActionListener {
	// 선언부 - 전역변수의 위치
	// 선언에서 결정되는 건 무엇입니까? - 타입만 결정됨
	// 원시형은 필드와 메소드를 가질 수 없다.
	// 원시형은 부르면 값이 나온다.
	// 참조형은 부르면 주소번지가 나온다.
	// 원시형에서는 NullPointerException
	// sub1.insert();
	JDialog jdg = new JDialog();
	JButton jbtn = new JButton("저장");
	Main1 main1 = null;// 선언만 했음 -null의미는 결정되지 않았다. 원본을 사용하겠다는 뜻
	// Main1 main1 = new Main1();//선언도 했고 생성도 했고 생성자도 호출한다- 복제본이 만들어짐
	// public Sub1(){}

	public Sub1(Main1 main1) {// Main1 main1 = null 의미됨
		System.out.println(main1);
		if (main1 == null)
			System.out.println("main1은 null입니다.객체생성안된 상태임");
		// 나는 언제 호출되나요? - 메인앱이 실행될때
		// 나는 어디서 호출되나요? - Main1클래스에서
		// 나는 왜 호출하는거죠? - 입력눌렀을 때, 주문을 할때, 회원가입을 할때
		this.main1 = main1;// 객체 치환
		initDisPlay();
	}

	public void initDisPlay() {
		jbtn.addActionListener(this);
		jdg.add("South", jbtn);
		jdg.setTitle("Sub1");
		jdg.setSize(300, 400);
		jdg.setVisible(true);
	}

	int insert() {// 1:입력 성공, 0:입력실패
		// insert메소드에서 main1 접근이 불가함
		return 1;
	}

	/*
	 * public static void main(String[] args) {
	 * // new Sub1();
	 * new Sub1(null);
	 * }
	 */
	/*******************************************************************
	 * 콜백메소드라고 부른다
	 * 저장버튼이 클릭되었을 때 JVM 이를 감지하고 인터셉트 하여 메소드 호출을 해줌
	 * 파라미터인 ActionEvent객체를 통해서 이벤트가 감지된 버튼을 구분할 수 있음.
	 * 이 객체는 파라미터에 있으므로 JVM으로 부터 주입이 되는 객체 이다.
	 * 다시말해 개발자가 인스턴스화 하지 않고 JVM이 대신 해줌
	 *******************************************************************/
	@Override
	public void actionPerformed(ActionEvent e) {
		// 너 저장버튼 누른거야
		Object obj = e.getSource();
		// 반복문을 탈출할 때는 break문을 사용하고
		// 조건문을 탈출할 때는 return을 사용함
		if (obj == jbtn) {
			int result = insert();
			if (result == 1) {
				JOptionPane.showMessageDialog(jdg, "입력 성공하였습니다.");
				main1.refresh();
				jdg.dispose();
			} else if (result == 0) {
				JOptionPane.showMessageDialog(jdg, "입력 실패하였습니다.");
				return;// actionPerformed를 탈출함
			}
		}
	}
}
