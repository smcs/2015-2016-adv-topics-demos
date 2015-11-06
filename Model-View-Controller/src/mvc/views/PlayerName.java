package mvc.views;

import javax.swing.*;

import mvc.controllers.*;
import mvc.models.*;

import java.awt.*;
import java.awt.event.*;

public class PlayerName extends JPanel {

	/**
	 * Create the panel.
	 */
	public PlayerName(World world, JFrame home) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPlayerName = new JLabel("Player __ Name");
		add(lblPlayerName);

		JTextField playerName = new JTextField();
		add(playerName);
		playerName.setColumns(10);

		PlayerNameController controller = new PlayerNameController(world, home, playerName);
		lblPlayerName.setText("Player " + controller.getPlayerNumber() + " Name");

		JButton btnDone = new JButton("Next Player");
		if (controller.getPlayerNumber() == world.getPlayerCount()) {
			btnDone.setText("Fill Rucksacks");
		}
		btnDone.addActionListener(controller);
		add(btnDone);
	}
}
