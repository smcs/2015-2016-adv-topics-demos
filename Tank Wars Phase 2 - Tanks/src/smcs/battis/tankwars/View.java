package smcs.battis.tankwars;

import objectdraw.*;

/**
 * An object that can be drawn on a Canvas
 * 
 * @author sethbattis
 *
 */
public abstract class View {

    /**
     * The DrawingCanvas on which this view is displayed
     */
    protected DrawingCanvas canvas;

    /**
     * This super-constructor must be called to support proper functioning of
     * getCanvas()
     * 
     * @param canvas
     */
    public View(DrawingCanvas canvas) {
	this.canvas = canvas;
    }

    /**
     * Redraw the view to reflect the current model
     */
    public abstract void draw();

    /**
     * Get the canvas on which this view is displayed
     * 
     * @return
     */
    public DrawingCanvas getCanvas() {
	return canvas;
    }

    /**
     * Hide the view from the canvas
     */
    public abstract void hide();
}
