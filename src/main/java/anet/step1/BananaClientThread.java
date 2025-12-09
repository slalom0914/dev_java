package anet.step1;

import java.util.StringTokenizer;
import java.util.Vector;

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
                        Vector<String> v = new Vector<String>();
                        v.add(nickName);
                        bc.dtm.addRow(v);
                    }break;
                    case 200:{//200#키위#오늘 스터디할까?
                        String nickName = st.nextToken();
                        String message = st.nextToken();
                        bc.jta_display.append("[ "+nickName+" ] "+message+"\n");
                        bc.jta_display.setCaretPosition(bc.jta_display.getDocument().getLength());
                    }break;
                    //case문 마다 {}로 스코프 준 이유는 우리가 같은 프로토콜정보를 사용하므로
                    //동일한 이름의 변수 사용이 불가피하다.- 그래서 사용함.
                    case 500:{
                        String nickName = st.nextToken();
                        bc.jta_display.append(nickName+"님이 퇴장하였습니다.\n");
                        bc.jta_display.setCaretPosition(bc.jta_display.getDocument().getLength());
                        for(int i=0;i<bc.dtm.getRowCount();i++){
                            String n = bc.dtm.getValueAt(i,0).toString();
                            if(n.equals(nickName)){
                                bc.dtm.removeRow(i);
                            }//end of if - 데이터셋에 있는 대화명을 삭제하기
                        }//end of for - 여러명 중에서 찾기
                    }break;
                }
            }catch(Exception e){

            }
        }//end of while
    }//end of run()
}//end of BananaClientThread
