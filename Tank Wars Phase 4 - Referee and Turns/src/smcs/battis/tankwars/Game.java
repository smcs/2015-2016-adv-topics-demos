package smcs.battis.tankwars;

import java.util.*;

import objectdraw.*;

/**
 * Referee a game of tank wars
 * 
 * @author sethbattis
 *
 */
@SuppressWarnings("serial")
public class Game extends WindowController {

    public static final int TANK_COUNT = 3;

    public Terrain terrain;
    public TerrainView terrainView;
    
    public Vector<TankView> tankViews;
    
    public void begin() {
	this.resize(600, 600);

	terrain = new Terrain(canvas.getWidth(), canvas.getHeight());
	terrainView = new TerrainView(terrain, canvas);

	tankViews = new Vector<TankView>();
	for (int i = 1; i <= TANK_COUNT; i++) {
	    Tank tank = new Tank(terrain, new Location(i * (canvas.getWidth() / (TANK_COUNT + 1)), 0));
	    TankView tankView = new TankView(tank, canvas);
	    tankViews.add(tankView);
	    canvas.addKeyListener(new TankController(tank, tankView));
	}

	terrainView.draw();
	for (Iterator<TankView> i = tankViews.iterator(); i.hasNext();) {
	    i.next().draw();
	}
    }
}
