package ch05.aobject3;

import ch05.aobject.MemberVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class JTableDemo {
    JFrame          jf              = new JFrame();
    MemberVO[]      mvos            = new MemberVO[3];
    JPanel          jp_north        = new JPanel();
    String          cols[]          = {"아이디","이름","나이"};
    String          data[][]        = new String[30][3];
    DefaultTableModel dtm_member    = new DefaultTableModel(data,cols);
    //JTable은 양식(폼) - <table> - JTable이 데이터를 가질 수 없음
    //테이블구조를 그려주는 클래스와 데이터셋을 만들어주는 클래스가 분리됨
    JTable          jtb_member      = new JTable(dtm_member);
    JTableHeader    header          = jtb_member.getTableHeader();
    JScrollPane     jsp_member      = new JScrollPane(jtb_member);
    JButton         jbtn_all        = new JButton("전체조회");
    public JTableDemo(){
        initDisplay();
    }
    public void initDisplay(){
        jf.add("North",jbtn_all);
        jf.add("Center",jsp_member);
        jf.setSize(500,400);
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JTableDemo jtd = new JTableDemo();
    }
}
