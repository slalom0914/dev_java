package ch06;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MemberTable {
    //선언부
    //JFrame은 디폴트 레이아웃이 BorderLayout- 동,서,남,북,중앙
    JFrame jf = new JFrame();
    JPanel jp = new JPanel();//FlowLayout
    String[][] data = new String[0][3];
    String[] cols = new String[]{"아이디","이름","나이"};
    DefaultTableModel model = new DefaultTableModel(data,cols);
    JTable jt = new JTable(model);
    JScrollPane jsp =
            new JScrollPane
                    (jt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
                            ,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    JButton btn_select = new JButton("조회");
    JButton btn_insert = new JButton("입력");
    JButton btn_update = new JButton("수정");
    JButton btn_delete = new JButton("삭제");
    //생성자
    public MemberTable(){
        initDisplay();
    }
    //화면처리부
    public void initDisplay(){
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jp.setBackground(Color.orange);
        jp.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jp.add(btn_select);
        jp.add(btn_insert);
        jp.add(btn_update);
        jp.add(btn_delete);
        jf.add("North",jp);
        jf.add("Center",jsp);
        jf.setSize(400,400);
        jf.setVisible(true);
    }
    //main
    public static void main(String[] args) {
        MemberTable mt = new MemberTable();
    }
}
