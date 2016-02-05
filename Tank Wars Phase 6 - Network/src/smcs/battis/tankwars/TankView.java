package smcs.battis.tankwars;

import java.awt.*;

import objectdraw.*;

/**
 * Draw a tank in canvas
 * 
 * @author sethbattis
 *
 */
public class TankView extends View {

    private Tank tank;

    private FilledArc body;
    private Line barrel;
    private Text power;

    public TankView(Tank tank, DrawingCanvas canvas) {
	super(canvas);
	this.tank = tank;

	body = new FilledArc(tank.getCenter().getX() - Tank.RADIUS, tank.getCenter().getY() - Tank.RADIUS,
		Tank.RADIUS * 2, Tank.RADIUS * 2, 0, 180, canvas);
	body.setColor(tank.getColor());
	body.hide();

	// end point doesn't matter -- will be updated before being shown
	barrel = new Line(tank.getCenter(), new Location(0, 0), canvas);
	barrel.setColor(tank.getColor());
	barrel.hide();

	power = new Text(tank.getPower(), body.getX(), body.getY() - (Tank.RADIUS + Tank.BARREL_LENGTH) - 5, canvas);
	power.setColor(tank.getColor());
	power.hide();
    }

    @Override
    public void draw() {
	body.show();
	
	barrel.setEnd(new Location(
		tank.getCenter().getX() - (Tank.RADIUS + Tank.BARREL_LENGTH) * Math.cos(tank.getAngle()),
		tank.getCenter().getY() + (Tank.RADIUS + Tank.BARREL_LENGTH) * Math.sin(tank.getAngle()))
	);
	barrel.show();

	power.setText(tank.getPower());
	power.show();
    }

    public Color getColor() {
	return body.getColor();
    }

    public DrawingCanvas getCanvas() {
	return body.getCanvas();
    }

    @Override
    public void hide() {
	body.hide();
	barrel.hide();
	power.hide();
    }

}
