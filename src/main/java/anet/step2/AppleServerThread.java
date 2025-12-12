package anet.step2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

import static util.CustomLogger.logger;

public class AppleServerThread extends Thread {
    AppleServer as = null;
    Socket client = null;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;
    //하나의 인스턴스에 대해서는 언제나 같은 닉네임을 가져야함. - 전변으로 함.
    String nickName = null;
    private volatile boolean isRun = false;
    public AppleServerThread(AppleServer as) {
        this.as = as;
        this.client = as.client;//누락하면 NullPointerException
        try {
            oos = new ObjectOutputStream(client.getOutputStream());
            ois = new ObjectInputStream(client.getInputStream());
            //사용자가 보내온 정보를 읽기
            String msg = (String)ois.readObject();//100#키위
            as.jta_log.append(msg + "\n");
            as.jta_log.setCaretPosition(as.jta_log.getDocument().getLength());
            StringTokenizer st = new StringTokenizer(msg,"#");
            st.nextToken();//100잘림
            nickName = st.nextToken();//키위 담김
            //스레드에 담긴 사람들: 내가 입장하기 전에 입장한 사람들의 메시지 처리
            for(AppleServerThread bst:as.globalList){
                logger("내가 입장하기 전에 입장해 있는 사람들");
                this.send(100+"#"+bst.nickName);
            }
            as.globalList.add(this);
            //내가 입장한 후에 사람들 메시지 처리
            broadCasting(msg);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void run() {
        String msg = null;
        try {
            run_start:
            while(!isRun) {
                //여기서 듣기가 됨
                msg = (String)ois.readObject();
                as.jta_log.append(msg + "\n");
                logger(msg);
                as.jta_log.setCaretPosition(as.jta_log.getDocument().getLength());
                //프로토콜을 분석하고
                StringTokenizer st = null;
                int protocol = 0;//100:입장, 200:다자간대화, 300:1:1대화, 400:대화명변경, 500:종료
                if(msg !=null){
                    st = new StringTokenizer(msg,"#");
                    protocol = Integer.parseInt(st.nextToken());
                }//end of if
                switch(protocol){
                    case Protocol.WHISPER:{//1:1대화
                        //보내는 사람
                        //nextToken사용하면 커서처럼 위치 정보가 바뀌므로 다음정보가 대기
                        String nickName = st.nextToken();
                        //받는 사람
                        String otherName = st.nextToken();
                        //메시지
                        String message = st.nextToken();
                        //벡터에서 그 사람(=그 사람의 스레드)을 찾기
                        for(AppleServerThread bst:as.globalList){
                            logger(bst.nickName+", "+this.nickName);
                            if(otherName.equals(bst.nickName)){
                                bst.send(Protocol.WHISPER
                                        +"#"+nickName
                                        +"#"+otherName
                                        +"#"+message);
                                break;//반복문을 탈출하기
                            }//end of if
                        }//end of for
                        //나 자신에게도 메시지를 전송하기
                        this.send(Protocol.WHISPER+"#"+nickName+"#"+otherName+"#"+message);
                    }break;
                    case Protocol.MESSAGE:{//다자간 대화
                        String nickName = st.nextToken();
                        String message = st.nextToken();
                        broadCasting(Protocol.MESSAGE+"#"+nickName+"#"+message);
                    }break;
                    case Protocol.ROOM_OUT:{//종료처리
                        String nickName = st.nextToken();
                        //종료버튼 누른사람은 스레드를 제거함.
                        as.globalList.remove(this);//현재 스레드만 삭제함.
                        broadCasting(Protocol.ROOM_OUT+"#"+nickName);//500번 자체가 나갔음을 의미함.
                    }break run_start;//현재 스레드는 종료됨과 동시에 반복문 탈출하기
                }//end of switch
            }//end of while
            System.out.println("while 탈출하기");
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }//end of try..catch
    }
    public void broadCasting(String msg){
        for(AppleServerThread bst:as.globalList){
            logger(bst.nickName);
            bst.send(msg);
        }//end of for
    }//end of broadingCasting
    public void send(String msg){
        try {
            oos.writeObject(msg);//100#키위
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//end of send
}
