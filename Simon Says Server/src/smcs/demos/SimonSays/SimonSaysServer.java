package smcs.demos.SimonSays;

import java.io.*;
import java.net.*;

public class SimonSaysServer implements Runnable {

	public static final String SHUT_DOWN = "Exit";

	private ServerSocket server;

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
	
	private void log(String message) {
		System.out.println("Server: " + message);
	}
	
	private void error(String message) {
		System.err.println("Server: " + message);
	}

	public void run() {
		while (true) {
			try {
				new SimonSaysResponder(server.accept());
			} catch (IOException e) {
				error("Could not connect to client");
			}
		}
	}
}
