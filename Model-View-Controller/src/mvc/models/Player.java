package mvc.models;

import java.util.*;

import javax.swing.*;

public class Player {

	protected Vector<Tool> rucksack;
	protected String name;
	
	public Player() {
		rucksack = new Vector<Tool>();
	}
	
	public static boolean validateName(String name) {
		return validateName(name, null);
	}
	
	public static boolean validateName(String name, JFrame home) {
		if (name.length() > 0) {
			return true;
		} else {
			JOptionPane.showMessageDialog(home,
					"Please enter a name for your player.", "Try again",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public String setName(String newName) {
		String oldName = name;
		if (validateName(newName)) {
			name = newName;
		}
		return oldName;
	}
	
	public String getName() {
		return name;
	}

	public boolean addTool(Tool tool) {
		if (!rucksack.contains(tool)) {
			rucksack.add(tool);
			return true;
		}
		return false;
	}
	
	public boolean removeTool(Tool tool) {
		if (rucksack.contains(tool)) {
			rucksack.remove(tool);
			return true;
		}
		return false;
	}
	
	public Vector<Tool> getRucksack() {
		return rucksack;
	}
}
