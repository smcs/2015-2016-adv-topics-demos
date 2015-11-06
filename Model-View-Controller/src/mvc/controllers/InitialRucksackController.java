package mvc.controllers;

import java.awt.event.*;

import javax.swing.*;

import mvc.models.*;
import mvc.views.*;

public class InitialRucksackController implements ActionListener {
	private World world;
	private Player player;
	private JFrame home;
	private static int nextPlayerNumber = 0;

	public InitialRucksackController(World world, JFrame home) {
		this.world = world;
		this.home = home;

		player = world.getPlayer(nextPlayerNumber++);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (player.getRucksack().size() == world.getToolCount()) {
			JPanel next;
			if (nextPlayerNumber == world.getPlayerCount()) {
				next = new PlayGame(world, home);
			} else {
				next = new InitialRucksack(world, home);
			}
			home.setContentPane(next);
			next.revalidate();
			next.repaint();
		} else {
			JOptionPane.showMessageDialog(home, "You must choose " + world.getToolCount() + " tools.",
					"Keep working", JOptionPane.ERROR_MESSAGE);
		}
	}

	public Player getPlayer() {
		return player;
	}

	public int getPlayerNumber() {
		return nextPlayerNumber;
	}
}
