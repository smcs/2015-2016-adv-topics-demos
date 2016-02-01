package smcs.battis.tankwars.app;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import objectdraw.*;
import smcs.battis.tankwars.*;
import smcs.battis.tankwars.network.*;

public class TankWars {

    public static final int TANK_COUNT = 3;

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    TankWars window = new TankWars();
		    window.frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public TankWars() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setTitle("Tank Wars");
	frame.setBounds(100, 100, 600, 500);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JDrawingCanvas canvas = new JDrawingCanvas();
	canvas.setBounds(6, 6, 466, 466);
	frame.getContentPane().add(canvas);

	JButton start = new JButton("Start Game");
	start.setEnabled(false);
	start.setBounds(477, 6, 117, 29);
	frame.getContentPane().add(start);

	LocalReferee referee = new LocalReferee();
	/*
	 * TODO we should figure out where the hostname and port actually come
	 * from
	 */
	Client client = new Client(hostname, port, canvas, frame);
	/* TODO we should figure out how the game actually starts now... */
    }
}
