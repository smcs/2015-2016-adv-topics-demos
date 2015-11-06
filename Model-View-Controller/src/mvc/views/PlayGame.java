package mvc.views;

import javax.swing.*;

import mvc.models.*;

import java.awt.*;

public class PlayGame extends JPanel {

	/**
	 * Create the panel.
	 */
	public PlayGame(World world, JFrame home) {
		setBackground(Color.RED);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fun Game");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 72));
		lblNewLabel.setBounds(6, 6, 438, 288);
		add(lblNewLabel);

	}

}
