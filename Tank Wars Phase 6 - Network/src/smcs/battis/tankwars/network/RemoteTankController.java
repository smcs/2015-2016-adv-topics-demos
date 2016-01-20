package smcs.battis.tankwars.network;

import smcs.battis.tankwars.*;

/**
 * A tank controller that receives updates from the network (rather than the
 * keyboard)
 * 
 * @author sethbattis
 *
 */
public class RemoteTankController extends TankController {

    public RemoteTankController(Tank tank, TankView view, Referee referee) {
	super(tank, view, referee);
    }

}
