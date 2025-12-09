package anet.step1;

import java.util.StringTokenizer;

//서버로 부터 순서대로 메시지를 들어야 한다.
//지속적으로 듣는다.
/*
BananaClientThread는 BananaClient에서 소켓정보와 IO클래스 원본을
사용해야 한다. - 그래서 생성자를 통해 파라미터로 현재 활성화된 객체 주소번지
초기화 할것.
 */
public class BananaClientThread extends Thread {
    BananaClient bc = null;
    BananaClientThread(BananaClient bc){
        this.bc = bc;
    }//end of 생성자
    private volatile boolean isRun = false;
    @Override
    public void run() {
        while(!isRun){
            try {
                String msg = null;
                msg = (String)bc.ois.readObject();
                StringTokenizer st = null;
                int protocol = 0;
                if(msg !=null){
                    st = new StringTokenizer(msg,"#");
                    protocol = Integer.parseInt(st.nextToken());//100, 200, 500
                }//end of if
                switch(protocol){
                    case 100:{
                        String nickName = st.nextToken();
                        bc.jta_display.append(nickName+"님이 입장하였습니다.\n");
                    }break;
                }
            }catch(Exception e){

            }
        }//end of while
    }//end of run()
}//end of BananaClientThread
