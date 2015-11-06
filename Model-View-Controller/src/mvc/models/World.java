package mvc.models;

import java.util.*;

import javax.swing.*;

public class World {

	public static final int DEFAULT_PLAYER_COUNT = 2, DEFAULT_TOOL_COUNT = 3;

	private Vector<Player> players;
	private Vector<Tool> tools;
	private int playerCount, toolCount;

	public World() {
		players = new Vector<Player>();
		tools = new Vector<Tool>();
		setPlayerCount(DEFAULT_PLAYER_COUNT);
		setToolCount(DEFAULT_TOOL_COUNT);
	}

	public boolean addPlayer(Player p) {
		if (!players.contains(p)) {
			players.add(p);
			return true;
		}
		return false;
	}

	public Player getPlayer(int index) {
		if (index < players.size()) {
			return players.get(index);
		}
		return null;
	}

	public static boolean validatePlayerCount(int count) {
		return validatePlayerCount(count, null);
	}

	public static boolean validatePlayerCount(int count, JFrame home) {
		if (count > 0) {
			return true;
		} else {
			JOptionPane.showMessageDialog(home,
					"Please choose at least 1 tool.", "Try again",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public static boolean validateToolCount(int count) {
		return validateToolCount(count, null);
	}

	public static boolean validateToolCount(int count, JFrame home) {
		if (count > 0) {
			return true;
		} else {
			JOptionPane.showMessageDialog(home,
					"Please choose at least 1 player.", "Try again",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public int setPlayerCount(int newCount) {
		int oldCount = playerCount;
		if (validatePlayerCount(newCount)) {
			playerCount = newCount;
			expandToolSupply();
		}
		return oldCount;
	}

	private void expandToolSupply() {
		/* make sure that we have enough tools for all the players to pick 3 */
		if (tools.size() < playerCount * toolCount + 1) {
			for (int i = tools.size(); i < playerCount * toolCount + 1; i++) {
				addTool(new Tool("Tool " + (i + 1)));
			}
		}
	}

	public int getPlayerCount() {
		return playerCount;
	}

	public Vector<Tool> availableTools() {
		return tools;
	}

	public boolean addTool(Tool tool) {
		if (!tools.contains(tool)) {
			tools.add(tool);
			return true;
		}
		return false;
	}

	public boolean removeTool(Tool tool) {
		if (tools.contains(tool)) {
			tools.removeElement(tool);
			return true;
		}
		return false;
	}

	public int setToolCount(int newCount) {
		int oldCount = toolCount;
		if (validateToolCount(newCount)) {
			toolCount = newCount;
			expandToolSupply();
		}
		return oldCount;
	}

	public int getToolCount() {
		return toolCount;
	}
}
