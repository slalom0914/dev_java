package anet.mvc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ModifyDialog extends JDialog {
    private JLabel labelName;
    private JTextField txtName;
    private JLabel labelAddr;
    private JTextField txtAddress;
    private JLabel labelTel;
    private JTextField txtTel;
    private JLabel labelRel;
    private JTextField txtRelationShip;
    private JLabel labelGender;
    private JComboBox comboGender;
    private JLabel labelBirth;
    private JTextField txtBirthDay;
    private JLabel labelComment;
    private JTextArea txtComment;
    private JLabel labelRegDate;
    private JTextField txtRegDate;
    private JScrollPane scrollPane;
    private JScrollPane scrollComment;
    private JPanel panel;
    private JPanel panelBtn;
    private Font font;

    private Frame parent;
    private String title;

    private JButton btnOk;
    private JButton btnCancel;
    public static void main(String[] args) {
        ModifyDialog modifyDialog = new ModifyDialog();
        modifyDialog.initDisplay();
    }
    private void initDisplay() {
        labelName = new JLabel("이름(필수입력) ");
        labelAddr = new JLabel("주소 ");
        labelTel = new JLabel("전화번호 ");
        labelRel = new JLabel("관계 ");
        labelGender = new JLabel("성별 ");
        labelBirth = new JLabel("생일(YYYYMMDD) ");
        labelComment = new JLabel("비고 ");
        labelRegDate = new JLabel("수정일 ");

        labelName.setFont(font);
        labelAddr.setFont(font);
        labelTel.setFont(font);
        labelRel.setFont(font);
        labelGender.setFont(font);
        labelBirth.setFont(font);
        labelComment.setFont(font);
        labelRegDate.setFont(font);

        txtName = new JTextField(20);
        txtAddress = new JTextField(20);
        txtTel = new JTextField(20);
        txtRelationShip = new JTextField(20);
        txtBirthDay = new JTextField(20);
        txtComment = new JTextArea(3, 20);
        scrollComment = new JScrollPane(txtComment);
        txtRegDate = new JTextField(20);

        String [] genderList= {"남자", "여자"};
        comboGender = new JComboBox(genderList);

        btnOk= new JButton("확인");
        btnOk.setFont(font);
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("확인");
            }
        });

        btnCancel = new JButton("취소");
        btnCancel.setFont(font);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("취소");
            }
        });

        panel = new JPanel();
        panel.setLayout(null);

        labelName.setBounds(20,20, 100,20);
        txtName.setBounds(120,20, 150,20);

        labelAddr.setBounds(20, 45, 100,20);
        txtAddress.setBounds(120,45, 150,20);

        labelTel.setBounds(20,70, 100,20);
        txtTel.setBounds(120,70, 150, 20);

        labelRel.setBounds(20,95, 100,20);
        txtRelationShip.setBounds(120,95, 150,20);

        labelGender.setBounds(20,120, 100,20);
        comboGender.setBounds(120, 120, 150,20);
        comboGender.setFont(new java.awt.Font("±¼¸²", 0, 12));

        labelBirth.setBounds(20,145, 100,20);
        txtBirthDay.setBounds(120,145, 150,20);

        labelComment.setBounds(20, 170, 100,20);
        scrollComment.setBounds(120,170, 250,60);

        labelRegDate.setBounds(20, 235, 100,20);
        txtRegDate.setBounds(120,235, 150,20);
        txtRegDate.setEditable(false);
        panel.add(labelName);
        panel.add(txtName);
        panel.add(labelAddr);
        panel.add(txtAddress);
        panel.add(labelTel);
        panel.add(txtTel);
        panel.add(labelRel);
        panel.add(txtRelationShip);
        panel.add(labelGender);
        panel.add(comboGender);
        panel.add(labelBirth);
        panel.add(txtBirthDay);
        panel.add(labelComment);
        panel.add(scrollComment);
        panel.add(labelRegDate);
        panel.add(txtRegDate);

        panel.add(btnOk);
        panel.add(btnCancel);

        panelBtn= new JPanel();

        panelBtn.add(btnOk);
        panelBtn.add(btnCancel);

        scrollPane = new JScrollPane(panel);

        setTitle(title);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panelBtn, BorderLayout.SOUTH);

        setSize(430,400);
        setVisible(true);
    }

}
