package anet.server1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//main 스레드와 이벤트스레드가 경합이 벌어지더라도 중단이나 충돌로 인해서
//멈춤, 또는 비정상적인 진행(무한루프)
public class DemoServer extends JFrame implements Runnable, ActionListener {
    ServerSocket server = null;//클라이언트 접속만 받음
    Socket client = null;
    List<DemoServerThread> globalList = null;
    JTextArea jta_log = new JTextArea(10,30);
    JScrollPane jsp_log = new JScrollPane(jta_log,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
            , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    Font f = new Font("돋움체", Font.BOLD,20);
    private volatile  boolean isStop = false;
    //포트 번호를 동적으로 처리해 본다.
    int g_port = 0;
    //서버로그 화면 바로 위에 배치할 속지선언
    JPanel jp_north 		= new JPanel();
    //서쪽에는 포트번호 라벨-JLabel jlb_port
    //중앙에는 jtf_port
    //동쪽에는 jbtn_start
    JPanel jp_north_center 	= new JPanel();
    JPanel jp_south 	    = new JPanel();
    JLabel jlb_port = new JLabel("포트번호");//3차미만 화면중심의 업무처리가 많다.
    JTextField 	jtf_port 	= new JTextField("3000",JLabel.RIGHT);
    JButton 	jbtn_start 	= new JButton("서버기동");
    JButton 	jbtn_down 	= new JButton("서버다운");
    JButton 	jbtn_clear 	= new JButton("로그 초기화");

    @Override
    public void run() {//콜백함수 - 우리가 직접호출하지 않음.
        globalList=new ArrayList<DemoServerThread>();
        try{
            //서버소켓 생성하기
            server = new ServerSocket(g_port);
            System.out.println("ServerSocket Ready...");
            while(!isStop){
                client = server.accept();
                System.out.println(client);
                DemoServerThread bst = new DemoServerThread(this);
                bst.start();//대신 run()호출 해줌
            }//end of while문 - 무한루프로 처리한 이유는 서버는 24시간 무중단 되어야 함.
        }catch(Exception e){
            //서버를 의도적으로 종료한 경우에는 예외 로그를 출력하지 않음
            if(!isStop){
                e.printStackTrace();
            }else {
                jta_log.append("서버가 정상적으로 종료되었습니다.\n");
            }
        }finally {
            try{
                if(server!=null && !server.isClosed()){
                    server.close();
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        DemoServer ds = new DemoServer();
        ds.initDisplay();//화면이 출력됨
        Thread t = new Thread(ds);//main스레드와 이벤트 스레드 충돌이나 중단점
        t.start();//run()호출됨-지연이 발생할 가능성이 있는 코드를 따로 관리함.
    }
    //화면 그리기
    public void initDisplay(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        jbtn_start.addActionListener(this);
        jbtn_down.addActionListener(this);
        jbtn_clear.addActionListener(this);
        jtf_port.setHorizontalAlignment(JTextField.RIGHT);
        jta_log.setBackground(Color.green);
        jta_log.setFont(f);
        jp_north_center.setLayout(new BorderLayout());
        jp_north_center.add("West",jlb_port);
        jp_north_center.add("Center",jtf_port);
        jp_north_center.add("East",jbtn_start);
        jp_north.setLayout(new BorderLayout());
        jp_north.add("Center",jp_north_center);
        jp_north.add("East",jbtn_down);
        jp_south.setLayout(new GridLayout(1,6));
        jp_south.add(jbtn_clear);
        this.add("North",jp_north);
        this.add("Center",jsp_log);
        this.add("South",jp_south);
        this.setSize(800,500);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //이벤트가 감지된 이벤트 소스 주소번지 가져오기
        //e의 타입은 ActionEvent타입이다. - 파라미터 - 호출될 때 객체주입됨.
        //actionPerformed는 콜백메서드 이라서 개발자가 직접 호출할 수 없다.
        //이벤트가 감지 되면 JVM이 자동으로 호출함.
        Object obj = e.getSource();
        //서버기동 버튼을 누른거야? - 참
        if(obj == jbtn_start){
            //숫자가 아닌 다른 문자열일 경우도 예외처리가 필요함
            try{
                //이미 서버가 기동 중이면 다시 시작되지 않도록 처리
                //insert here
                
            }catch(NumberFormatException nfe){
                jta_log.append("포트번호를 숫자로 입력하세요.\n");
            }
        }//end of 서버시작
    }//end of actionPerformed
}
