package anet.mvc.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ParentJFrame extends JFrame implements ActionListener {
    JPanel  jp_north = new JPanel();
    JButton btn_insert = new  JButton("입력");
    JButton btn_update = new  JButton("수정");
    JButton btn_delete = new  JButton("삭제");
    JButton btn_select = new  JButton("조회");
    JButton btn_detail = new  JButton("상세조회");
    JScrollPane jsp_center = new JScrollPane();
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        //입력 버튼 클릭 되었을 때
        if (source == btn_insert) {
            System.out.println("입력");
        }//end of 입력

        //수정 버튼 클릭 되었을 때
        else if (source == btn_update) {
            System.out.println("수정");

        }//end of 수정
        //상세조회 버튼 클릭 되었을 때
        else if (source == btn_detail) {
            System.out.println("상세조회");

        }//end of 상세조회
        //삭제 버튼 클릭 되었을 때
        //조회 버튼 클릭 되었을 때

    }//end of actionPerformed
    public void initDisplay() {
        btn_insert.addActionListener(this);
        btn_update.addActionListener(this);
        btn_delete.addActionListener(this);
        btn_select.addActionListener(this);
        btn_detail.addActionListener(this);
        jp_north.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jp_north.add(btn_insert);
        jp_north.add(btn_update);
        jp_north.add(btn_delete);
        jp_north.add(btn_select);
        jp_north.add(btn_detail);
        this.add("North", jp_north);
        this.add("Center",jsp_center);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
        ChildJDialog childJDialog = new ChildJDialog(this);
        childJDialog.initDisplay();
    }//end of initDisplay

    public static void main(String[] args) {
        ParentJFrame frame = new ParentJFrame();
        frame.initDisplay();
    }//end of main
}
