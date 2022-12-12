package dev_java.week3;


// 메모리 StackOverFlow발생 - 서버가 중지됨
public class JTextAreaUILogic {
	// 여기서 직접 인스턴스화 하면 복제본이 만들어짐 - 망함 - 복제본에 출력되니까
	// JTextArea jta = new JTextArea(10,20);
	JTextAreaUI jtaUI = null;

	public JTextAreaUILogic(JTextAreaUI jTextAreaUI) {
		// 생성자 안에서 JTextAreaUI의 JTextArea원본과 전변을 초기화해주어야 함 - 이걸 못해
		this.jtaUI = jTextAreaUI;
	}

	public void account(String input) {
		System.out.println("account호출 성공");
		// JTextAreaUI클래스에 정의된 주소번지를 사용하고 싶다. 어떡하지?
		// insert here
		jtaUI.jta.append("UILogic : " + input + "\n");
	}

}
