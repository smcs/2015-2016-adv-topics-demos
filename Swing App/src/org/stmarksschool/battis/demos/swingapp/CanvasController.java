package org.stmarksschool.battis.demos.swingapp;

import java.awt.Point;
import java.awt.event.*;

import objectdraw.*;

public class CanvasController implements MouseListener, MouseMotionListener {

	private DrawingCanvas canvas;
	private FilledRect rect;
	private boolean clicked = false;
	private Point loc;
	
	public CanvasController(DrawingCanvas canvas, FilledRect rect) {
		this.canvas = canvas;
		this.rect = rect;
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		loc = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = e.getPoint();
		rect.move(p.getX() - loc.getX(), p.getY() - loc.getY());
		loc = p;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
