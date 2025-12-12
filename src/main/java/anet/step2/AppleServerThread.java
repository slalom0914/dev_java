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
                msg = (String)ois.readObject();
                as.jta_log.append(msg + "\n");
                logger(msg);
                as.jta_log.setCaretPosition(as.jta_log.getDocument().getLength());
                StringTokenizer st = null;
                int protocol = 0;//100:입장, 200:다자간대화, 300:1:1대화, 400:대화명변경, 500:종료
                if(msg !=null){
                    st = new StringTokenizer(msg,"#");
                    protocol = Integer.parseInt(st.nextToken());
                }//end of if
                switch(protocol){
                    case 200:{//다자간 대화
                        String nickName = st.nextToken();
                        String message = st.nextToken();
                        broadCasting(200+"#"+nickName+"#"+message);
                    }break;
                    case 500:{//종료처리
                        String nickName = st.nextToken();
                        //종료버튼 누른사람은 스레드를 제거함.
                        as.globalList.remove(this);//현재 스레드만 삭제함.
                        broadCasting(500+"#"+nickName);//500번 자체가 나갔음을 의미함.
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
