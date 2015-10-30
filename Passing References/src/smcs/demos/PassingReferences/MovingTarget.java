package smcs.demos.PassingReferences;

import java.awt.*;

import objectdraw.*;

/**
 * A target that bounces around the Canvas
 * 
 * @author sethbattis
 *
 */
public class MovingTarget extends ActiveObject {

	private FilledOval me;
	private double velocityX = 1, velocityY = 0.5;
	
	public MovingTarget(int i, int j, DrawingCanvas canvas) {
		me = new FilledOval(i, j, 10, 10, canvas);
		me.setColor(Color.MAGENTA);
		start();
	}
	
	public void run() {
		while (true) {
			pause(20);
			me.move(velocityX, velocityY);
			
			/* bounce off the edges of the canvas */
			if (me.getX() > me.getCanvas().getWidth() - 10 || me.getX() < 0) {
				velocityX *= -1;
			}
			if (me.getY() > me.getCanvas().getHeight() - 10 || me.getY() < 0) {
				velocityY *= -1;
			}
		}
	}

	public Location getLocation() {
		return me.getLocation();
	}
}
