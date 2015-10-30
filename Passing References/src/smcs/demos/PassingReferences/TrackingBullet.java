package smcs.demos.PassingReferences;

import java.awt.*;

import objectdraw.*;

/**
 * A bullet that tries to home in on the target
 * 
 * @author sethbattis
 *
 */
public class TrackingBullet extends ActiveObject {

	private MovingTarget a;
	private FilledOval me;

	public TrackingBullet(MovingTarget a, Location point, DrawingCanvas canvas) {
		this.a = a;
		me = new FilledOval(point, 10, 10, canvas);
		me.setColor(Color.PINK);
		start();
	}

	public void run() {
		while (true) {

			/*
			 * work out the angle between "me" and "target" and advance one unit
			 * towards target
			 */
			// caveat: we pretended this was all in the first quadrant
			double targetX = a.getLocation().getX();
			double targetY = a.getLocation().getY();

			double meX = me.getX();
			double meY = me.getY();

			double theta = Math.atan((targetY - meY) / (targetX - meX));

			pause(30);
			me.move(Math.cos(theta), Math.sin(theta));
		}
	}

}
