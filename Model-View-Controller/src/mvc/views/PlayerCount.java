package mvc.views;

import javax.swing.*;

import mvc.controllers.*;
import mvc.models.*;

import java.awt.*;
import java.awt.event.*;

public class PlayerCount extends JPanel {

	/**
	 * Create the panel.
	 */
	public PlayerCount(World world, JFrame home) {
				setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
				JLabel lblPlayerCount = new JLabel("How many players?");
				add(lblPlayerCount);

		JTextField playerCount = new JTextField(String.valueOf(world.getPlayerCount()));
		add(playerCount);
		playerCount.setColumns(5);

		JLabel lblToolCount = new JLabel("Starting # of tools?");
		add(lblToolCount);

		JTextField toolCount = new JTextField(String.valueOf(world.getToolCount()));
		add(toolCount);
		toolCount.setColumns(5);

		JButton btnDone = new JButton("Get creatin'");
		
		btnDone.addActionListener(new PlayerCountController(world, home, playerCount, toolCount));
		add(btnDone);

	}
}
