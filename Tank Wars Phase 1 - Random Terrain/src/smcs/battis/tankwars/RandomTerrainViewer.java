package smcs.battis.tankwars;

import objectdraw.*;

@SuppressWarnings("serial")
public class RandomTerrainViewer extends WindowController {

    private Terrain terrain;

    public void begin() {
	this.resize(600, 300);
	terrain = new Terrain(canvas.getWidth(), canvas.getHeight());
	terrain.draw(canvas);
    }
}
