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

	private MovingTarget target;
	private FilledOval me;

	public TrackingBullet(MovingTarget target, Location point, DrawingCanvas canvas) {
		this.target = target;
		me = new FilledOval(point, 10, 10, canvas);
		me.setColor(Color.PINK);
		start();
	}

	public void run() {
		while (!target.overlaps(me)) {

			/*
			 * work out the angle between "me" and "target" and advance one unit
			 * towards target
			 */
			double targetX = target.getLocation().getX();
			double targetY = target.getLocation().getY();

			double meX = me.getX();
			double meY = me.getY();

			double theta = Math.atan((targetY - meY) / (targetX - meX));
			if (meX > targetX) {
				theta += Math.PI;
			}

			pause(5);
			me.move(Math.cos(theta), Math.sin(theta));
		}
		target.grow();
		me.removeFromCanvas();
	}

}
