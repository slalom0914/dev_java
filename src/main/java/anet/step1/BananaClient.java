package anet.step1;
//1-1학습목표
//클래스 나누어 처리해 보기
//이때 static사용하지 않고 생성자만으로 처리해 보기
//클래스와 클래스 사이에는 의존관계가 있다. - 해결할 수 있다.
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
JTextField에 사용자가 메시지를 입력하고 엔터(전송-이벤트)하면 처리할 수  있는
콜백메서드를 ActionListener가 선언하고 있다.
화면을 출력하는 것에는 지연이 발생하지 않는데
소켓을 생성하고 서버로 부터 응답을 받아오는데는 waiting이 발생함.
두 가지를 나누어서 처리하자(우선 순위가 있다.)
 */
public class BananaClient extends JFrame implements ActionListener {
    //아래 변수들은 BananaClientThread에서도 필요할 수 있으므로 전변으로 함
    Socket socket = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    String nickName = null;
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


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    //통신을 위해 필요한 코드 작성하기 - 지연이 발생할 수 있음.
    public void init(){
        //지연이 발생할 가능성이 있는 코드들이 있다.
        //주의 : 절대로 화면그리기 보다 먼저 호출하지 않기
        try{
            //예외가 발생할 가능성이 있는 코드
            //소켓 객체 인스턴스화 하기(서버에 accept당함)
            socket = new Socket("127.0.0.1",5000);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            //서버에게 내가 입장한 사실을 알림
            oos.writeObject(100+"#"+nickName);
        }catch (Exception e){

        }
    }//end of init
    public static void main(String[] args) {
        BananaClient bc = new BananaClient();
        //메서드 호출 순서를 반드시 지킬 것. 왜냐하면 init()먼저 하면 지연이 발생함.
        bc.initDisplay();
        bc.init();
    }
    //화면그리기 구현
    public void initDisplay(){
        nickName = JOptionPane.showInputDialog(this, "닉네임을 입력하시오.");
        System.out.println("당신이 입력한 닉네임은 "+nickName);

        //어플리케이션 닫을 때 프로세서 종료처리
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jtf_msg.addActionListener(this);
        jbtn_send.addActionListener(this);
        jbtn_exit.addActionListener(this);
        //사용자로 부터 닉네임 입력 받기
        //nickName = JOptionPane.showInputDialog("닉네임을 입력하세요.");
        this.setLayout(new GridLayout(1,2,2,2));
        //JFrame에 들어갈 첫번째 속지는 동서남북 중앙으로 배치할 수 있어야 해요.
        jp_first.setBackground(Color.orange);
        jp_first.setLayout(new BorderLayout());
        jp_first.add("Center",jta_display);
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

    }//end of initDisplay
}
