package dev_java.tables;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//JDialog도 디폴트가 BorderLayout임 - jp_center 를 중앙배치
public class JTable7Dialog extends JDialog implements ActionListener {
	// 선언부
	DeptTable7 deptTable7 = null;
	JPanel jp_center = new JPanel();
	JScrollPane jsp_center = new JScrollPane(jp_center);
	JPanel jp_south = new JPanel();
	JLabel jlb_deptno = new JLabel("부서번호");
	JTextField jtf_deptno = new JTextField(10);
	JLabel jlb_dname = new JLabel("부서명");
	JTextField jtf_dname = new JTextField(20);
	JLabel jlb_loc = new JLabel("지역");
	JTextField jtf_loc = new JTextField(20);
	// jp_south 속지
	JButton jbtn_save = new JButton("저장");
	JButton jbtn_close = new JButton("닫기");
	//왜 null을 주는지 설명할 수 있다
	String[] oneRow = null;
	// 생성자
	public JTable7Dialog() {
	}
	
	public JTable7Dialog(DeptTable7 deptTable7) {
		this.deptTable7 = deptTable7;
		initDisplay();
	}

	// 화면그리기
	public void initDisplay() {
		jbtn_save.addActionListener(this);
		jbtn_close.addActionListener(this);
		jp_center.setLayout(null);
		jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jlb_deptno.setBounds(20, 20, 100, 20);
		jtf_deptno.setBounds(120, 20, 100, 20);
		jlb_dname.setBounds(20, 45, 100, 20);
		jtf_dname.setBounds(120, 45, 150, 20);
		jlb_loc.setBounds(20, 70, 100, 20);
		jtf_loc.setBounds(120, 70, 150, 20);
		jp_center.add(jlb_deptno);
		jp_center.add(jtf_deptno);
		jp_center.add(jlb_dname);
		jp_center.add(jtf_dname);
		jp_center.add(jlb_loc);
		jp_center.add(jtf_loc);
		jp_south.add(jbtn_save);
		jp_south.add(jbtn_close);
		this.add("Center", jsp_center);
		this.add("South", jp_south);
		this.setSize(400, 360);
		this.setVisible(false);
	}

	//각 컬럼(부서집합-부서번호,부서명,지역)의 값들을설정하거나
	//읽어오는 getter/setter메소드 임
	public String getDeptno(){
		return jtf_deptno.getText();
	}
	public void setDeptno(String deptno){
		jtf_deptno.setText(deptno);
	}
	public String getDname(){
		return jtf_dname.getText();
	}
	public void setDname(String dname){
		jtf_dname.setText(dname);
	}
	public String getLoc(){
		return jtf_loc.getText();
	}
	public void setLoc(String loc){
		jtf_loc.setText(loc);
	}
	//아래 메소드는 DeptTable7에서 호출됨
	//actionPerformed에서 이벤트(입력,수정,상세보기)가 발생되면 호출됨
	//메소드의 파라미터 자리는 Call by Value에 의해서 결정됨
	public void set(String title, boolean isView, String[] oneRow){
		this.setTitle(title);
		this.setVisible(isView);
		this.oneRow = oneRow;
		setValue(oneRow);
	}
	public void setValue(String[] oneRow){//이런 공통코드를 나는 작성할 수 있다.
		//입력을 위한 윈도우 설정 - 모든 값을 빈문자열로 셋팅함
		if(oneRow == null){
			setDeptno("");
			setDname("");
			setLoc("");
		}
		//상세조회, 수정시는 배열로 받은 값으로 셋팅함
		//부모창에서 set메소드 호출시 파라미터로 넘겨준 값으로 초기화할것.
		else{
			setDeptno(oneRow[0]);
			setDname(oneRow[1]);
			setLoc(oneRow[2]);
		}
	}//end of setValue

	// 메인
	public static void main(String[] args) {
		new JTable7Dialog(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_save){
			//oneRow가 존재하면 수정모드, 그렇지 않으면 입력모드로 함
			if(oneRow !=null){

			}else{
				String[] oneRow = { getDeptno(), getDname(), getLoc()};
				System.out.println(oneRow[0]+", "+oneRow[1]+", "+oneRow[2]);
				System.out.println("before : "+DeptTable7.vdata.size());
				DeptTable7.vdata.add(oneRow);
				System.out.println("after : "+DeptTable7.vdata.size());
				deptTable7.refreshData();
				this.dispose();
			}
		}
		
	}

}
