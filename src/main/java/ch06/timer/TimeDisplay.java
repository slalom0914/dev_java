package ch06.timer;

import javax.swing.*;
import java.awt.*;

//TimeClient가 TimeServer에 접속하여 1초에 한 번씩 현재 시간을
//듣는다.
//TimeClient가 청취한 현재 시간을 굳이 TimeDisplay클래스의
//JLabel 화면 중앙에 배치하고 큰 글씨로 출력하기
public class TimeDisplay extends JFrame {
    JFrame jf_time = new JFrame();
    JLabel jlb_time = new JLabel("15:35:17",JLabel.CENTER);
    Font font = new Font("굴림체",Font.BOLD,68);
    public TimeDisplay() {
        //생성자 안에서 화면그리기 메서드 호출
        initDisplay();
    }
    //화면그리기 구현
    public void initDisplay(){
        TimeClient timeClient = new TimeClient(jlb_time);
        timeClient.start();//TimeClient에 있는 run()호출됨.
        jlb_time.setFont(font);
        jf_time.add("Center",jlb_time);
        jf_time.setSize(400,200);
        jf_time.setVisible(true);
    }
    //main
    public static void main(String[] args) {
        //오늘부터는 main메소드에 코드를 가능한 적게 쓰기
        //인스턴스화를 하면 생성자가 호출된다.
        //생성자 안에서 화면그리는 메서드 호출하기
        TimeDisplay td = new TimeDisplay();
    }
}
