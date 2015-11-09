package smcs.demo.HitTheTarget;

import java.awt.*;

import objectdraw.*;

/**
 * An autonomous target that bounces from side-to-side across the Canvas.
 * 
 * @author sethbattis
 *
 */
public class Target extends ActiveObject {

	public static final double WIDTH = 20, HEIGHT = WIDTH, ELEVATION = 0.8;
	public static final Color COLOR = Color.RED;
	public static final long DELAY = 100;

	private FilledOval target;
	private double velocity = 1;
	private Scoreboard scoreboard;

	public Target(Scoreboard scoreboard, DrawingCanvas canvas) {
		target = new FilledOval((canvas.getWidth() - WIDTH) / 2, canvas.getHeight() * (1.0 - ELEVATION), WIDTH, HEIGHT,
				canvas);
		this.scoreboard = scoreboard;
		start();
	}

	public void run() {
		while (true) {
			pause(DELAY);
			target.move(velocity, 0);
			if (target.getX() + WIDTH > target.getCanvas().getWidth() || target.getX() < 0) {
				velocity *= -1;
			}
		}
	}

	public boolean overlaps(Drawable2DInterface item) {
		if (target.overlaps(item)) {
			scoreboard.addHit();
			return true;
		}
		return false;
	}

}
