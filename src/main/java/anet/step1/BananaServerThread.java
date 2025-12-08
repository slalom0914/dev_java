package anet.step1;

public class BananaServerThread extends Thread{
    BananaServer bs = null;
    public BananaServerThread(BananaServer bs) {
        this.bs = bs;
    }
    //현재 입장해 있는 친구들 모두에게 메시지 전송하기
    public void broadCasting(String msg){
        for(BananaServerThread bst:bs.globalList){
            bst.send(msg);
        }
    }
    //클라이언트가 보낸 메시지를 듣고 말하기 구현
    public void send(String msg){

    }//end of send
    @Override
    public void run() {

    }
}
