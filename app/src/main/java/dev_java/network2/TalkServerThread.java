package dev_java.network2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class TalkServerThread extends Thread{
	TalkServer ts = null;
	Socket client = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	//현재 서버에 입장한 클라이언트 스레드의 닉네임 저장
	String chatName = null;
	//생성자
	public TalkServerThread(){
	}
	public TalkServerThread(TalkServer ts) {
		this.ts = ts;
		this.client = ts.socket;
		try {
			oos = new ObjectOutputStream(client.getOutputStream());//말하기
			ois = new ObjectInputStream(client.getInputStream());//듣기
			String msg = (String)ois.readObject();
			ts.jta_log.append(msg+"\n");
			StringTokenizer st = new StringTokenizer(msg, "#");
			st.nextToken();//100 skip처리
			chatName = st.nextToken();//토마토 저장
			ts.jta_log.append(chatName+"님이 입장하였습니다.\n");
			for(TalkServerThread tst:ts.globalList){
				this.send(Protocol.TALK_IN+Protocol.separator+tst.chatName);
			}
			//현재 서버에 입장한 클라이언트 스레드 추가하기
			ts.globalList.add(this);
			this.broadCastring(msg);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	//현재 입장해 있는 친구들 모두에게 메시지 전송하기 구현
	public void broadCastring(String msg){
		for(TalkServerThread tst:ts.globalList){
			tst.send(msg);
		}
	}
	//클라이언트에게 말하기 구현
	public void send(String msg){
		try {
			oos.writeObject(msg);
		} catch (Exception e) {
			e.printStackTrace();//stack에 쌓여 있는 에러메시지 이력 출력함
		}
	}

	@Override
	public void run(){

	}	
}
