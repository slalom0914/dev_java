package dev_java.tables;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

//이른인스턴스화 , 게으른 인스턴스화
//어떤 클래스를 상속 받을 때에는 extends예약어를 사용
//A is a B관계이면 상속으로 처리한다.
//소나타는 자동차 이다.
//자동차는 소나타 이다.
//부모클래스가 가진 변수와 메소드도 사용가능함 - 자손이 더 많이 누릴 수 있다
//ActionListener - 인터페이스 - 단독으로 인스턴스화가 불가함 -  구현체 클래스가 필요함
//추상메소드를 선언하고 있다.
// ActionListener al = new DeptTable3(); 선언부와 생성부가 다를 수 있다.-  이럴때만  다형성이 가능함
//선언부와 생성부가 다르다 - 동일한 메소드를 호출했는데 다른 기능이 처리되었다?????
//추상클래스도 구현체 클래스가 필요하다 - this
//Duck myDuck = new WoodDuck(); myDuck.fly()
//Duck herDuck = new RubberDuck();herDuck.fly()
//Duck himDuck = new MallardDuck();himDuck.fly()
public class DeptTable3 extends JFrame implements ActionListener {// DeptTable1 is a JFrame
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
	JScrollPane jsp_dept = new JScrollPane(jtb_dept, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	// 버튼을 붙일 속지 선언
	JPanel jp_north = new JPanel();
	JButton jbtn_sel = new JButton("조회");
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	// 부서목록 조회에 들어갈 샘플 데이터 생성
	String[][] depts = {
			{ "10", "개발부", "서울" },
			{ "20", "인사부", "인천" },
			{ "30", "총무부", "부산" }
	};

	// 생성자
	public DeptTable3() {
		initDisplay();
	}

	// 화면그리기
	public void initDisplay() {
		jbtn_sel.addActionListener(this);
		jbtn_del.addActionListener(this);
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
		new DeptTable3();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jbtn_del) {
			int index = jtb_dept.getSelectedRow();
			System.out.println(index);
			Integer deptno = Integer.parseInt((String) dtm_dept.getValueAt(index, 0));
			System.out.println(deptno);
		} else if (obj == jbtn_sel) {// 너 조회버튼 누른거야?
			for (int x = 0; x < depts.length; x++) {
				Vector<String> oneRow = new Vector<>();
				oneRow.add(depts[x][0]);
				oneRow.add(depts[x][1]);
				oneRow.add(depts[x][2]);
				dtm_dept.addRow(oneRow);
			}
			for (int i = 0; i < depts.length; i++) {
				for (int j = 0; j < depts[i].length; j++) {
					// System.out.print(depts[i][j] + " ");// ln을 빼서 3개출력하고 줄바꿈처리
					dtm_dept.setValueAt("여기", 1, 1);
					System.out.println(dtm_dept.getValueAt(i, j));
				} // end of inner for
				System.out.println();
			} //// end of outter for
				// DefaultTableModel에 데이터 초기화 하기
		} /////// end of 조회 이벤트 끝
	}
}
