package anet.server1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DemoClient extends JFrame implements ActionListener {
    Socket              socket  = null;
    ObjectInputStream   ois     = null;
    ObjectOutputStream  oos     = null;
    String              nickName = null;
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void init(){
        try {
            socket  = new Socket("127.0.0.1",3000);
            oos     = new ObjectOutputStream(socket.getOutputStream());//말하기
            ois     = new ObjectInputStream(socket.getInputStream());//청취
            //내가 서버에 접속한 사실을 알림
            oos.writeObject(100+"#"+nickName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        DemoClient dc = new DemoClient();
        dc.initDisplay();//화면그리는얘
        dc.init();//소켓을 생성하고 생성된 소켓으로 IO클래스 생성해야 됨
    }
    public void initDisplay(){
        nickName = JOptionPane.showInputDialog(this, "닉네임 입력하세요.");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
