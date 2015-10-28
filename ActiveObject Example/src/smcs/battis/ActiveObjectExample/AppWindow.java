package smcs.battis.ActiveObjectExample;

import objectdraw.*;

/**
 * Chase a moving ball across the window. It changes color if you click on it.
 * 
 * @author sethbattis
 *
 */
public class AppWindow extends WindowController {

	private MovingBall o;

	public void begin() {
		o = new MovingBall(0, 100, 10, 10, canvas);
		o.start(); // start the MovingBall thread
	}

	public void onMouseClick(Location point) {
		if (o.contains(point)) {
			o.changeColor();
		}
	}
}
