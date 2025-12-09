package anet.server1;

import java.net.Socket;

public class DemoServerThread extends Thread {
    DemoServer ds = null;
    Socket client = null;
    //서버스레드에서도 24시간 무중단 서비스 제공함
    private volatile boolean isRun = false;
    public DemoServerThread(DemoServer ds) {
        this.ds = ds;
    }
    @Override
    public void run(){

    }//end of run
    public void closeThread(){
        isRun = false; //루프 조건 해제
        //Thread는 여러가지 이유로 sleep상태에 있거나 wait상테에 있을 수 있다.
        interrupt();//잠자고 있거나 대기중인 스레드를 깨우는 메서드
        try{
            if(client !=null && !client.isClosed()){
                client.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
