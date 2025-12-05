package ch06.timer;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//기지국에서 1초에 한 번씩 보내주는 시간정보를 청취하기
//지속적으로 1초에 한 번씩 실행문을 처리하기 위해서 Thread상속받음
public class TimeClient extends Thread{
    /*
    서버소켓과 통신은 TimeClient에서 하고 서버소켓에서 써준 현재 시간정보도
    TimeClient를 통해서 읽어올 수 있다.
    즉 현재시간정보는 TimeClient에 있는데 시간 정보에 대한 출력은
    TimeDisplay에서 해야 한다.
    TimeDisplay에서 TimeClient를 인스턴스화 해야 한다.

     */
    JLabel jlb_time = null;
    public TimeClient(JLabel jlb_time) {
        System.out.println("TimeClient생성자 호출");
        this.jlb_time = jlb_time;
    }
    //Thread가 선언하고 있는 run()를 재정의하여
    //그 속에서 소켓 생성을 통하여 TimeServer의 ServerSocket에 접속함
    @Override
    public void run(){
        System.out.println("TimeClient run() 호출");
        Socket socket = null;
        PrintWriter out = null;//쓰기
        BufferedReader in = null;//청취하기
        //서버측에서 소켓에 쓴 현재 시간 정보를 담기
        String time = null;
        try{
            socket = new Socket("192.168.0.41",3000);
            out = new PrintWriter(socket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                while((time = in.readLine())!=null){
                    System.out.println(time);
                    //TimeClient를 직접 실행하지 않고서 TimeDisplay에서 인스턴스화를 함
                    jlb_time.setText(time);//NullPointerException발생
                }
                try {
                    sleep(1000);
                }catch(InterruptedException e){
                    System.out.println(e.getMessage());//스레드 관련 에러 발생시 출력하기
                }//end of inner while
            }//end of outer while
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }//end of run

    public static void main(String[] args) {
        //인스턴스화 하였다. -> 디폴트 생성자 호출됨
        //TimeClient timeClient = new TimeClient();
        //run()직접 호출하지 않고 start()호출하면 JVM대신 호출 해줌.
        //timeClient.start();
    }//end of main
}//end of TimeClient
