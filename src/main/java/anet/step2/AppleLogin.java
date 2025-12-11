package anet.step2;

import aTalk.step1.LoginForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppleLogin extends JFrame implements ActionListener {
    String imgPath = "src\\image\\";
    ImageIcon ig 		= new ImageIcon(imgPath+"main.png");
    JLabel jlb_id 		= new JLabel("아이디");
    JTextField jtf_id 	= new JTextField("test");
    JLabel jlb_pw 		= new JLabel("비밀번호");
    JPasswordField jtf_pw 	= new JPasswordField("123");
    Font font = new Font("휴먼매직체",Font.BOLD, 17);
    JButton jbtn_login =
            new JButton(
                    new ImageIcon(imgPath+"login.png"));
    JButton jbtn_join =
            new JButton(
                    new ImageIcon(imgPath+"confirm.png"));
    String 				nickName= null;//닉네임 등록
    AppleClient ac = null;
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        //로그인 요청하기
        if (obj == jbtn_login) {
            //사용자가 입력한 아이디 담기
            String mem_id = jtf_id.getText();
            //사용자가 입력한 비번 담기
            String mem_pw = jtf_pw.getText();
            AppleDaoV2 aDao = new  AppleDaoV2();
            nickName = aDao.login(mem_id,mem_pw);
            //AppleClient 인스턴스화 할 때 조회된 대화명을 넘겨야 함.
            ac = new AppleClient(nickName);
        }//end of 로그인
        //회원가입 요청
        else if(obj == jbtn_join) {
            AppleMemberShip ams = new AppleMemberShip();

        }//end of 회원가입
    }

    public static void main(String[] args) {
        AppleLogin aLogin = new AppleLogin();
        aLogin.initDisplay();
    }
    //내부 클래스로 배경 이미지 처리
    class MyPanel extends JPanel{
        public void paintComponent(Graphics g) {
            g.drawImage(ig.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
        }
    }
    public void initDisplay(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jbtn_login.addActionListener(this);
        jbtn_join.addActionListener(this);
        this.setContentPane(new MyPanel());
        this.setLayout(null);//디폴트 - BorderLayout
        jlb_id.setBounds(45, 200, 80, 40);
        jlb_id.setFont(font);
        jtf_id.setBounds(110, 200, 185, 40);
        this.add(jlb_id);
        this.add(jtf_id);
        jlb_pw.setBounds(45, 240, 80, 40);
        jlb_pw.setFont(font);
        jtf_pw.setBounds(110, 240, 185, 40);
        this.add(jlb_pw);
        this.add(jtf_pw);
        jbtn_join.setBounds(45, 285, 120, 40);
        this.add(jbtn_join);
        jbtn_login.setBounds(175, 285, 120, 40);
        this.add(jbtn_login);
        this.setTitle("자바채팅 Ver1.0");
        this.setLocation(500, 100);
        this.setSize(350, 600);
        this.setVisible(true);
    }

}
