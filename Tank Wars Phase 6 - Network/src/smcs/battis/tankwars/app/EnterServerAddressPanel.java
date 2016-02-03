package smcs.battis.tankwars.app;

import javax.swing.*;

import objectdraw.*;
import smcs.battis.tankwars.network.*;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Interface for the user to enter a server address to connect to, to play the
 * game.
 * 
 * @author sethbattis
 *
 */
public class EnterServerAddressPanel extends JPanel {
    private JTextField hostname;
    private JTextField port;

    /**
     * Create the panel.
     */
    public EnterServerAddressPanel(JFrame frame) {
	setLayout(null);

	hostname = new JTextField();
	hostname.setBounds(119, 6, 134, 28);
	add(hostname);
	hostname.setColumns(10);

	port = new JTextField();
	port.setBounds(119, 34, 134, 28);
	add(port);
	port.setColumns(10);

	JLabel lblHostName = new JLabel("Host name:");
	lblHostName.setHorizontalAlignment(SwingConstants.RIGHT);
	lblHostName.setBounds(6, 12, 101, 16);
	add(lblHostName);

	JLabel lblPort = new JLabel("Port:");
	lblPort.setHorizontalAlignment(SwingConstants.RIGHT);
	lblPort.setBounds(46, 40, 61, 16);
	add(lblPort);

	JButton btnConnect = new JButton("Connect");
	btnConnect.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.out.println(hostname.getText() + ":" + port.getText());

		/* TODO some serious data checking and validation */

		JDrawingCanvas canvas = new JDrawingCanvas();
		canvas.setBounds(6, 6, 466, 466);
		frame.getContentPane().remove(btnConnect.getParent()); // i.e. this panel
		frame.getContentPane().add(canvas);

		new Client(hostname.getText(), Integer.valueOf(port.getText()), new LocalReferee(),
			canvas, frame);
	    }
	});
	btnConnect.setBounds(136, 75, 117, 29);
	add(btnConnect);
    }
}
