package smcs.demo.HitTheTarget;

import objectdraw.*;

/**
 * A shot that moves up the canvas, checking to see if it has hit the target.
 * 
 * @author sethbattis
 *
 */
public class Shot extends ActiveObject {

	public static final long DELAY = 20;
	public static final double WIDTH = 10, HEIGHT = WIDTH;

	private FilledOval shot;
	private Target target;

	public Shot(Target target, double x, double y, DrawingCanvas canvas) {
		shot = new FilledOval(x - WIDTH / 2.0, y - HEIGHT / 2.0, WIDTH, HEIGHT, canvas);
		this.target = target;
		start();
	}

	public void run() {
		while (!(target.overlaps(shot) || shot.getY() - HEIGHT < 0)) {
			pause(DELAY);
			shot.move(0, -1);
		}
		shot.removeFromCanvas();
	}

}
