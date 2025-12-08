package ch06.timer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class TimeServer extends Thread{
    //선언부
    private Socket socket;
    //생성자
    public TimeServer(Socket socket){
        this.socket=socket;
    }
    //Thread의 run메서드를 재정의하기
    //경합벌어지는 일, 순서대로 처리하는 일, 지속적으로 뭔가를 해야 할 떄
    public void run() {
        try {
            //서버소켓에 접속한 클라이언트 소켓을 사용하여 쓰기클래스 생성함.
            //소켓을 활용해서 생성한 출력 스트림
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            //현재 클래스에서는 굳이 필요없음. -왜냐면 메신저를 만드는게 아니므로 필요없음.
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            while(true) {
                //클라이언트 소켓에 서버시간을 쓰기 - 1초 후에 다시 반복해서 쓰기
                out.println(getTime());
                try {
                    sleep(1000);//1초에 한 번씩 멈춤 처리함. 1초 후에는 다시 깨어남
                } catch(InterruptedException i) {}
            }

        } catch (IOException e) {//IO패키지 클래스관련 반드시 예외처리 하라
            e.printStackTrace();
        } finally {//예외가 발생하더라도 무조건 실행해
            System.out.println("\nClient disconnected...\n");
            try {
                socket.close();
            } catch(IOException e) {}
        }
    }//end of run
    //시간정보를 반환하는 메서드 구현
    // -> 02:34:17
    public String getTime(){
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int min =  now.get(Calendar.MINUTE);
        int sec = now.get(Calendar.SECOND);
        return  (hour < 10 ? "0"+hour : ""+hour)+":"+
                (min < 10 ? "0"+min : ""+min)+":"+
                (sec < 10 ? "0"+sec : ""+sec);
        //return "14:05:08";
    }//end of getTime
    //main메서드 - 서버는 24시간 계속 살아있다.
    public static void main(String[] args) {
        int port = 3000;
        ServerSocket server = null;
        //서버측에 있는 소켓이지만 서버소켓에 접속해온 클라이언트의 소켓을
        //담을 객체
        Socket client = null;
        boolean isStop = false;
        try {
            server = new ServerSocket(port);
            //waitting - 기다림...pending
        }catch (Exception e){
            System.out.println(port+"번 포트가 사용중 입니다.");
            e.printStackTrace();//stack에 쌓여있는 에러 메시지를 출력해줌
        }
        System.out.println("Time Server Start Successfully....");
        while(!isStop){
            try {
                //서버소켓에 입장한 클라이언트 소켓정보 받아오기
                //클라이언트측 - > Socket s = new Socket("192.168.0.41", 3000);
                client = server.accept();
                System.out.println(client.getInetAddress());
                System.out.println("손님이 입장하였습니다.");
                TimeServer timeServer = new TimeServer(client);
                //Thread에 run메서드를 직접 호출하는게 아니라 start()호출함.
                //run()메서드에서 client소켓 주소번지가 필요하다.
                //그런데 client소켓이 지역변수 이므로 전역에서 사용할 수
                //있도록 해야 함.
                //파라미터가 있는 생성자는 JVM이 자동으로 만들어주지 않음
                timeServer.start();
            }catch (Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
                if(client!=null){
                    try {
                        client.close();
                    }catch (Exception e2){}
                }
            }//try..catch
        }//end of while
    }//end of main
}
