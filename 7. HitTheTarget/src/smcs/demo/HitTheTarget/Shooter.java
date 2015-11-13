package smcs.demo.HitTheTarget;

import java.awt.*;

import objectdraw.*;

/**
 * A "shooter" that, when fired, releases three shots upwards at a particular
 * target.
 * 
 * @author sethbattis
 *
 */
public class Shooter extends ActiveObject {

	public static final int SHOTS = 3;
	public static final long DELAY = 500;
	public static final double WIDTH = 40, HEIGHT = WIDTH;
	public static final Color MOVING = Color.GREEN, SHOOTING = Color.RED;

	private FilledArc body;
	private Target target;

	public Shooter(Target target, DrawingCanvas canvas) {
		this(target, new Location(canvas.getWidth() / 2, canvas.getHeight()), canvas);
	}

	public Shooter(Target target, Location point, DrawingCanvas canvas) {
		body = new FilledArc(point.getX() - WIDTH / 2, canvas.getHeight() - HEIGHT, WIDTH, HEIGHT, 225, 90, canvas);
		body.setColor(MOVING);
		this.target = target;
	}

	public void moveTo(Location point) {
		body.moveTo(point.getX() - WIDTH / 2, body.getCanvas().getHeight() - HEIGHT);
	}

	public void setFiringPosition(Location point) {
		this.moveTo(point);
		body.setColor(SHOOTING);
		start();
	}

	public void run() {
		Shot shots[];
		shots = new Shot[SHOTS];
		
		for (int i = 0; i < shots.length; i++) {
			pause(DELAY);
			shots[i] = new Shot(target, body.getLocation().getX() + WIDTH / 2, body.getCanvas().getHeight(), body.getCanvas());
		}
		body.removeFromCanvas();
	}

}
