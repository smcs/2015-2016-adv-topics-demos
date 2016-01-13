package smcs.battis.tankwars.app;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import objectdraw.*;
import smcs.battis.tankwars.*;

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

	Terrain terrain = new Terrain(canvas.getWidth(), canvas.getHeight());
	new TerrainView(terrain, canvas).draw();

	Referee referee = new Referee();

	for (int i = 1; i <= TANK_COUNT; i++) {
	    Tank tank = new Tank(terrain, new Location(i * (canvas.getWidth() / (TANK_COUNT + 1)), 0));
	    TankView tankView = new TankView(tank, canvas);
	    tankView.draw();
	    frame.addKeyListener(new TankController(tank, tankView, referee));
	    referee.addPlayer(tank);
	}

	referee.beginGame();
    }
}
