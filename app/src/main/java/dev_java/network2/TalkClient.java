package dev_java.network2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class TalkClient extends JFrame implements ActionListener {
	// 선언부
	//////////////// 통신과 관련한 전역변수 추가 시작//////////////
	Socket socket = null;
	ObjectOutputStream oos = null;// 말 하고 싶을 때
	ObjectInputStream ois = null;// 듣기 할 때
	String nickName = null;// 닉네임 등록
	//////////////// 통신과 관련한 전역변수 추가 끝 //////////////
	JPanel jp_second = new JPanel();
	JPanel jp_second_south = new JPanel();
	JButton jbtn_one = new JButton("1:1");
	JButton jbtn_change = new JButton("대화명변경");
	JButton jbtn_font = new JButton("글자색");
	JButton jbtn_exit = new JButton("나가기");
	String cols[] = { "대화명" };
	String data[][] = new String[0][1];
	DefaultTableModel dtm = new DefaultTableModel(data, cols);
	JTable jtb = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jtb);
	JPanel jp_first = new JPanel();
	JPanel jp_first_south = new JPanel();
	JTextField jtf_msg = new JTextField(20);// south속지 center
	JButton jbtn_send = new JButton("전송");// south속지 east
	JTextArea jta_display = new JTextArea(15, 38);
	JScrollPane jsp_display = new JScrollPane(jta_display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	// 생성자

	// 소켓 관련 초기화
	public void init() {
		try {
			// 서버측의 ip주소 작성하기
			// socket = new Socket("192.168.0.244",3000);
			//new ServerSocket(3000)이 받아서 accept()통해서 client소켓에 저장됨.
			socket = new Socket("192.168.10.47", 3000);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			// initDisplay에서 닉네임이 결정된 후 init메소드가 호출되므로
			// 서버에게 내가 입장한 사실을 알린다.(말하기)
			oos.writeObject(100 + Protocol.separator + nickName);
			// 서버에 말을 한 후 들을 준비를 한다.
			TalkClientThread tct = new TalkClientThread(this);
			tct.start();
		} catch (Exception e) {
			// 예외가 발생했을 때 직접적인 원인되는 클래스명 출력하기
			System.out.println(e.toString());
		}
	}

	// 말하기 - 서버에 전달 - List<TalkServerThread> -> 반복문 -> 전송
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

	}

	// 메인
	public static void main(String[] args) {
		TalkClient tc = new TalkClient();
		tc.initDisplay();
		tc.init();
	}

	// 화면그리기
	public void initDisplay() {
		jtf_msg.addActionListener(this);
		// 사용자의 닉네임 받기
		nickName = JOptionPane.showInputDialog("닉네임을 입력하세요.");
		this.setLayout(new GridLayout(1, 2));
		jp_second.setLayout(new BorderLayout());
		jp_second.add("Center", jsp);
		jp_second_south.setLayout(new GridLayout(2, 2));
		jp_second_south.add(jbtn_one);
		jp_second_south.add(jbtn_change);
		jp_second_south.add(jbtn_font);
		jp_second_south.add(jbtn_exit);
		jp_second.add("South", jp_second_south);
		jp_first.setLayout(new BorderLayout());
		jp_first_south.setLayout(new BorderLayout());
		jp_first_south.add("Center", jtf_msg);
		jp_first_south.add("East", jbtn_send);
		jta_display.setLineWrap(true);
		jp_first.add("Center", jsp_display);
		jp_first.add("South", jp_first_south);
		this.add(jp_first);
		this.add(jp_second);
		this.setSize(800, 550);
		this.setVisible(true);
	}
}
