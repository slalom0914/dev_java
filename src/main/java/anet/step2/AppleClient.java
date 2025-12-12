package anet.step2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static util.CustomLogger.logger;

//디폴트 생성자는 생략이 가능한데 왜냐면 JVM이 대신 해줄 수 있다.
//단 파라미터가 있는 생성자 경우 예측할 수  없다.
//파라미터가 있는 생성자의 경우 개발자가 결정해준다.
public class AppleClient extends JFrame implements ActionListener {

    Socket socket = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    //JFrame의 레이아웃을 GridLayout(1,2)로 바꿔봐요.
    JPanel 		jp_first 		= new JPanel();
    JPanel 		jp_first_south 	= new JPanel();
    JTextArea 	jta_display 	= new JTextArea(15,38);
    JScrollPane jsp_display 	= new JScrollPane(jta_display
            ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
            , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JTextField 	jtf_msg 		= new JTextField(20);
    JButton 	jbtn_send 		= new JButton("전송");
    JPanel 		jp_second 		= new JPanel();
    JPanel 		jp_second_south = new JPanel();
    String      cols[] = {"대화명"};
    String      data[][] = new String[0][1];
    DefaultTableModel dtm = new DefaultTableModel(data,cols);
    JTable jtb = new JTable(dtm);
    JScrollPane jsp 	= new JScrollPane(jtb
            ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
            , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JButton jbtn_one 		= new JButton("1:1대화");
    JButton jbtn_change 	= new JButton("대화명변경");
    JButton jbtn_color 	    = new JButton("글자색");
    JButton jbtn_logout 	= new JButton("로그아웃");
    JButton jbtn_emoticon 	= new JButton("이모티콘");
    JButton jbtn_exit 		= new JButton("종료");

    String nickName = null;
    public AppleClient(String nickName) {
        this.nickName = nickName;
        initDisplay();
        init();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        String msg = jtf_msg.getText();
        if(obj == jbtn_one){
            int row = jtb.getSelectedRow();
            //상대를 선택하지 않았을 때
            if(row == -1){
                JOptionPane.showMessageDialog(this
                        ,"상대를 선택하세요","info"
                        ,JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            //상대를 선택했을 때
            else{
                String name = dtm.getValueAt(row, 0).toString();
                //메세지를 입력하세요
                String msg1 = JOptionPane.showInputDialog("메시지를 입력하세요");
                try {
                    oos.writeObject(Protocol.WHISPER+"#"+nickName+"#"+name+"#"+msg1);
                }catch(Exception ex) {
                    System.out.println(ex.getMessage());
                }//end of try..catch
                //상대를 선택하고 메시지를 전송한 다음에 선택한 로우 초기화 하기
                jtb.clearSelection();
                //ObjectOutputStream, ObjectInputStream, 직렬화지원, 보안
            }//end of else
        }
        //전송 버튼을 눌렀을 때 와 메시지 입력 후 엔터 쳤을 때
        else if(obj == jtf_msg || obj == jbtn_send){
            if(msg == null || msg.length() == 0){
                JOptionPane.showMessageDialog(this,"메시지를 입력하세요");
                return;//actionPerformed탈출함.
            }
            try {
                oos.writeObject(200+"#"+nickName+"#"+msg);
                jtf_msg.setText("");
            }catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
        }//end of 엔터쳤을 때와 전송버튼 클릭했을 때
        else if(obj == jbtn_exit){
            try{
                oos.writeObject(500+"#"+nickName);
                System.exit(0);//JVM와 연결을 끊음- 스레드 회수, 어플리케이션 종료
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }//end of 나가기
    }
    //아래 메서드가 화면 그리기 보다 먼저 호출되면 화면은 못 볼 수  있다.
    public void init(){
        logger("init()");
        try{
            //예외가 발생할 가능성이 있는 코드
            //소켓 객체 인스턴스화 하기(서버에 accept당함)
            socket = new Socket("127.0.0.1",5000);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            //서버에게 내가 입장한 사실을 알림
            oos.writeObject(100+"#"+nickName);
            ///서버에서 한 말을 듣기 위한 준비
            AppleClientThread bct = new AppleClientThread(this);
            bct.start();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void main(String[] args) {
        //AppleClient appleClient = new AppleClient("apple");
    }
    public void initDisplay(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        //어플리케이션 닫을 때 프로세서 종료처리
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jtf_msg.addActionListener(this);
        jbtn_send.addActionListener(this);
        jbtn_exit.addActionListener(this);
        jbtn_one.addActionListener(this);
        jbtn_change.addActionListener(this);
        jbtn_one.setBackground(new Color(158,9,9));
        jbtn_one.setForeground(new Color(212,212,212));
        jbtn_change.setBackground(new Color(7,84,170));
        jbtn_change.setForeground(new Color(212,212,212));
        jbtn_color.setBackground(new Color(19, 99, 57));
        jbtn_color.setForeground(new Color(212, 212, 212));
        jbtn_emoticon.setBackground(new Color(121, 85, 72));   // 모던 초콜릿 브라운
        jbtn_emoticon.setForeground(new Color(255, 248, 240)); // 크림 화이트
        jbtn_logout.setBackground(new Color(255, 255, 200));
        jbtn_logout.setForeground(new Color(57, 57, 57));
        jbtn_exit.setBackground(new Color(54, 54, 54));
        jbtn_exit.setForeground(new Color(212, 212, 212));

        //사용자로 부터 닉네임 입력 받기
        //nickName = JOptionPane.showInputDialog("닉네임을 입력하세요.");
        this.setLayout(new GridLayout(1,2,2,2));
        //JFrame에 들어갈 첫번째 속지는 동서남북 중앙으로 배치할 수 있어야 해요.
        jp_first.setBackground(Color.orange);
        jp_first.setLayout(new BorderLayout());
        jp_first.add("Center",jsp_display);
        jp_first.add("South",jp_first_south);
        jp_first_south.setLayout(new BorderLayout());
        jp_first_south.add("Center",jtf_msg);
        jp_first_south.add("East",jbtn_send);
        jp_second.setBackground(Color.green);
        //두번째 속지도 동서남북 중앙으로 배치할 수 있는 BorderLayout으로 변경
        jp_second.setLayout(new BorderLayout());
        //두번째 속지 남쪽에 배치할 속지는 버튼 4개를 배치해야 하므로 GridLayout으로 함.
        jp_second_south.setLayout(new GridLayout(3,2,2,2));
        jp_second_south.add(jbtn_one);
        jp_second_south.add(jbtn_change);
        jp_second_south.add(jbtn_emoticon);
        jp_second_south.add(jbtn_color);
        jp_second_south.add(jbtn_logout);
        jp_second_south.add(jbtn_exit);
        //두번째 속지에 중앙에 테이블 배치하기
        jp_second.add("Center",jsp);
        jp_second.add("South",jp_second_south);
        this.add(jp_first);
        this.add(jp_second);
        this.setTitle(nickName+"님의 대화창");
        this.setSize(800, 550);
        this.setVisible(true);

    }
}
