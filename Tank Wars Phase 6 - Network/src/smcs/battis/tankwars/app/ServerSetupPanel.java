package smcs.battis.tankwars.app;

import javax.swing.*;

import objectdraw.*;
import smcs.battis.tankwars.*;
import smcs.battis.tankwars.network.*;

import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.awt.event.ActionEvent;

public class ServerSetupPanel extends JPanel {
    private JTextField port;
    private JTextField clients;

    /**
     * Create the panel.
     */
    public ServerSetupPanel(JFrame frame) {
	setLayout(null);

	port = new JTextField();
	port.setBounds(79, 34, 134, 28);
	add(port);
	port.setColumns(10);

	JLabel lblPort = new JLabel("Port");
	lblPort.setHorizontalAlignment(SwingConstants.RIGHT);
	lblPort.setBounds(6, 40, 61, 16);
	add(lblPort);

	try {
	    ServerSocket socket = new ServerSocket(10000);
	    // TODO we actually need to find out what the hostname
	    JLabel host = new JLabel(socket.getInetAddress().getLocalHost().getHostName());
	    socket.close();
	    host.setBounds(79, 6, 262, 16);
	    add(host);
	} catch (IOException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	JLabel lblHost = new JLabel("Host");
	lblHost.setHorizontalAlignment(SwingConstants.RIGHT);
	lblHost.setBounds(6, 6, 61, 16);
	add(lblHost);

	clients = new JTextField();
	clients.setBounds(79, 68, 134, 28);
	add(clients);
	clients.setColumns(10);

	JLabel lblClients = new JLabel("Clients");
	lblClients.setHorizontalAlignment(SwingConstants.RIGHT);
	lblClients.setBounds(6, 74, 61, 16);
	add(lblClients);

	JButton btnCreateGame = new JButton("Create Game");
	btnCreateGame.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		/* TODO some serious data checking and validation */

		JDrawingCanvas canvas = new JDrawingCanvas();
		canvas.setBounds(6, 6, 466, 466);
		frame.getContentPane().remove(btnCreateGame.getParent()); // i.e.
									  // this
									  // panel
		frame.getContentPane().add(canvas);

		new ClientConnector(Integer.valueOf(port.getText()), Integer.valueOf(clients.getText()), new Referee(), canvas,
			frame);

	    }
	});
	btnCreateGame.setBounds(79, 108, 117, 29);
	add(btnCreateGame);

    }
}
