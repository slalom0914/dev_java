package dev_java.ch01;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JFrameTest extends JFrame {
  public static void main(String[] args) {
    String my = JOptionPane.showInputDialog(JFrame.class, "숫자를 입력하세요");
    System.out.println(my);
  }
}
