package dev_java.network1;

import java.io.IOException;
import java.io.ObjectInputStream;//듣기
import java.io.ObjectOutputStream;//말하기
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

//서버를 기동하고 클라이언트가 접속해 오기를 기다린다. -  기다리면 스레드
public class TimeServer extends Thread {
	// 선언부
	// 객체 직렬화가 가능하고 듣기와 쓰기가 가능한 I/O관련 클래스 선언
	ObjectOutputStream oos = null;// 소켓이 있어야만 객체생성가능함 - 말하기
	ObjectInputStream ois = null;// 소켓이 있어야만 객체생성가능함 - 듣기
	Socket client = null;// 전변위치
	// run메소드 재정의 - 스레드에서 해야 할 일을 처리함
	// 반드시 선언부 일치해야함 - 부모가 가진 메소드와
	// TimeServer is a Thread 관계가 성립하니까 상속처리가능함
	// 생성자

	TimeServer() {
	}

	// 아래 생성자가 필요한 이유는 서버소켓에 접속해온 클라이언소켓을
	// run메소드에서 사용해야 하니까 전변으로 치환해야함.
	TimeServer(Socket client) {
		this.client = client;
	}

	// 스레드 구현 메소드에서 서버소켓에 접속해온 client소켓을 가지고
	// 말하기와 듣기에 필요한 oos와 ois객체를 생성함
	// I/O도 지연과 데드락 상태에 빠질 수 있으므로 반드시 예외처리할것.
	@Override
	public void run() {
		try {
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			while (true) {
				oos.writeObject(getTimeMessage());// 12:05:45
				try {
					sleep(1000);
				} catch (InterruptedException ie) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}// end of run

	// 메인메소드
	public static void main(String[] args) {
		// 서버소켓 생성시 파라미터로 포트번호 필요함
		int port = 3001;
		// 동시에 여러사람이 접속을 시도함
		ServerSocket server = null;
		Socket client = null;// 여기에 들어오는 소켓은 서버소켓에 접속해온 클라이언트 소켓(주소번지)임
		try {
			server = new ServerSocket(port);
		} catch (IOException ie) {
			System.out.println("Cant't bind port: " + port);
			ie.printStackTrace();// 에러메시지를 라인번호와 함께 출력- 힌트문-디버깅
			try {
				server.close();
			} catch (Exception e) {
				System.exit(0);// 서버 강제 종료시킴
			}
		} //////////// end of try..catch
		System.out.println("TimeServer started successfully.....");
		while (true) {
			try {
				// 클라이언트가 접속해 오기를 기다리다가 접속(new Socket("192.168.10.47",3000))을 해오면
				// 아래 메소드가 클라이언트 소켓 정보를 취득함
				client = server.accept();
				System.out.println(client.getInetAddress());// 클라이언트의 네트웤 정보
				System.out.println("New Client connected...");
				// 스레드 개입이 필요함 - 1초 동안 sleep(1000)호출하고 현재시분초 정보를 출력함
				// 스레드 동작시킴 - 스레드의 추상메소드 run을 호출해야 함
				// 주의 : run을 직접 호출하는게 아니라 start() 호출하면 JVM이 순서를 따져서 출발시킴-콜백
				TimeServer ts = new TimeServer(client);// 왜냐면 run에서 사용하고 싶으니까...
				ts.start();// run()호출됨
				System.out.println("New TimeServer Thread started....");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public String getTimeMessage() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		return (hour < 10 ? "0"+hour :""+hour)+":"+
		(min < 10 ? "0"+min:""+min)+":"+
		(sec < 10 ? "0"+sec:""+sec);
		//return "12:05:45";
	}
}
