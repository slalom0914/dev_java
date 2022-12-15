package dev_java.tables;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.FlowLayout;

//이른인스턴스화 , 게으른 인스턴스화
//어떤 클래스를 상속 받을 때에는 extends예약어를 사용
//A is a B관계이면 상속으로 처리한다.
//소나타는 자동차 이다.
//자동차는 소나타 이다.
//부모클래스가 가진 변수와 메소드도 사용가능함 - 자손이 더 많이 누릴 수 있다
public class DeptTable1 extends JFrame {// DeptTable1 is a JFrame
	// 선언부
	String header[] = { "부서번호", "부서명", "지역" };
	String datas[][] = new String[0][3];
	// this는 사용되는 클래스 영역에서 선언된 클래스를 가리킨다
	// 그러면 여기서는 DeptTable1타입인 것임
	// 그런데 DefaultTableModel은 자바에서 제공되는 클래스임-생성자도 정해져 있음
	// 생성자는 메소드 오버로딩 규칙을 따름 - 파라미터의 갯수나 타입이 달라야 함
	// 제공되는 생성자에 없음 - 결국 사용 못함 - 컴파일 에러(문법에러 발생)
	DefaultTableModel dtm_dept = new DefaultTableModel(datas, header);// 생성자 호출
	JTable jtb_dept = new JTable(dtm_dept);
	JScrollPane jsp_dept = new JScrollPane(jtb_dept
	, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
	, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//버튼을 붙일 속지 선언
	JPanel jp_north = new JPanel();
	JButton jbtn_sel = new JButton("조회");
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	// 생성자
	public DeptTable1() {
		initDisplay();
	}

	// 화면그리기
	public void initDisplay() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp_north.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jbtn_sel.setBackground(new Color(158, 9, 9));
		jbtn_sel.setForeground(Color.WHITE);
		jbtn_ins.setBackground(new Color(19, 99, 57));
		jbtn_ins.setForeground(Color.WHITE);
		jbtn_upd.setBackground(new Color(54, 54, 54));
		jbtn_upd.setForeground(Color.WHITE);
		jbtn_del.setBackground(new Color(7, 84, 170));
		jbtn_del.setForeground(Color.WHITE);
		jp_north.add(jbtn_sel);
		jp_north.add(jbtn_ins);
		jp_north.add(jbtn_upd);
		jp_north.add(jbtn_del);
		this.add("North", jp_north);
		this.add("Center", jsp_dept);
		this.setTitle("부서관리시스템 Ver1.0");
		this.setSize(500, 400);
		this.setVisible(true);
	}

	// 메인메소드
	public static void main(String[] args) {
		new DeptTable1();
	}
}
