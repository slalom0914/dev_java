package dev_java.week5;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkServer2 {
	public void server() {
		int port = 3000;
		ServerSocket server = null;
		ObjectOutputStream oos = null;//말하기
		ObjectInputStream ois = null;//듣기
		//들은걸 말하기
		try {
			server = new ServerSocket(port);
			System.out.println("서버 소켓 생성되었습니다.");
			while (true) {
				Socket client = server.accept();
				System.out.println("client : " + client);
				oos = new ObjectOutputStream(client.getOutputStream());
				ois = new ObjectInputStream(client.getInputStream());
				//듣기 코드
				String msg = (String) ois.readObject();//스피커(h/w)
				System.out.println("msg : " + msg);
				oos.writeObject(msg);//말하기 코드(마이크)- 소켓 -  oos
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		NetworkServer2 ns = new NetworkServer2();
		ns.server();
	}

}
