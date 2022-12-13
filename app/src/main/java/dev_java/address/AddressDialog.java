package dev_java.address;

import javax.swing.JDialog;

public class AddressDialog {
	JDialog jdg = new JDialog();

	// System.exit(0); jf.dispose();
	public AddressDialog() {
		jdg.setSize(400, 300);
		jdg.setVisible(false);
	}
	//XXX.YYY.ZZZ.methodA();
	public void setDialog(String title, boolean isView){
		jdg.setTitle(title);
		jdg.setVisible(isView);
	}
	public static void main(String[] args) {
		new AddressDialog();
	}
}
