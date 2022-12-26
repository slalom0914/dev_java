package dev_java.network3;

import java.util.StringTokenizer;
import java.util.Vector;​

public class TalkClientThread extends Thread {
	TalkClient tc = null;

	public TalkClientThread(TalkClient tc) {
		this.tc = tc;
	}

	// 서버측에서 클라이언트가 접속하면 접속자의 정보를 List<TalkServerThread> add(스레드생성자)했고
	// 메시지를 청취하자 마자 클라이언트측에 반복문을 돌려서 쓰기 한다.(전송함) - broadCastring(String msg)
	@Override
	public void run() {
		boolean isStop = false;
		// run_stop:
		while (!isStop) {
			try {
				// 100#tomato 님 입장하였습니다.
				String msg = "";
				msg = (String) tc.ois.readObject();
				System.out.println("서버에서 전송된 msg : " + msg);
				StringTokenizer st = null;
				int protocol = 0;// 100 200 300 400 500
				if (msg != null) {
					st = new StringTokenizer(msg, "#");
					protocol = Integer.parseInt(st.nextToken());
				}
				System.out.println("protocol : " + protocol);
				switch (protocol) {
					case Protocol.TALK_IN: {
						String nickName = st.nextToken();
						tc.jta_display.append(nickName + "님이 입장하였습니다.\n");
						// JTable은 양식일뿐이고 데이터셋은 DefaultTableModel이니까 거기에
						// 닉네임을 출력함
						Vector<String> v = new Vector<>();
						v.add(nickName);
						// 데이터셋객체에 한 개로우 추가하기
						tc.dtm.addRow(v);
					}
						break;
					case Protocol.MESSAGE: {
						String nickName = st.nextToken();
						String message = st.nextToken();
						tc.jta_display.append("[" + nickName + "]" + message + "\n");
						tc.jta_display.setCaretPosition(tc.jta_display.getDocument().getLength());
					}
						break;
					case Protocol.WHISPER: {
						String nickName = st.nextToken();
						String otherName = st.nextToken();
						String message = st.nextToken();
						tc.jta_display.append(nickName + "님이 " + otherName + "님에게 " + message + "\n");
						tc.jta_display.setCaretPosition(tc.jta_display.getDocument().getLength());
					}
						break;
					case Protocol.CHANGE: {
						String nickName = st.nextToken();
						String afterName = st.nextToken();
						String message = st.nextToken();
						// 테이블에 대화명 변경하기
						for (int i = 0; i < tc.dtm.getRowCount(); i++) {
							String imsi = (String) tc.dtm.getValueAt(i, 0);
							if (nickName.equals(imsi)) {
								tc.dtm.setValueAt(afterName, i, 0);
								break;
							}
						}
						// 채팅창에 타이틀바에도 대화명을 변경처리 한다.
						if (nickName.equals(tc.nickName)) {
							tc.setTitle(afterName + "님의 대화창");
							tc.nickName = afterName;
						}
						tc.jta_display.append(message + "\n");
					}
						break;
					case Protocol.TALK_OUT: {
						String nickName = st.nextToken();
						tc.jta_display.append(nickName + "님이 퇴장 하였습니다.\n");
						tc.jta_display.setCaretPosition(tc.jta_display.getDocument().getLength());
						for (int i = 0; i < tc.dtm.getRowCount(); i++) {
							String n = (String) tc.dtm.getValueAt(i, 0);
							if (n.equals(nickName)) {
								tc.dtm.removeRow(i);
							}
						}
					}
						break;
					default:
						System.out.println("해당하는 프로토콜이 존재하지 않습니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
