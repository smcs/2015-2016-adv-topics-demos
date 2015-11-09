package smcs.demo.HitTheTarget;

import objectdraw.*;

/**
 * Display the hits-to-clicks ratio
 * 
 * @author sethbattis
 *
 */
public class Scoreboard {
	
	public static final double HORIZ_OFFSET = 10, VERT_OFFSET = HORIZ_OFFSET;
	private int clicks = 0, hits = 0;
	private Text scoreboard;
	
	public Scoreboard(DrawingCanvas canvas) {
		scoreboard = new Text ("0 / 0", HORIZ_OFFSET, VERT_OFFSET, canvas);
	}
	
	public void addClick() {
		clicks++;
		update();
	}
	
	public void addHit() {
		hits++;
		update();
	}
	
	private void update() {
		scoreboard.setText(hits + " / " + clicks);
	}

}
