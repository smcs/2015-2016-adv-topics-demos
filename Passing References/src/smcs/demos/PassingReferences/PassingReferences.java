package smcs.demos.PassingReferences;

import objectdraw.*;

/**
 * Why is it important for objects to have references to other objects? Here's
 * why: how else would the tracking bullet be able to home in on the moving
 * target, if it doesn't have a reference to the moving target?
 * 
 * @author sethbattis
 *
 */
public class PassingReferences extends WindowController {

	private MovingTarget target;

	public void begin() {
		target = new MovingTarget(100, 100, canvas);
	}

	public void onMouseClick(Location point) {
		new TrackingBullet(target, point, canvas);
	}
}
