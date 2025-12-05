package ch06;

import javax.swing.*;

public class MemberTable {
    //선언부
    JFrame jf = new JFrame();
    JPanel jp = new JPanel();
    JTable jt = new JTable();
    JScrollPane jsp = new JScrollPane(jt);
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
