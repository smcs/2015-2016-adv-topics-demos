package smcs.battis.tankwars;

import java.awt.*;

import objectdraw.*;

/**
 * Draw a tank in canvas
 * 
 * @author sethbattis
 *
 */
public class TankView implements View {

    public static final double BODY_RADIUS = 10;
    public static final double BARREL_LENGTH = BODY_RADIUS * 2;

    private Tank tank;

    private FilledArc body;
    private Line barrel;
    private Text power;

    public TankView(Tank tank, DrawingCanvas canvas) {
	this(tank, new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)),
		canvas);
    }

    public TankView(Tank tank, Color color, DrawingCanvas canvas) {
	this.tank = tank;

	body = new FilledArc(tank.getCenter().getX() - BODY_RADIUS, tank.getCenter().getY() - BODY_RADIUS,
		BODY_RADIUS * 2, BODY_RADIUS * 2, 0, 180, canvas);
	body.setColor(color);
	body.hide();

	// end point doesn't matter -- will be updated before being shown
	barrel = new Line(tank.getCenter(), new Location(0, 0), canvas);
	barrel.setColor(color);
	barrel.hide();

	power = new Text(tank.getPower(), body.getX(), body.getY() - BARREL_LENGTH - 5, canvas);
	power.setColor(color);
	power.hide();
    }

    @Override
    public void draw() {
	body.show();

	barrel.setEnd(new Location(tank.getCenter().getX() + BARREL_LENGTH * Math.cos(tank.getAngle()),
		tank.getCenter().getY() + BARREL_LENGTH * Math.sin(tank.getAngle())));
	barrel.show();

	power.setText(tank.getPower());
	power.show();
    }

    public Tank getTank() {
	return tank;
    }

}
