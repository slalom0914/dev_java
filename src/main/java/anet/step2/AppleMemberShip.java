package anet.step2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppleMemberShip extends JDialog implements ActionListener {
    //선언부
    JPanel jp_center = new JPanel();
    JLabel jlb_id = new JLabel("아이디");
    JTextField jtf_id = new JTextField(10);
    JLabel jlb_pw = new JLabel("패스워드");
    JTextField jtf_pw = new JTextField(10);
    JLabel jlb_nickName = new JLabel("대화명");
    JTextField jtf_nickName = new JTextField(20);
    JLabel jlb_name = new JLabel("성명");
    JTextField jtf_name = new JTextField(30);
    JLabel jlb_gender = new JLabel("성별");
    String[] genderList = {"남자","여자"};
    JComboBox jcb_gender = new JComboBox(genderList);
    JLabel 		jlb_zipcode = new JLabel("우편번호");
    public JTextField 	jtf_zipcode = new JTextField(6);
    JLabel 		jlb_address = new JLabel("주소");
    public JTextField 	jtf_address = new JTextField(100);
    JButton     jbtn_zipcode = new JButton("우편번호찾기");
    JScrollPane jsp = null;
    JPanel jp_south = new JPanel();
    JButton jbtn_ins = new JButton("등록");
    JButton jbtn_close = new JButton("닫기");
    AppleZipCodeV2 azc = new AppleZipCodeV2(this);
    public AppleMemberShip() {
        initDisplay();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == jbtn_zipcode){
            //우편번호 검색창 열기
            azc.initDisplay();
        }
    }//end of actionPerformed
    public static void main(String[] args) {
        AppleMemberShip appleMemberShip = new AppleMemberShip();
        appleMemberShip.initDisplay();
    }
    // 각 컬럼의 값들을 설정하거나 읽어오는 getter/setter 메쏘드입니다.
    public String getId() { return jtf_id.getText(); }
    public void setId(String strId) { jtf_id.setText(strId); }
    public String getPw() { return jtf_pw.getText(); }
    public void setPw(String strPw) { jtf_pw.setText(strPw); }
    public String getNickName() { return jtf_nickName.getText(); }
    public void setNickName(String strNickName) { jtf_nickName.setText(strNickName); }
    public String getName() { return jtf_name.getText(); }
    public void setName(String strName) { jtf_name.setText(strName); }
    public String getGender() { return jcb_gender.getSelectedItem().toString(); }
    public void setGender(String strGender) { jcb_gender.setSelectedItem(strGender); }
    public String getZipcode() { return jtf_zipcode.getText(); }
    public void setZipcode(String strZipcode) { jtf_zipcode.setText(strZipcode); }
    public String getAddress() { return jtf_address.getText(); }
    public void setAddress(String strAddress) { jtf_address.setText(strAddress); }
    //화면처리부
    public void initDisplay() {
        jbtn_zipcode.addActionListener(this);
        jbtn_ins.addActionListener(this);
        jp_center.setLayout(null);
        jlb_id.setBounds(20, 20, 100, 20);
        jtf_id.setBounds(120, 20, 120, 20);
        jlb_pw.setBounds(20, 45, 100, 20);
        jtf_pw.setBounds(120, 45, 120, 20);
        jlb_nickName.setBounds(20, 70, 100, 20);
        jtf_nickName.setBounds(120, 70, 150, 20);
        jlb_name.setBounds(20, 95, 100, 20);
        jtf_name.setBounds(120, 95, 150, 20);
        jlb_gender.setBounds(20, 120, 100, 20);
        jcb_gender.setBounds(120, 120, 150, 20);
        jcb_gender.setFont(new Font("굴림",1,14));
        jlb_zipcode.setBounds(20, 145, 100, 20);
        jtf_zipcode.setBounds(120, 145, 100, 20);
        jbtn_zipcode.setBounds(230, 145, 120, 20);
        jlb_address.setBounds(20, 170, 100, 20);
        jtf_address.setBounds(120, 170, 250, 20);
        jp_center.add(jlb_id);
        jp_center.add(jtf_id);
        jp_center.add(jlb_pw);
        jp_center.add(jtf_pw);
        jp_center.add(jlb_nickName);
        jp_center.add(jtf_nickName);
        jp_center.add(jlb_name);
        jp_center.add(jtf_name);
        jp_center.add(jlb_gender);
        jp_center.add(jcb_gender);
        jp_center.add(jlb_zipcode);
        jp_center.add(jtf_zipcode);
        jp_center.add(jbtn_zipcode);
        jp_center.add(jlb_address);
        jp_center.add(jtf_address);
        jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jp_south.add(jbtn_ins);
        jp_south.add(jbtn_close);
        this.add("South",jp_south);
        jsp = new JScrollPane(jp_center);
        this.add("Center",jsp);
        this.setTitle("회원가입");
        this.setSize(400, 500);
        this.setVisible(true);
    }
}
