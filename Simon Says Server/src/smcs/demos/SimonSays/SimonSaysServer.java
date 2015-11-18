package smcs.demos.SimonSays;

import java.io.*;
import java.net.*;

/**
 * A server that plays "Simon Says" with clients. It starts a new thread to
 * manage each new client connection, limited only by available memory.
 * 
 * @author sethbattis
 *
 */
public class SimonSaysServer implements Runnable {

	/* A socket specifically for listening to incoming connections */
	private ServerSocket server;

	/**
	 * Constructor. Starts the server thread if the socket can be opened.
	 * 
	 * @param port Port number to listen on
	 */
	public SimonSaysServer(int port) {
		try {
			server = new ServerSocket(port);
			log("Ready on port " + port);
			new Thread(this).start();
		} catch (IOException e) {
			error("Could not listen on port " + port);
			error("Shutting down");
		}
	}

	/**
	 * Thread logic -- accept connections indefinitely
	 */
	public void run() {
		while (true) {
			try {
				new SimonSaysResponder(server.accept());
			} catch (IOException e) {
				error("Could not connect to client");
			}
		}
	}
	
	/**
	 * Print log messages to the system console
	 * 
	 * @param message Message to be displayed
	 */
	private void log(String message) {
		System.out.println("Server: " + message);
	}

	/**
	 * Print error messages to the system console
	 * 
	 * @param message Message to be displayed
	 */
	private void error(String message) {
		System.err.println("Server: " + message);
	}
}
