package dev_java.grade1230;

import java.net.ServerSocket;
import java.net.Socket;

//단일 상속만 되니까 인터페이스 지원함
//인터페이스를 통해 스레드 구현방법
public class ChatServer implements Runnable {
	// 메인 스레드이다.
	public static void main(String[] args) {
		System.out.println("main 시작");
		ChatServer cs = new ChatServer();
		Thread th = new Thread(cs);
		th.start();
		System.out.println("main 끝");
	}

	@Override
	public void run() {
		System.out.println("run 호출 성공");
		int port = 3000;
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			// 대기상태 ~~~ 시간이 가다가 ChatClient에서 new Socket("서버IP",3000);
			System.out.println("서버소켓 생성 완료 - 클라이언트 소켓 접속 기다리는 중...");
			while (true) {
				// 아래 코드가 진행되는 시점은 언제지? - new Socket("192.168.10.47",3000);
				Socket client = server.accept();
				System.out.println("클라이언트측 : " + client.getInetAddress());// 접속한 클라이언트 정보 출력
				// 대기상태 풀림
				// 금융권주로 사용 - 보안강화 - 직렬화기법 - 마샬링, 언마샬링 구간
				// 말하기 - ObjectOutputStream - > writeObject();네트워크 전송일어남 - 패킷
				// 듣기 - ObjectInputStream -> readObject();듣기
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
