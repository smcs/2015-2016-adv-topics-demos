package smcs.battis.ActiveObjectExample;

import java.awt.*;

import objectdraw.*;

/**
 * A filled oval that moves horizontally across the window (until it leaves the
 * Canvas).
 * 
 * @author sethbattis
 *
 */
public class MovingBall extends ActiveObject {

	public static final long DELAY = 100; // tenth of a second

	private FilledOval o;
	private long timer;

	public MovingBall(double x, double y, double width, double height, DrawingCanvas canvas) {
		o = new FilledOval(x, y, width, height, canvas);
		timer = System.currentTimeMillis();
	}

	/**
	 * The control method for the MovingBall thread
	 */
	public void run() {
		while (o.getX() < o.getCanvas().getWidth()) {
			if (System.currentTimeMillis() > timer + DELAY) {
				o.move(1, 0);
				timer = System.currentTimeMillis();
			}
		}
	}

	public boolean contains(Location point) {
		return o.contains(point);
	}

	public void changeColor() {
		o.setColor(new Color((int) (255 * Math.random()), (int) (255 * Math.random()), (int) (255 * Math.random())));
	}
}
