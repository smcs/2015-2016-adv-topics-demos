package smcs.demo.Dominos.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import smcs.demo.Dominos.controller.Controller;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AppWindow extends JFrame {

	private JPanel contentPane;
	private JTextField address;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow frame = new AppWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel instructions = new JLabel("Please enter the address for your order.");
		instructions.setBounds(26, 27, 262, 16);
		contentPane.add(instructions);
		
		address = new JTextField();
		address.setText("address");
		address.setBounds(26, 55, 262, 28);
		contentPane.add(address);
		address.setColumns(10);
		
		JButton order = new JButton("Place Order");
		order.setBounds(26, 95, 117, 29);
		Controller controller = new Controller(instructions, address);
		order.addActionListener(controller);
		contentPane.add(order);
	}
}
