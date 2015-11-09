package smcs.demo.HitTheTarget;

import objectdraw.*;

/**
 * Play a simple game in which, every time the user clicks, it creates a
 * "shooter" that shoots three shots from the bottom of the screen. 1 point for
 * each shot that hits the moving target.
 * 
 * @author sethbattis
 *
 */
public class HitTheTarget extends WindowController {

	private Target t;
	private Shooter s;
	private Scoreboard b;

	public void begin() {
		b = new Scoreboard(canvas);
		t = new Target(b, canvas);
		s = new Shooter(t, canvas);
	}

	public void onMouseMove(Location point) {
		s.moveTo(point);
	}

	public void onMouseClick(Location point) {
		b.addClick();
		s.setFiringPosition(point);
		s = new Shooter(t, point, canvas);
	}
}
