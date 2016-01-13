package smcs.battis.tankwars;

import java.util.*;

/**
 * An object that receives bullet events
 * 
 * @author sethbattis
 *
 */
public interface BulletListener {

    /**
     * Called when a bullet is fired;
     */
    public void onBulletFired();
    
    /**
     * Called when a bullet hits SolidObject(s)
     * 
     * @param hits
     *            All SolidObjects impacted by the bullet
     */
    public void onBulletImpact(Vector<SolidObject> hits);
}
