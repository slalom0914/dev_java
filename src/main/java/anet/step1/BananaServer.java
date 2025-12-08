package anet.step1;
/*
자바는 단일상속만 가능하므로 Thread상속받을 수 없다.
그래서 인터페이스인 Runnable implements한 다음 run재정의 한다.
 */
import javax.swing.*;
import java.net.ServerSocket;
import java.net.Socket;
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

    }//end of run

    public static void main(String[] args) {

    }//end of main
    //서버에 로그를 출력하기 위해 화면 그리기
    public void initDisplay() {

    }//end of initDisplay
}//end of BananaServer
