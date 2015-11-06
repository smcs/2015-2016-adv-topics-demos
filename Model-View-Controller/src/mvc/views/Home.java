package mvc.views;

import java.awt.*;

import javax.swing.*;

import mvc.models.*;

public class Home extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					World world = new World();
					Home frame = new Home(world);
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
	public Home(World world) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel playerCount = new PlayerCount(world, this);
		setContentPane(playerCount);
	}
}
