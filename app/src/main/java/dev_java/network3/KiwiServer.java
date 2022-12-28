package dev_java.network3;

import javax.swing.JFrame;

public class KiwiServer extends JFrame implements Runnable {
	// 선언부

	// 생성자
	public KiwiServer() {
		System.out.println("KiwiServer디폴트 생성자 호출");
	}

	public void initDisplay() {
		this.setTitle("키위톡");
		this.setSize(400, 300);
		this.setVisible(true);
	}

	// 메인메소드
	public static void main(String[] args) {
		KiwiServer ks = new KiwiServer();
		ks.initDisplay();
		Thread th = new Thread(ks);
		th.start();
	}

	@Override
	public void run() {
		System.out.println("run 호출 성공");
		// 경합이 벌어지는 일
		// 지연(대기)이 필요한 일
		// 일반메소드로 처리할 때와 다른 점
		// 보장받는다. 늦게라도 실행됨. -일반메소드는 어플리케이션이 종료되면 보장못함
		// 개별적으로 동작을 할 수 있다.

	}
}
