package anet.step2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import static util.CustomLogger.logger;

public class AppleZipCodeV2 extends JFrame implements ActionListener
        , ItemListener, FocusListener, MouseListener {
    //선언부
    String zdo = null;
    //물리적으로 떨어져 있는 db서버와 연결통로 만들기
    Connection con 	= null;
    //위에서 연결되면 쿼리문을 전달할 전령의 역할을 하는 인터페이스 객체 생성하기
    PreparedStatement pstmt 	= null;
    //조회된 결과를 화면에 처리해야 하므로 오라클에 커서를 조작하기 위해 ResultSet추가
    ResultSet rs 		= null;
    JPanel jp_north = new JPanel();
    Vector<String> vzdos = new Vector<>();//vzdos.size()==>0
    //JComboBox jcb_zdo = new JComboBox(zdos);//West
    JComboBox jcb_zdo = null;//West
    JTextField jtf_search = new JTextField("동이름을 입력하세요.");//Center
    JButton jbtn_search = new JButton("조회");//East
    String cols[] = {"우편번호","주소"};
    String data[][] = new String[0][2];
    DefaultTableModel dtm_zipcode = new DefaultTableModel(data,cols);
    JTable jtb_zipcode = new JTable(dtm_zipcode);
    JTableHeader jth = jtb_zipcode.getTableHeader();
    JScrollPane jsp_zipcode = new JScrollPane(jtb_zipcode
            ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
            ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    String zdos[] = null;//new String[]{"서울","경기","인천"};
    AppleDao appleDao = new AppleDao();//디폴트 생성자로 변경함.
    public AppleZipCodeV2() {
        //화면이 열리자 마자 시도 정보를 가져와서 JComboBox데이터셋 초기화
        zdos = appleDao.getZdoList();
        //logger(zdos3.length);//17출력
    }
    //zdo는 콤보박스에서 item을 클릭했을 때(즉 상태값이 변경되었을 때)
    public void refreshData(String zdo, String dong){
        logger("zdo:"+zdo+", dong:"+dong);
        try{
            //검색버튼이거나 또는 동입력 후 엔터 쳤을 때 호출하기
            ZipCodeVO[] zvos = appleDao.getAddress(zdo,dong);
            //JTable에 출력된 결과 초기화
            while (dtm_zipcode.getRowCount() > 0) {
                dtm_zipcode.removeRow(0);
            }//end of while

            //조회된 결과를 DefaultTableModel에 매칭하기
            for (int x = 0; x < zvos.length; x++) {
                //벡터 생성하기
                Vector<Object> oneRow = new Vector<>();
                oneRow.add(0, zvos[x].getZipcode());
                oneRow.add(1, zvos[x].getAddress());
                dtm_zipcode.addRow(oneRow);
            }//end of for

        }catch(Exception ex){
            logger(ex.getMessage());
        }
    }//end of refreshData
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == jbtn_search || obj == jtf_search) {
            String dong = jtf_search.getText();
            //메서드 중심의 코딩하기 연습
            //메서드 호출할 수 있다.(파라미터 갯수와 타입 맞추기 포함)
            refreshData(zdo, dong);
        }
    }//end of actionPerformed
    //동이름을 입력하는 컴포넌트에 클릭을 하면-> 포커스를 얻으면
    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource() == jtf_search){
            jtf_search.setText("");
        }
    }
    @Override
    public void focusLost(FocusEvent e) {
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        Object obj = e.getSource();
        if(obj == jcb_zdo) {
            //여기서 사용자가 선택한 시도 정보가 초기화됨.
            if(e.getStateChange() == ItemEvent.SELECTED) {
                //zdo = "서울", "경기", "인천",,,,,
                zdo = zdos[jcb_zdo.getSelectedIndex()];//서울,경기, 부산,,,,
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        AppleZipCodeV2 appleZipCode = new AppleZipCodeV2();
        appleZipCode.initDisplay();
    }
    //화면처리부
    public void initDisplay() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jtb_zipcode.requestFocus();
        jtb_zipcode.addMouseListener(this);
        jbtn_search.addActionListener(this);
        jtf_search.addFocusListener(this);
        jtf_search.addActionListener(this);
        jp_north.setLayout(new BorderLayout());
        jcb_zdo = new JComboBox(zdos);//West
        jcb_zdo.addItemListener(this);
        jp_north.add("West",jcb_zdo);
        jp_north.add("Center",jtf_search);
        jp_north.add("East",jbtn_search);
        this.add("North",jp_north);
        this.add("Center",jsp_zipcode);
        this.setTitle("우편번호 검색");
        this.setSize(430, 400);
        this.setVisible(true);
    }
}
