package dev_java.week5;

import javax.swing.JFrame;

import dev_java.ch01.JFrameTest;

public class JFameTest extends JFrame {
	JFameTest() {
		//super("제목");
		this("제목2");
		this.setSize(400, 300);
		this.setVisible(true);
	}

	JFameTest(String title){
		this.setTitle(title);
	}

	public static void main(String[] args) {
		new JFameTest();
	}
}
