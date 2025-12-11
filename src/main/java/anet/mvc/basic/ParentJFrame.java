package anet.mvc.basic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ParentJFrame extends JFrame implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void initDisplay() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
/*        this.addWindowListener(new  WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });*/
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
