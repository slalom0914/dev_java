package anet.step1;
//1-1학습목표
//클래스 나누어 처리해 보기
//이때 static사용하지 않고 생성자만으로 처리해 보기
//클래스와 클래스 사이에는 의존관계가 있다. - 해결할 수 있다.
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
JTextField에 사용자가 메시지를 입력하고 엔터(전송-이벤트)하면 처리할 수  있는
콜백메서드를 ActionListener가 선언하고 있다.
화면을 출력하는 것에는 지연이 발생하지 않는데
소켓을 생성하고 서버로 부터 응답을 받아오는데는 waiting이 발생함.
두 가지를 나누어서 처리하자(우선 순위가 있다.)
 */
public class BananaClient extends JFrame implements ActionListener {
    //아래 변수들은 BananaClientThread에서도 필요할 수 있으므로 전변으로 함
    Socket socket = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    String nickName = null;
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    //통신을 위해 필요한 코드 작성하기 - 지연이 발생할 수 있음.
    public void init(){
        //지연이 발생할 가능성이 있는 코드들이 있다.
        //주의 : 절대로 화면그리기 보다 먼저 호출하지 않기
        try{
            //예외가 발생할 가능성이 있는 코드
            //소켓 객체 인스턴스화 하기(서버에 accept당함)
            socket = new Socket("127.0.0.1",5000);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            //서버에게 내가 입장한 사실을 알림
            oos.writeObject(100+"#"+nickName);
        }catch (Exception e){

        }
    }//end of init
    public static void main(String[] args) {
        BananaClient bc = new BananaClient();
        //메서드 호출 순서를 반드시 지킬 것. 왜냐하면 init()먼저 하면 지연이 발생함.
        bc.initDisplay();
        bc.init();
    }
    //화면그리기 구현
    public void initDisplay(){
        nickName = JOptionPane.showInputDialog(this, "닉네임을 입력하시오.");

    }//end of initDisplay
}
