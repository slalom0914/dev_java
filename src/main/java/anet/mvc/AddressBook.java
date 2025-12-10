package anet.mvc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddressBook extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu menuMenu;
    private JMenu menuAbout;
    private JMenuItem menuItemConnect;
    private JMenuItem menuItemInsert;
    private JMenuItem menuItemUpdate;
    private JMenuItem menuItemDelete;
    private JMenuItem menuItemDetail;
    private JMenuItem menuItemAbout;
    private JSeparator menuSeparator1;
    private JSeparator menuSeparator2;
    private JMenuItem menuItemExit;
    private JToolBar toolbar;
    private JButton btnInsert;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnDetail;
    private JScrollPane jScrollPane1;
    private JTable table;
    private DefaultTableModel dtm;
    private JPanel panelTimer;
    private JLabel labelTimer;

    private JOptionPane optionDlg;
    private ModifyDialog mDialog;
    private Font font;
    private String path;
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        AddressBook aBook = new AddressBook();
        aBook.initDisplay();
    }
    public void initDisplay() {
        menuBar = new JMenuBar();
        menuMenu = new JMenu();
        menuAbout= new JMenu();
        menuItemConnect= new JMenuItem();
        menuItemInsert = new JMenuItem();
        menuItemUpdate = new JMenuItem();
        menuItemDelete = new JMenuItem();
        menuItemDetail= new JMenuItem();
        menuItemAbout = new JMenuItem();
        menuSeparator1 = new JSeparator();
        menuSeparator2 = new JSeparator();
        menuItemExit = new JMenuItem();
        menuMenu.setText("메뉴");
        menuMenu.setFont(font);

        toolbar = new JToolBar();
        btnInsert = new JButton();
        btnInsert.setToolTipText("입력");
        btnUpdate = new JButton();
        btnUpdate.setToolTipText("수정");
        btnDelete = new JButton();
        btnDelete.setToolTipText("삭제");
        btnDetail = new JButton();
        btnDetail.setToolTipText("상세보기");
        jScrollPane1 = new JScrollPane();
        table = new JTable(dtm);
        labelTimer = new JLabel("현재시간");
        labelTimer.setFont(font);
        panelTimer = new JPanel();
        font= new Font("돋움",0, 12);
        path = "src//com//address//mvc//images//";
        optionDlg = new JOptionPane();
        mDialog = new ModifyDialog();
        mDialog.setVisible(false);
        menuItemConnect.setFont(font);
        menuItemConnect.setText("DB연결");
        menuItemConnect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("DB연결");
            }
        });
        menuItemDetail.setFont(font);
        menuItemDetail.setText("상세보기");
        menuItemDetail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("상세보기");
            }
        });

        menuItemInsert.setFont(font);
        menuItemInsert.setText("입력");
        menuItemInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("입력");
            }
        });
        menuItemUpdate.setFont(font);
        menuItemUpdate.setText("수정");
        menuItemUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("수정");
                AddressVO vo = new AddressVO();
            }
        });
        menuItemDelete.setFont(font);
        menuItemDelete.setText("삭제");
        menuItemDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("삭제");
            }
        });
        menuItemExit.setFont(font);
        menuItemExit.setText("종료");
        menuItemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("종료");
            }
        });
        menuMenu.add(menuItemConnect);
        menuMenu.add(menuSeparator1);
        menuMenu.add(menuItemDetail);
        menuMenu.add(menuItemInsert);
        menuMenu.add(menuItemUpdate);
        menuMenu.add(menuItemDelete);
        menuMenu.add(menuSeparator2);
        menuMenu.add(menuItemExit);
        menuBar.add(menuMenu);
        menuAbout.setFont(font);
        menuAbout.setText("About");
        menuItemAbout.setFont(font);
        menuItemAbout.setText("About");
        menuItemAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("About");
            }
        });
        menuAbout.add(menuItemAbout);
        menuBar.add(menuAbout);
        setJMenuBar(menuBar);
        setFont(font);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });

        btnDetail.setIcon(new ImageIcon(path+"detail.gif"));
        btnDetail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("상세보기");
            }
        });
        toolbar.add(btnDetail);
        toolbar.add(new JToolBar.Separator());

        btnInsert.setIcon(new ImageIcon(path+"new.gif"));
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("입력");
            }
        });
        toolbar.add(btnInsert);

        btnUpdate.setIcon(new ImageIcon(path+"update.gif"));
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("수정");
            }
        });
        toolbar.add(btnUpdate);

        btnDelete.setIcon(new ImageIcon(path+"delete.gif"));
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("삭제");
            }
        });
        toolbar.add(btnDelete);
        getContentPane().add(toolbar, java.awt.BorderLayout.NORTH);
        table.setFont(font);
        jScrollPane1.setViewportView(table);
        getContentPane().add(jScrollPane1, BorderLayout.CENTER);
        panelTimer.add(labelTimer);
        getContentPane().add(panelTimer, BorderLayout.SOUTH);
        this.setSize(300, 300);
        this.setVisible(true);

        try {
            refreshData();
        } catch (Exception e) {
            optionDlg.showMessageDialog(this, "DB ¿¬°á¿¡ ½ÇÆÐÇß½À´Ï´Ù.\n" + e,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void refreshData() throws Exception {

    }
}
