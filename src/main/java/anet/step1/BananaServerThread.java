package anet.step1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

/*
사용자가 서버에 접속할 때마다 스레드도 하나씩 생성해서 List에 담아둔다.
Object타입을 담을 수 있는 List인터페이스에 담아둔다.
 */
public class BananaServerThread extends Thread{
    BananaServer bs = null;
    Socket client = null;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;
    //하나의 인스턴스에 대해서는 언제나 같은 닉네임을 가져야함. - 전변으로 함.
    String nickName = null;
    private volatile boolean isRun = false;
    public BananaServerThread(BananaServer bs) {
        this.bs = bs;
        this.client = bs.client;//누락하면 NullPointerException
        try {
            oos = new ObjectOutputStream(client.getOutputStream());
            ois = new ObjectInputStream(client.getInputStream());
            //사용자가 보내온 정보를 읽기
            String msg = (String)ois.readObject();//100#키위
            bs.jta_log.append(msg + "\n");
            //로그 메시지가 출력될 때 출력되는 문자열의 길이를 계산해서 스크롤바 위치
            //자동 갱신 처리
            bs.jta_log.setCaretPosition(bs.jta_log.getDocument().getLength());
            StringTokenizer st = new StringTokenizer(msg,"#");
            st.nextToken();//100잘림
            nickName = st.nextToken();//키위 담김
            //스레드에 담긴 사람들: 내가 입장하기 전에 입장한 사람들의 메시지 처리
            for(BananaServerThread bst:bs.globalList){
                this.send(100+"#"+bst.nickName);
            }
            //내가 입장한 후에 사람들 메시지 처리
            broadCasting(msg);
        }catch(Exception ex) {

        }
    }
    //현재 입장해 있는 친구들 모두에게 메시지 전송하기
    public void broadCasting(String msg){
        for(BananaServerThread bst:bs.globalList){
            //System.out.println(bst.nickName);
            bst.send(msg);
        }
    }
    //클라이언트가 보낸 메시지를 듣고 말하기 구현
    public void send(String msg){
        try {
            oos.writeObject(msg);//100#키위
        }catch(Exception ex) {

        }
    }//end of send
    @Override
    public void run() {//200번에 대한 처리
        String msg = null;
        try {
            run_start:
            while(!isRun) {
                msg = (String)ois.readObject();
                bs.jta_log.append(msg + "\n");
                bs.jta_log.setCaretPosition(bs.jta_log.getDocument().getLength());
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
                        bs.globalList.remove(this);//현재 스레드만 삭제함.
                        broadCasting(500+"#"+nickName);//500번 자체가 나갔음을 의미함.
                    }break run_start;//현재 스레드는 종료됨과 동시에 반복문 탈출하기
                }//end of switch
            }//end of while
        }catch(Exception ex) {

        }//end of try..catch
    }//end of run
}
