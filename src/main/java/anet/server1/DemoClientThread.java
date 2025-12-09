package anet.server1;
// 지속적으로 듣기
//클래스와 클래스 사이에 관계가 있다. -> 의존성 주입 -> 인스턴스화
public class DemoClientThread extends Thread {
    DemoClient dc = null;
    //생성자 파라미터로 받아온 객체를 run()에서 사용해야 한다.
    //그런데 나는 지변이다.-> 생성자를 벗어난 위치에서는 사용이 불가함
    //생성자의 파라미터 자리는 생성자가 호출될 때 객체를 참조하게 됨
    //아래 생성자는 어디서 호출되나요? -> DemoClient에서 호출한다.
    //언제 어느 위치에서 누구 다음에 하면 되나요? -> new Socket("형IP", 5000);
    public DemoClientThread(DemoClient dc) {
        this.dc = dc;
    }
    @Override
    public void run() {

    }
}
