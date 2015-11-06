package mvc.controllers;

import java.awt.event.*;

import javax.swing.*;

import mvc.models.*;
import mvc.views.*;

public class PlayerCountController implements ActionListener {

	private World world;

	private JFrame home;
	private JTextField playerCount, toolCount;

	public PlayerCountController(World world, JFrame home,
			JTextField playerCount, JTextField toolCount) {
		this.world = world;
		this.home = home;
		this.playerCount = playerCount;
		this.toolCount = toolCount;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (World.validatePlayerCount(Integer.valueOf(playerCount.getText()))
				&& World.validateToolCount(Integer.valueOf(toolCount.getText()))) {
			world.setPlayerCount(Integer.valueOf(playerCount.getText()));
			world.setToolCount(Integer.valueOf(toolCount.getText()));
			JPanel next = new PlayerName(world, home);
			home.setContentPane(next);
			next.revalidate();
			next.repaint();

		}
	}
}
