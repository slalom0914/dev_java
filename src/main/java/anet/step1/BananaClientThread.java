package anet.step1;
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
    @Override
    public void run() {

    }//end of run()
}//end of BananaClientThread
