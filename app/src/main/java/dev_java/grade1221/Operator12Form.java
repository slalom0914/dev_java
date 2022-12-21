package dev_java.grade1221;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Font;

public class Operator12Form implements ActionListener {
	static int i;
	static int j;
	JFrame jf = new JFrame();
	JPanel jp_north = new JPanel();
	JPanel jp_center = new JPanel();
	JPanel jp_south = new JPanel();
	JButton jbtn_account = new JButton("연산");
	JButton jbtn_exit = new JButton("종료");
	JButton jbtn_first = new JButton("1");
	JLabel jlb_oper = new JLabel("연산자");
	JButton jbtn_plus = new JButton("+");
	JButton jbtn_minus = new JButton("-");
	JButton jbtn_mult = new JButton("*");
	JButton jbtn_div = new JButton("/");
	JButton jbtn_second = new JButton("2");
	JTextField jtf_result = new JTextField("");
	Font f = new Font("Paryrus", Font.BOLD, 40);

	double account(String oper) {
		double tot = 0;
		if ("+".equals(oper)) {
			tot = i + j;
		} else if ("-".equals(oper)) {
			tot = i - j;
		} else if ("*".equals(oper)) {
			tot = i * j;
		} else if ("/".equals(oper)) {
			tot = i / (double) j;
		}
		return tot;
	}

	public void initDisplay() {
		jbtn_first.setFont(f);
		jbtn_second.setFont(f);
		jbtn_plus.setFont(f);
		jbtn_minus.setFont(f);
		jbtn_mult.setFont(f);
		jbtn_div.setFont(f);
		jbtn_plus.addActionListener(this);
		jbtn_minus.addActionListener(this);
		jbtn_mult.addActionListener(this);
		jbtn_div.addActionListener(this);
		jbtn_account.addActionListener(this);
		jbtn_exit.addActionListener(this);
		jbtn_first.addActionListener(this);
		jbtn_second.addActionListener(this);
		jtf_result.addActionListener(this);
		jlb_oper.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_oper.setVerticalAlignment(SwingConstants.CENTER);
		jp_south.add(jbtn_account);
		jp_south.add(jbtn_exit);
		jp_center.setLayout(new GridLayout(1, 4));
		jp_center.add(jbtn_plus);
		jp_center.add(jbtn_minus);
		jp_center.add(jbtn_mult);
		jp_center.add(jbtn_div);
		jp_north.setLayout(new GridLayout(1, 4));
		jp_north.add(jbtn_first);
		jp_north.add(jlb_oper);
		jp_north.add(jbtn_second);
		jp_north.add(jtf_result);
		jf.add("North", jp_north);
		jf.add("Center", jp_center);
		jf.add("South", jp_south);
		jf.setTitle("계산기구현");
		jf.setSize(400, 200);
		jf.setVisible(true);
	}

	public static void main(String[] args) {
		Operator12Form op1 = new Operator12Form();
		op1.initDisplay();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// 이벤트가 발생하기 전에 첫번째 숫자와 두번째 숫자를 담는 이유는 무엇입니까?
		i = Integer.parseInt(jbtn_first.getText());
		j = Integer.parseInt(jbtn_second.getText());
		if (jbtn_account == obj) {// 연산 버튼
			System.out.println("연산버튼 클릭");
		} else if (jbtn_first == obj) {
			System.out.println("사용자가 입력한 값1 : " + jbtn_first.getText());
		} else if (jbtn_second == obj) {
			System.out.println("사용자가 입력한 값 2: " + jbtn_second.getText());
		} else if (jtf_result == obj) {
			System.out.println("jtf_result : ");
		} else if (jbtn_exit == obj) {
			System.exit(0);
		} else if (jbtn_plus == obj) {// 더하기 연산자
			// insert here
		} else if (jbtn_minus == obj) {// 빼기 연산자
			// insert here
		} else if (jbtn_mult == obj) {// 곱하기 연산자
			// insert here
		} else if (jbtn_div == obj) {// 나누기 연산자
			// insert here
		}
	}// end of actionPerformed
}
