package anet.step1;
/*
사용자가 서버에 접속할 때마다 스레드도 하나씩 생성해서 List에 담아둔다.
Object타입을 담을 수 있는 List인터페이스에 담아둔다.
 */
public class BananaServerThread extends Thread{
    BananaServer bs = null;
    //하나의 인스턴스에 대해서는 언제나 같은 닉네임을 가져야함. - 전변으로 함.
    String nickName = null;
    public BananaServerThread(BananaServer bs) {
        this.bs = bs;
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

    }//end of send
    @Override
    public void run() {

    }
}
