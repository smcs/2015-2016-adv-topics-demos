package mvc.views;

import javax.swing.*;

import java.awt.*;

import mvc.controllers.*;
import mvc.models.*;

import java.awt.event.*;

public class InitialRucksack extends JPanel {

	/**
	 * Create the panel.
	 */
	public InitialRucksack(World world, JFrame home) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		InitialRucksackController controller = new InitialRucksackController(world, home);
		
		JLabel lblPlayerName = new JLabel(controller.getPlayer().getName() + "'s Rucksack");
		add(lblPlayerName);
		
		for (int i = 0; i < world.getToolCount(); i++) {
			JPanel item = new InitialRucksackItem(world, controller.getPlayer());
			add(item);
		}
		
		JButton btnDone = new JButton("Claim Tools");
		if (controller.getPlayerNumber() == world.getPlayerCount()) {
			btnDone.setText("Play Game");
		}
		btnDone.addActionListener(controller);
		add(btnDone);
		
	}
}
