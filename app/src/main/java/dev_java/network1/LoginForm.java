package dev_java.network1;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Graphics;

public class LoginForm extends JFrame{
	//선언부
	String imgPath = "E:\\vscode_java\\dev_java\\app\\src\\main\\java\\dev_java\\images\\login\\";
	ImageIcon imageIcon = new ImageIcon(imgPath+"main.png");
	JLabel jlb_id = new JLabel("아이디");
	JTextField jtf_id = new JTextField("tomato");
	JLabel jlb_pw = new JLabel("비밀번호");
	JPasswordField jpf_pw = new JPasswordField();
	Font font = new Font("휴먼매직체", Font.BOLD, 17);
	JButton jbtn_login = new JButton(new ImageIcon(imgPath+"login.png"));
	JButton jbtn_join = new JButton(new ImageIcon(imgPath+"confirm.png"));
	//생성자
	LoginForm(){
		//initDisplay();
	}
	//내부클래스로 배경 이미지 처리
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g){
			g.drawImage(imageIcon.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}//end of MyPanel - 사용자 패널정의 - LoginForm$1.class, LoginForm$MyPanel.class
	//화면그리기
	public void initDisplay(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new MyPanel());
		this.setLayout(null);
		jlb_id.setBounds(45, 200, 80, 40);
		jlb_id.setFont(font);
		jtf_id.setBounds(110, 200, 185, 40);
		this.add(jlb_id);
		this.add(jtf_id);
		jlb_pw.setBounds(45, 240, 80, 40);
		jlb_pw.setFont(font);
		jpf_pw.setBounds(110, 240, 185, 40);
		this.add(jlb_pw);
		this.add(jpf_pw);
		jbtn_join.setBounds(45, 285, 120, 40);
		this.add(jbtn_join);
		jbtn_login.setBounds(175, 285, 120, 40);	
		this.add(jbtn_login);
		this.setTitle("자바채팅 Ver1.0");
		this.setLocation(500, 100);
		this.setSize(350, 600);
		this.setVisible(true);
	}
	//메인메소드
	public static void main(String[] args) {
		LoginForm loginForm = new LoginForm();
		loginForm.initDisplay();
	}
}
