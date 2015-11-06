package smcs.demos.HelloSwingingWorld;

import java.awt.event.*;

import javax.swing.JLabel;

public class ButtonListener implements ActionListener {
	
	private static int nextJerseyNumber = 1;
	
	private int myJerseyNumber;
	private int clickCount;
	private JLabel label;
	
	public ButtonListener(JLabel label) {
		myJerseyNumber = nextJerseyNumber++;
		clickCount = 0;
		this.label = label;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Ooo… don't click me!") {
			System.out.println("I told you not to do that!");
			System.exit(0);
		} else {
			clickCount++;
			label.setText(clickCount + " clicks");
			System.out.println(e.getActionCommand() + " happened (says listener #" + myJerseyNumber + ")");
		}
	}

}
