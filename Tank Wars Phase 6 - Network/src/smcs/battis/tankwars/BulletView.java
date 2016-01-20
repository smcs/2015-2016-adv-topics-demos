package smcs.battis.tankwars;

import java.awt.*;

import objectdraw.*;

/**
 * Draw a bullet on the screen (matching the firing tank's color)
 * 
 * @author sethbattis
 *
 */
public class BulletView extends View {

    public static final double RADIUS = 2;

    private Bullet bullet;

    private FilledOval dot;

    public BulletView(Bullet bullet, Color color, DrawingCanvas canvas) {
	super(canvas);
	this.bullet = bullet;

	dot = new FilledOval(bullet.getCenter().getX() - RADIUS, bullet.getCenter().getY() - RADIUS, RADIUS * 2,
		RADIUS * 2, canvas);
	dot.setColor(color);
	dot.hide();
    }

    @Override
    public void draw() {
	dot.moveTo(bullet.getCenter());
	dot.move(-RADIUS, -RADIUS);
	dot.show();
    }

    @Override
    public void hide() {
	dot.removeFromCanvas();
    }

}
