package dev_java.address;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Vector;

public class AddressBook implements ActionListener {
	// 선언부
	// 이미지 경로 선언
	String imgPath = "E:\\vscode_java\\dev_java\\app\\src\\main\\java\\dev_java\\images\\address\\";
	// 툴바 및 타이틀 이미지설정
	ImageIcon titlIcon = new ImageIcon(imgPath + "memo.png");
	JToolBar jtb = new JToolBar();
	JFrame jf_addr = new JFrame();
	// 메뉴바 구성하기 시작
	JMenuBar jmb = new JMenuBar();
	JMenu jm_file = new JMenu("File");
	JMenuItem jmi_db = new JMenuItem("DB연동확인");
	JMenuItem jmi_all = new JMenuItem("전체조회");
	JSeparator js_exit = new JSeparator();
	JMenuItem jmi_exit = new JMenuItem("종료");
	JMenu jm_edit = new JMenu("Edit");
	JMenuItem jmi_ins = new JMenuItem("입력");
	JMenuItem jmi_upd = new JMenuItem("수정");
	JMenuItem jmi_del = new JMenuItem("삭제");
	JMenuItem jmi_read = new JMenuItem("상세보기");
	// 메뉴바 구성하기 끝
	JButton jbtn_del = new JButton();
	JButton jbtn_ins = new JButton();
	JButton jbtn_upd = new JButton();
	JButton jbtn_read = new JButton();
	// BorderLayout중앙에 테이블(주소록 목록) 추가하기
	// JTable Header에 들어갈 문자열 선언
	String[] header = { "번호", "이름", "H.P" };
	// JTable은 양식만 제공할 뿐이고 데이터를 담을 클래스는 별도로 필요함
	String[][] datas = new String[3][3];
	// JTable에 들어갈 실제 데이터셋을 관리할 수 있는 클래스 선언함.
	// JTable에 보여지는 실제 데이터는 DefaultTableModel클래스를 통해 제어 해야 함을 의미
	DefaultTableModel dtm_addr = new DefaultTableModel(datas, header);
	// 데이터셋을 JTable생성시 파라미터로 매칭하기
	JTable jtb_addr = new JTable(dtm_addr);
	// DefaultTableModel의 로우수가 많아지는 경우 스크롤바 추가해야 함.
	// JScrollPane은 스크롤바를 품고 있는 일종의 속지로 생각함
	// 첫번째 파라미터는 양식을 가진 JTable이고 두번째는 수직 스크롤바 정책을 세번째는 수평스크롤바 정책을
	// 정해줌
	JScrollPane jsp_addr = new JScrollPane(jtb_addr, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	AddressDialog aDialog = new AddressDialog();

	// 생성자
	public AddressBook() {
		initDisplay();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jmi_all) {// 전체조회-검색
			String members[][] = {
					{ "1", "이순신", "010-555-3434" }, { "2", "강감찬", "010-676-9988" }, { "3", "김춘추", "010-234-7766" }
			};
			// 이미 테이블에 조회된 정보가 있는 경우 모두 삭제함
			while (dtm_addr.getRowCount() > 0) {
				dtm_addr.removeRow(0);
			}
			for (int i = 0; i < members.length; i++) {
				Vector<String> oneRow = new Vector<>();
				oneRow.add(members[i][0]);
				oneRow.add(members[i][1]);
				oneRow.add(members[i][2]);
				dtm_addr.addRow(oneRow);
			}
			// 익명 클래스 문법사용 - 자바 람다식, 자바스크립트 Arrow Function문법과 유사, 코틀린 문법
			jsp_addr.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
				public void adjustmentValueChanged(AdjustmentEvent e) {
					JScrollBar jsb = (JScrollBar) e.getSource();
					jsb.setValue(jsb.getMaximum());
				}
			});

		} else if (obj == jbtn_ins) {// 너 입력버튼 누른거야?
			aDialog.setDialog(jbtn_ins.getText(), true);
		} else if (obj == jbtn_upd) {// 너 수정할거니?
			aDialog.setDialog(jbtn_upd.getText(), true);
		} else if (obj == jbtn_read) {// 너 상세보기 하려구?
			aDialog.setDialog(jbtn_read.getText(), true);
		}

	}

	// 화면 처리부
	public void initDisplay() {
		jm_file.setMnemonic('F');
		jm_edit.setMnemonic('E');
		jbtn_ins.setIcon(new ImageIcon(imgPath + "new.gif"));
		jbtn_ins.setToolTipText("입력");
		jbtn_upd.setIcon(new ImageIcon(imgPath + "update.gif"));
		jbtn_upd.setToolTipText("수정");
		jbtn_del.setIcon(new ImageIcon(imgPath + "delete.gif"));
		jbtn_del.setToolTipText("삭제");
		jbtn_read.setIcon(new ImageIcon(imgPath + "detail.gif"));
		jbtn_read.setToolTipText("상세보기");
		jtb.add(jbtn_ins);
		jtb.add(jbtn_upd);
		jtb.add(jbtn_del);
		jtb.add(jbtn_read);
		jmi_all.addActionListener(this);// 이벤트소스와 이벤트 핸들러 클래스 매칭
		jbtn_del.addActionListener(this);// 이벤트소스와 이벤트 핸들러 클래스 매칭
		jbtn_ins.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_read.addActionListener(this);
		// 창닫기 버튼 클릭시 종료처리
		jf_addr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf_addr.add("North", jtb);
		jf_addr.add("Center", jsp_addr);
		jf_addr.setTitle("주소록 Ver1.0");
		jmb.add(jm_file);
		jm_file.add(jmi_db);
		jm_file.add(jmi_all);
		jm_file.add(js_exit);
		jm_file.add(jmi_exit);
		jmb.add(jm_edit);
		jm_edit.add(jmi_ins);
		jm_edit.add(jmi_upd);
		jm_edit.add(jmi_del);
		jm_edit.add(jmi_read);
		jf_addr.setJMenuBar(jmb);
		jf_addr.setSize(500, 450);
		jf_addr.setVisible(true);
	}

	// 메인메소드
	public static void main(String[] args) {
		// 스윙스킨 입히기
		JFrame.setDefaultLookAndFeelDecorated(true);
		new AddressBook();
	}

}
