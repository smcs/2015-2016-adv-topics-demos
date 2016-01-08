package smcs.battis.tankwars;

import java.util.*;

import objectdraw.*;

/**
 * Draw a Terrain on a DrawingCanvas
 * 
 * @author sethbattis
 *
 */
public class TerrainView extends View {

    private Terrain terrain;

    private Vector<Line> surface;

    public TerrainView(Terrain terrain, DrawingCanvas canvas) {
	super(canvas);
	Location prev = null, next = null;
	
	this.terrain = terrain;

	surface = new Vector<Line>();
	for (Iterator<Location> i = terrain.iterator(); i.hasNext();) {
	    prev = next;
	    next = i.next();
	    if (prev != null) {
		Line l = new Line(prev, next, canvas);
		l.hide();
		surface.add(l);
	    }
	}
    }

    @Override
    public void draw() {
	
	// FIXME this doesn't pay attention to changes in the terrain

	for (Iterator<Line> i = surface.iterator(); i.hasNext();) {
	    i.next().show();
	}

    }

    public Terrain getTerrain() {
	return terrain;
    }

    @Override
    public void hide() {
	for (Line l : surface) {
	    l.hide();
	}
    }

}
