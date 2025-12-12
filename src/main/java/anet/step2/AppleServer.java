package anet.step2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static util.CustomLogger.logger;

public class AppleServer extends JFrame implements Runnable {
    //동시에 여러 사용자가 접속할 수 있도록 서버소켓을 사용함.
    ServerSocket server = null;
    //서버에 접속해온 사용자 소켓 정보를 담을 소켓 선언
    Socket client = null;
    //서버에 접속해온 여러 사용자 스레드 담을 객체 선언
    List<AppleServerThread> globalList = null;
    JTextArea jta_log = new JTextArea(10,30);
    JScrollPane jsp_log = new JScrollPane(jta_log,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
            , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    Font f = new Font("돋움체", Font.BOLD,20);
    @Override
    public void run() {
        logger("run() 호출");
        globalList = new ArrayList<>();
        try{
            //서버소켓 생성하기
            server = new ServerSocket(5000);
            jta_log.append("ServerSocket Ready...\n");
            logger("서버 오픈");
            while(true){
                //서버소켓에 접속해온 클라이언트 소켓에 대한 정보 받아내기
                //여기에서 waiting상태가 됨
                //대기상태에서 탈출하는 시점은 Client클래스에서
                //new Socket(ip, port)했을 때 39번이 낚아챈다.
                client = server.accept();//TCP(전송계층)-> IP(인터넷계층)
                //누눈가 입장했다면 클라이언트 정보를 읽기
                //포트 번호는 1~65,535사이번호를 사용 가능함.
                //단 1~1023번까지는 OS가 사용하므로 다른 번호를 이용함.
                //ACK -> SYN-ACK -> ACK
                jta_log.append(client+"\n");//서버포트번호와 클라이언트 할당된 포트번호 두개가 출력
//                System.out.println(client.getInetAddress());
                //클라이언트에 대한 소켓 정보를 얻어내면 BananaServerThread에게
                //제어권을 넘겨서 채팅기능을 구현해 본다
                AppleServerThread bst = new AppleServerThread(this);
                bst.start();//대신 run()호출 해줌
            }//end of while문 - 무한루프로 처리한 이유는 서버는 24시간 무중단 되어야 함.
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        AppleServer as = new AppleServer();
        as.initDisplay();
        Thread t1 = new Thread(as);
        t1.start();
    }
    public void initDisplay(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jta_log.setBackground(Color.orange);
        jta_log.setFont(f);
        //여기서 this는 BananaServer를 말함
        //그런데 왜 JFrame이 제공하는 setTitle()호출할 수 있는 건가요?
        //JFrame을 상속받았기 때문에 부모가 제공하는 메서드 호출 가능함.
        this.setTitle("채팅서버 로그");
        this.add("Center",jsp_log);
        this.setSize(800, 400);
        this.setVisible(true);
    }
}
