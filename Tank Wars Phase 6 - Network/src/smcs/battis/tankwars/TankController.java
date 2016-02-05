package smcs.battis.tankwars;

import java.awt.event.*;

/**
 * Keyboard control of a tank (via its view)
 * 
 * @author sethbattis
 *
 */
public class TankController implements KeyListener {

    private Tank tank;
    private TankView view;

    private Referee referee;

    private int angleUp, angleDown, powerUp, powerDown, fire;

    public TankController(Tank tank, TankView view, Referee referee) {
	this(tank, view, referee, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_SPACE);
    }

    public TankController(Tank tank, TankView view, Referee referee, int angleUp, int angleDown, int powerUp, int powerDown, int fire) {
	this.tank = tank;
	this.view = view;
	this.referee = referee;
	this.angleUp = angleUp;
	this.angleDown = angleDown;
	this.powerUp = powerUp;
	this.powerDown = powerDown;
	this.fire = fire;
    }

    @Override
    public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
	if (referee.activePlayer() == tank) {
	    boolean changed = false;

	    if (e.getKeyCode() == angleUp) {
		tank.increaseAngle();
		changed = true;
	    } else if (e.getKeyCode() == angleDown) {
		tank.decreaseAngle();
		changed = true;
	    } else if (e.getKeyCode() == powerUp) {
		tank.increasePower();
		changed = true;
	    } else if (e.getKeyCode() == powerDown) {
		tank.decreasePower();
		changed = true;
	    } else if (e.getKeyCode() == fire) {
		Bullet bullet = tank.fire();
		bullet.addBulletListener(referee);
		BulletView bulletView = new BulletView(bullet, view.getCanvas());
		new BulletController(bullet, bulletView);

		/*
		 * The Referee needs to be added to the BulletController's list
		 * of BulletListeners (this may impact the timing of when the
		 * BulletController thread is started)
		 */
	    }

	    if (changed) {
		view.draw();
	    }
	}
    }

    @Override
    public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub

    }
}
