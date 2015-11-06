package smcs.demos.HelloSwingingWorld;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(51, 30, 117, 16);
		contentPane.add(lblNewLabel);

		ButtonListener listener = new ButtonListener(lblNewLabel);
		
		JButton btnNewButton = new JButton("Click me!");
		btnNewButton.setBounds(51, 54, 117, 29);
		btnNewButton.addActionListener(listener);
		contentPane.add(btnNewButton);
		
		JButton btnOooDontClick = new JButton("Ooo… don't click me!");
		btnOooDontClick.setBounds(155, 137, 174, 29);
		btnOooDontClick.addActionListener(listener);
		contentPane.add(btnOooDontClick);
		
	}
}
