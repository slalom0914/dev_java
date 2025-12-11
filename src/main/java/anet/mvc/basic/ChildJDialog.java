package anet.mvc.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChildJDialog extends JDialog implements ActionListener {
    JButton btn_ok = new JButton("확인");
    JButton btn_cancel = new JButton("취소");
    JScrollPane jsp = new JScrollPane();
    JPanel jp_south = new JPanel();
    ParentJFrame pj = null;
    public ChildJDialog() {}
    public ChildJDialog(JFrame owner) {
        super(owner, "Child JDialog", false);
        //아래 낱말카드를 쓸 수 있다.
        pj = (ParentJFrame) owner;
        initDisplay();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        //확인버튼을 누른거야
        if(obj == btn_ok){
            pj.refresh();
        }
    }
    public void initDisplay() {
        btn_ok.addActionListener(this);
        this.setTitle("입력|수정|상세보기");
        jp_south.setLayout(new FlowLayout(FlowLayout.CENTER));
        jp_south.add(btn_ok);
        jp_south.add(btn_cancel);
        this.add("South", jp_south);
        this.add("Center", jsp);
        this.setSize(300, 300);
        this.setVisible(false);
        //this.dispose();

    }
    public static void main(String[] args) {
        //ChildJDialog dialog = new ChildJDialog();
        //dialog.initDisplay();
    }
}
