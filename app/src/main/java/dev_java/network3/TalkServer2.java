package dev_java.network3;

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
//상속을 받거나 implements하면 부모클래스나 인터페이스가 정의하고 있는 메소드를 
//재정의 할 수 있다(Overriding-선언부는 완전 일치해야함)
//인터페이스는 오로지 추상메소드만 갖는다 - Runnable도 인터페이스 이니까 추상메소드 있다.
//그게  run메소드 이다.
//class TalkServer extends JFrame, Thread{}
//POJO F/W설계-인터페이스중심코딩전개수업 -  Spring boot(전자정부프레임웤)기반 MVC패턴수업진행
//자바스크립트수업(ES5,6,7소개) - NodeJS
//리액트수업(객체,클래스수업,리액트훅,메소드,파라미터,리턴타입)
public class TalkServer2 extends JFrame implements /* Runnable */ ActionListener {
	// 선언부
	// 클라이언트측에서 new Socket하면 그 소켓정보를 받아서 쓰레드로 넘김
	TalkServerThread2 tst = null;
	// 동시에 여러명이 접속하니까 List - Vector<>(); 멀티스레드 안전, 속도 느림
	List<TalkServerThread2> globalList = null;
	ServerSocket server = null;
	Socket socket = null;
	JTextArea jta_log = new JTextArea(10, 30);
	JScrollPane jsp_log = new JScrollPane(jta_log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JButton jbtn_log = new JButton("로그저장");

	// 생성자 - 클래스이름이 다르면 생성자 이름도 변경해줌
	public TalkServer2() {
		// initDisplay();//시점문제- 스케쥴링
	}

	// 화면그리기
	public void initDisplay() {
		jbtn_log.addActionListener(this);
		this.add("North", jbtn_log);
		this.add("Center", jsp_log);
		this.setSize(500, 400);
		this.setVisible(true);
	}

	// 스레드가 두 개이므로 화면요청과 start() 순서를 바꾸더라도 각자 처리가 됨
	public static void main(String[] args) {// 메인스레드라고도 함- entry point
		TalkServer2 ts = new TalkServer2();
		ts.initDisplay();// 메인스레드
		ts.init();// 나는 서버, 대기탐, 누구를 기다림(사용자,클라이언트,고객,업무담당자)
		// 내안에 run메소드가 재정의(오버라이드) 되어 있으니까
		// 아래 코드가 에러발생하는 것은 Runnable를 implements에서 제거하였기 때문임
	}

	// 서버소켓과 클라이언트 소켓을 연결
	public void init() {
		// 서버에 접속해온 클라이언트 스레드 정보를 관리할 벡터 생성하기
		// 벡터는 멀티스레드 안전 - 서버에 동시 접속자 수가 여러명이니까
		// 그래서 벡터 안에는 클라이언트를 관리하는 스레드 추가해야 함
		// 그 스레드는 메세지를 듣고 (청취하고) 들은 내용을 그대로 클라이언트측에 내보냄
		// 200#토마토#오늘스터디할까? StringTokenizer st = new StringTokenizer("","#");
		// st.nextToken():String - 200
		// st.nextToken():String - 토마토 - 닉네임
		// st.nextToken():String - 오늘스터디할까? - 메세지
		globalList = new Vector<>();// 멀티스레드안전해서 ArrayList대신 사용함
		boolean isStop = false;
		// try ..catch블록은 네트워크는 항상 장애가 발생할 수 있다 - 예외처리를 함
		// try..catch사이에는 예외가 발생할 가능성이 있는 코드를 넣는다
		// 콜백함수란? 시스템에서 필요할 때 대신 호출해주는 메소드
		// 언제 호출되나요? 스레드인스턴스변수.start();요청하면
		// 왜 이렇게 처리하나요? - 여러스레드가 존재하고 경합이 벌어지므로 우선순위를 따져가며 호출함
		// 어떻게 호출하나요?
		// 왜 반드시 run메소드를 재정의해야 할까요?
		try {
			server = new ServerSocket(3000);// 서버포트번호 설정하기
			jta_log.append("Server Ready.........\n");// 대기 탐 - 멈춤 - wait
			while (!isStop) {// 언제 while문안으로 진입하지? ->new Socket(ip서버의,port);
				socket = server.accept();
				jta_log.append("client info:" + socket + "\n");
				jta_log.append("client info:" + socket.getInetAddress() + "\n");
				// String - VARCHAR2, CHAR, int- number(5):9999 double - number(7,2) 99999.99
				// 이종간의 언어에서 데이터를 공유( static) 목적으로 설계하는 디자인 패턴이름 - DTO
				// DeptVO - this사용 - 전변 초기화 - ValueObject패턴일부 - 오라클과 자바연동 필요함 설계됨
				// 이벤트처리시 이벤트처리를 담당하는 클래스를 가리키는 목적으로 this를 사용함
				// ActionListener구현할 때 - 버튼.addActionListener(this)
				// new XXX(this) - 클래스 분리, 나눌때, MVC패턴으로 구현할 때
				// 생성자 호출시 파라미터로 들어오는 this는 현재(now, 살아있는) 인스턴스화된 객체를 가리킴
				// 여기서 this는 TalkServer임
				// 아래는 객체를 생성하는 것과 동시에 생성자를 호출하는데 클래스이름을 바꾸었다 그러니까 에러발생
				// 해결방법은 TalkServerThread의 생성자 파라미터 타입을 TalkServer2로 변경하면 됨
				TalkServerThread2 tst = new TalkServerThread2(this);// TalkServer2
				// TalkServer가 화면을 만들때 JFrame을 상속받았다.
				// TalkServerThread tst = new TalkServerThread(super);//super는 JFrame임
				tst.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//////////////////////// [[ end of run ]] /////////////////////////

	@Override
	public void actionPerformed(ActionEvent e) {
		// 로그를 파일로 저장하기

	}
}

/*
 * 채팅서버 구축하기
 * 클라이언트측에서 접속하면 접속해온 정보를 서버측 화면에서 볼 수 있다.(JFrame을 상속했음-로그남김)
 * 자바는 단일 상속만 가능함. - 이러한 약점을 인터페이스로 지원함 - 그래서 다중인터페이스 구현체는 가능함
 * 스레드 구현방법
 * 1)Thread상속 하기
 * 2)Runnable 인터페이스를 implements하기
 * 현재 TalkServer는 JFrame을 상속받고 있어서 Runnable을 implements하였음.
 * 
 * 
 */