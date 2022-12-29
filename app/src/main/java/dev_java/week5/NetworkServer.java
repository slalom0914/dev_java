package dev_java.week5;

import java.net.ServerSocket;
import java.net.Socket;

public class NetworkServer {
	public void server() {
		int port = 3000;
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("서버 소켓 생성되었습니다.");
			while(true) {
				Socket client = server.accept();
				System.out.println("client : "+client);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		NetworkServer ns = new NetworkServer();
		ns.server();
	}

}
