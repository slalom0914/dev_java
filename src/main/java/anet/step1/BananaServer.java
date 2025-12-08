package anet.step1;
/*
자바는 단일상속만 가능하므로 Thread상속받을 수 없다.
그래서 인터페이스인 Runnable implements한 다음 run재정의 한다.
 */
import javax.swing.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class BananaServer extends JFrame implements Runnable{
    //동시에 여러 사용자가 접속할 수 있도록 서버소켓을 사용함.
    ServerSocket server = null;
    //서버에 접속해온 사용자 소켓 정보를 담을 소켓 선언
    Socket client = null;
    //서버에 접속해온 여러 사용자 스레드 담을 객체 선언
    List<BananaServerThread> globalList = null;
    @Override
    public void run() {
        //globalList = new ArrayList<>();
        //메모리는 할당되었지만 현재 아무것도 없는 상태이다.
        globalList = new ArrayList<BananaServerThread>();
        System.out.println(globalList.size());//0
        try{
            //서버소켓 생성하기
            server = new ServerSocket(5000);
            System.out.println("ServerSocket Ready...");
            while(true){
                //서버소켓에 접속해온 클라이언트 소켓에 대한 정보 받아내기
                //여기에서 waiting상태가 됨
                client = server.accept();
                //누눈가 입장했다면 클라이언트 정보를 읽기
                System.out.println(client.getInetAddress());
                //클라이언트에 대한 소켓 정보를 얻어내면 BananaServerThread에게
                //제어권을 넘겨서 채팅기능을 구현해 본다
                BananaServerThread bst = new BananaServerThread(this);
                bst.start();//대신 run()호출 해줌
            }//end of while문 - 무한루프로 처리한 이유는 서버는 24시간 무중단 되어야 함.
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }//end of run

    public static void main(String[] args) {
        BananaServer bs = new BananaServer();
        bs.initDisplay();
        //main스레드가 아닌 다른 하나의 스레드가 더 있다.
        Thread t = new Thread(bs);
        t.start();//run()호출됨(내부에 선언된 run호출)
        //main스레드와 충돌이 일어나지 않도록 하기 위해서 이렇게 함.
    }//end of main
    //서버에 로그를 출력하기 위해 화면 그리기
    public void initDisplay() {

    }//end of initDisplay
}//end of BananaServer
