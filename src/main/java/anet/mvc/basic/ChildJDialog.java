package anet.mvc.basic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChildJDialog extends JDialog implements ActionListener {
    public ChildJDialog(JFrame owner) {
        super(owner, "Child JDialog", false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void initDisplay() {
        this.setSize(300, 300);
        this.setVisible(true);
        //this.dispose();

    }
    public static void main(String[] args) {
        //ChildJDialog dialog = new ChildJDialog();
        //dialog.initDisplay();
    }
}
