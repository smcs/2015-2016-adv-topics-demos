package smcs.battis.tankwars.network;

import objectdraw.*;
import smcs.battis.tankwars.*;

/**
 * An object to manage network events on the client-side
 * @author sethbattis
 *
 */
public class ClientController implements NetworkListener {

    private LocalReferee localReferee;
    private DrawingCanvas canvas;
    
    @Override
    public void createTerrain(Terrain terrain) {
	new TerrainView(terrain, canvas).draw();
    }

    @Override
    public void createTank(Tank tank) {
	// FIXME probably some TankController jujitsu we need to worry about
	new RemoteTankController(tank, new TankView(tank, canvas), localReferee);
	localReferee.addPlayer(tank);
    }

    @Override
    public void assignTank(int tankId) {
	// this is the tank that our keyboard talks to
	
	// this is probably about registering a specific TankController as a
	// KeyListener (and the others as remote controlled)
    }

    @Override
    public void bulletFired(Bullet bullet) {
	// create and animate a bullet
    }

    @Override
    public void removeTank(int tankId) {
	localReferee.removePlayer(tankId);
    }

    @Override
    public void nextTank(int tankId) {
	// tell local referree which tank is active
    }

}
