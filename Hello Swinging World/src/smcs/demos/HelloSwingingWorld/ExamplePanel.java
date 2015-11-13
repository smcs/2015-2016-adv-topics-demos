package smcs.demos.HelloSwingingWorld;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTabbedPane;

public class ExamplePanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public ExamplePanel() {
		setLayout(new BorderLayout(0, 0));
		
		Box verticalBox = Box.createVerticalBox();
		add(verticalBox, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("New button");
		verticalBox.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		verticalBox.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		verticalBox.add(btnNewButton_2);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		JButton btnNewButton_5 = new JButton("New button");
		verticalBox.add(btnNewButton_5);
		
		JButton btnNewButton_3 = new JButton("New button");
		verticalBox.add(btnNewButton_3);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_1);
		
		JButton btnNewButton_4 = new JButton("New button");
		verticalBox.add(btnNewButton_4);
		
		JLabel lblTitle = new JLabel("Title");
		add(lblTitle, BorderLayout.NORTH);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		textField = new JTextField();
		add(textField, BorderLayout.EAST);
		textField.setColumns(10);

	}
}
