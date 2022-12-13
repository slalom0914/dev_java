package dev_java.week3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaUI2Event implements ActionListener {
	JTextAreaUI2 jUi2 = null;

	public JTextAreaUI2Event(JTextAreaUI2 jUi2) {
		this.jUi2 = jUi2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (jUi2.jtf == obj) {// JTextField에 엔터친거야?
			// JTextField에 입력한 문자열 받기
			String input = jUi2.jtf.getText();
			jUi2.getTextArea().append("JTextAreaUI원본 : " + input + "\n");
			//jUi2.jtaUILogic.account(input);
			jUi2.jtf.setText("");
		}
	}
}
