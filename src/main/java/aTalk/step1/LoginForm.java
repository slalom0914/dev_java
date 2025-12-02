package aTalk.step1;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame implements ActionListener {
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
    LoginForm(){

    }
    //내부 클래스로 배경 이미지 처리
    class MyPanel extends JPanel{
        public void paintComponent(Graphics g) {
            g.drawImage(ig.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
        }
    }
    public void initDisplay() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jbtn_login.addActionListener(this);
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
    public static void main(String[] args) {
        LoginForm login = new LoginForm();
        login.initDisplay();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
    }
}

