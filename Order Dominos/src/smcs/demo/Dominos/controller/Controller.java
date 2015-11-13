package smcs.demo.Dominos.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import smcs.demo.Dominos.model.DominosOrder;

public class Controller implements ActionListener {

	private JLabel message;
	private JTextField address;
	private DominosOrder order;
	
	public Controller(JLabel message, JTextField address) {
		this.message = message;
		this.address = address;
		order = new DominosOrder();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (address.getText().length() > 0) {
			order.setAddress(address.getText());
			message.setText("order sent to " + order.sendOrder());
		} else {
			message.setText("No, really, enter an address.");
		}
	}

}
