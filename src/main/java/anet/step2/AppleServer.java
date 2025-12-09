package anet.step2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppleServer extends JFrame implements Runnable {

    @Override
    public void run() {

    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
    }
    public void initDisplay(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
