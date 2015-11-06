package mvc.views;

import javax.swing.*;

import mvc.controllers.*;
import mvc.models.*;

import java.awt.FlowLayout;

public class InitialRucksackItem extends JPanel {

	/**
	 * Create the panel.
	 */
	public InitialRucksackItem(World world, Player player) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox item = new JComboBox();
		item.setModel(new DefaultComboBoxModel(world.availableTools()));
		item.setSelectedIndex(-1);
		item.addItemListener(new InitialRucksackItemController(world, player));
		add(item);

	}
}
