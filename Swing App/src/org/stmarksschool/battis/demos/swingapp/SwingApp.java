package org.stmarksschool.battis.demos.swingapp;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import java.awt.Window.Type;

import javax.swing.JTextPane;

import java.awt.Color;

import javax.swing.JSplitPane;

import objectdraw.*;

public class SwingApp extends JFrame {

	private JPanel contentPane;
	private CanvasController c1, c2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingApp frame = new SwingApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SwingApp() {
		setTitle("Swing App");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 588, 366);
		contentPane.add(tabbedPane);
				
		DrawingCanvas canvas1 = new JDrawingCanvas();
		tabbedPane.addTab("Canvas 1", null, (Component) canvas1, null);
		c1 = new CanvasController(canvas1, new FilledRect(100, 100, 10, 10, canvas1));

		DrawingCanvas canvas2 = new JDrawingCanvas();
		tabbedPane.addTab("Canvas 2", null, (Component) canvas2, null);
		c2 = new CanvasController(canvas2, new FilledRect(100, 100, 100, 100, canvas2));
	}
}
