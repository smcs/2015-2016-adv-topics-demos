package mvc.controllers;

import java.awt.event.*;

import mvc.models.*;

public class InitialRucksackItemController implements ItemListener {
	private World world;
	private Player player;
	private Tool tool;
	
	public InitialRucksackItemController(World world, Player player) {
		this.world = world;
		this.player = player;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (tool != null) {
			player.removeTool(tool);
			world.addTool(tool);
		}
		
		tool = (Tool) e.getItem();
		world.removeTool(tool);
		player.addTool(tool);
	}
}
