package smcs.battis.tankwars.network;

import smcs.battis.tankwars.*;

/**
 * A list of event types that might be sent over the network
 * 
 * @author sethbattis
 *
 */
public interface NetworkListener {
    public void createTerrain(Terrain terrain);

    public void createTank(Tank tank);

    public void assignTank(int tankId);

    public void bulletFired(Bullet bullet);

    public void removeTank(int tankId);

    public void nextTank(int tankId);
}
