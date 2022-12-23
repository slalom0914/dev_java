package dev_java.network2;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//선언과 생성을 분리하는 코딩 전개
//자바는 단일상속만 가능함
//자바는 단일상속의 단점을 보완하기 위해 인터페이스는 다중으로 처리가능함(구현체클래스)
public class TalkServer extends JFrame implements Runnable, ActionListener {
	// 선언부
	//클라이언트측에서 new Socket하면 그 소켓정보를 받아서 쓰레드로 넘김
	TalkServerThread tst = null;
	//동시에 여러명이 접속하니까 List - Vector<>(); 멀티스레드 안전, 속도  느림
	List<TalkServerThread> globalList = null;
	ServerSocket server = null;
	Socket socket = null;
	JTextArea jta_log = new JTextArea(10, 30);
	JScrollPane jsp_log = new JScrollPane(jta_log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JButton jbtn_log = new JButton("로그저장");

	// 생성자
	public TalkServer() {
		//initDisplay();//시점문제- 스케쥴링
	}

	// 화면그리기
	public void initDisplay() {
		jbtn_log.addActionListener(this);
		this.add("North", jbtn_log);
		this.add("Center", jsp_log);
		this.setSize(500, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		TalkServer ts = new TalkServer();
		ts.initDisplay();
		Thread th = new Thread(ts);
		th.start();//52번 호출됨 - 지연발생함 - 클라이언트가 접속할때까지 기다림...
	}

	// 서버소켓과 클라이언트 소켓을 연결
	@Override
	public void run() {
		//서버에 접속해온 클라이언트 스레드 정보를 관리할 벡터 생성하기 
		globalList = new Vector<>();//멀티스레드안전해서 ArrayList대신 사용함
		boolean isStop = false;
		try {
			server = new ServerSocket(3000);//서버포트번호 설정하기
			jta_log.append("Server Ready.........\n");//대기 탐 - 멈춤 - wait
			while(!isStop) {
				socket = server.accept();
				jta_log.append("client info:"+socket+"\n");				
				jta_log.append("client info:"+socket.getInetAddress()+"\n");			
				TalkServerThread tst = new TalkServerThread(this);
				tst.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//////////////////////// [[ end of run ]] /////////////////////////

	@Override
	public void actionPerformed(ActionEvent e) {
		//로그를 파일로 저장하기
		
	}
}
