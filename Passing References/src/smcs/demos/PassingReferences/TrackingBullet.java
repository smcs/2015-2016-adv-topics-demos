package smcs.demos.PassingReferences;

import java.awt.Color;

import objectdraw.*;

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
