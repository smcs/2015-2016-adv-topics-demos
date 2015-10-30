package smcs.demos.PassingReferences;

import objectdraw.*;

public class PassingReferences extends WindowController {

	private MovingTarget target;
	
	public void begin() {
		target = new MovingTarget(100, 100, canvas);
	}
	
	public void onMouseClick(Location point) {
		new TrackingBullet(target, point, canvas);
	}
}
