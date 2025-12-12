package anet.step2;

import java.util.StringTokenizer;
import java.util.Vector;
import static util.CustomLogger.logger;

public class AppleClientThread extends Thread {
    AppleClient ac = null;
    private volatile  boolean isRun = false;
    public AppleClientThread(AppleClient ac) {
        this.ac = ac;
    }
    @Override
    public void run() {
        logger("run()호출");
        while(!isRun){
            try {
                String msg = null;
                msg = (String)ac.ois.readObject();
                StringTokenizer st = null;
                int protocol = 0;
                if(msg !=null){
                    st = new StringTokenizer(msg,"#");
                    protocol = Integer.parseInt(st.nextToken());//100, 200, 500
                }//end of if
                switch(protocol){
                    case Protocol.CHANGE:{
                        String nickName = st.nextToken();//하늘공원
                        String afterName = st.nextToken();//한강공원
                        String message = st.nextToken();
                        //DefaultTableModel에 있는 대화명 변경하기
                        for(int i=0;i<ac.dtm.getRowCount();i++){
                            //대화명을 변경하기 전에 현재 테이블에서 가져온 대화명을 받기
                            String cname = (String)ac.dtm.getValueAt(i,1);
                            if(cname.equals(nickName)){
                                ac.dtm.setValueAt(afterName,i,1);
                                break;//for문을 빠져 나옴
                            }else{
                                logger("여기");
                            }
                        }//end of for
                        ac.jta_display.append(message+"\n");
                        //열린 채팅창의 타이틀 바에 적힌 대화명도 변경하기
                        if(nickName.equals(ac.nickName)){
                            ac.setTitle(afterName+"님의 대화창");
                            ac.nickName = afterName;
                        }
                    }break;
                    case Protocol.ROOM_IN:{
                        String nickName = st.nextToken();
                        ac.jta_display.append(nickName+"님이 입장하였습니다.\n");
                        logger(nickName+"님이 입장하였습니다.");
                        logger(ac.user[0]+", "+ac.user[1]);
                        //Vector<String> v = new Vector<String>();
                        //v.add(nickName);
                        ac.dtm.addRow(ac.user);
                    }break;
                    case Protocol.MESSAGE:{//200#키위#오늘 스터디할까?
                        String nickName = st.nextToken();
                        String message = st.nextToken();
                        ac.jta_display.append("[ "+nickName+" ] "+message+"\n");
                        logger("[ "+nickName+" ] "+message);
                        ac.jta_display.setCaretPosition(ac.jta_display.getDocument().getLength());
                    }break;
                    //-> 300#누가#누구에게#메시지
                    case Protocol.WHISPER:{
                        logger("1:1대화");
                        String nickName = st.nextToken();
                        String otherName = st.nextToken();
                        String message = st.nextToken();
                        ac.jta_display.append(nickName+"님이 "
                                +otherName+"님에게 "+message+"\n");
                        //커서 이동이 자동으로 처리되도록 하기
                        ac.jta_display.setCaretPosition(ac.jta_display.getDocument().getLength());
                    }break;
                    //case문 마다 {}로 스코프 준 이유는 우리가 같은 프로토콜정보를 사용하므로
                    //동일한 이름의 변수 사용이 불가피하다.- 그래서 사용함.
                    case Protocol.ROOM_OUT:{
                        String nickName = st.nextToken();
                        ac.jta_display.append(nickName+"님이 퇴장하였습니다.\n");
                        ac.jta_display.setCaretPosition(ac.jta_display.getDocument().getLength());
                        for(int i=0;i<ac.dtm.getRowCount();i++){
                            String n = ac.dtm.getValueAt(i,0).toString();
                            if(n.equals(nickName)){
                                ac.dtm.removeRow(i);
                            }//end of if - 데이터셋에 있는 대화명을 삭제하기
                        }//end of for - 여러명 중에서 찾기
                    }break;
                }
            }catch(Exception e){

            }
        }//end of while
    }//end of run
}//end of AppleClientThread
