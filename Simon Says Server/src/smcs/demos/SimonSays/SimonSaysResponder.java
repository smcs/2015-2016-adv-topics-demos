package smcs.demos.SimonSays;

import java.io.*;
import java.net.*;

public class SimonSaysResponder implements Runnable, SimonSaysProtocol {
	
	private static int nextSessionId = 1;
	private int sessionId = nextSessionId++;
	
	private Socket clientSocket;
	
	public SimonSaysResponder (Socket clientSocket) {
		this.clientSocket = clientSocket;
		new Thread(this).start();
	}
	
	private void log(String message) {
		System.out.println("Session " + sessionId + ": " + message);
	}
	
	private void error(String message) {
		System.err.println("Session " + sessionId + ": " + message);
	}
	
	public void run() {
		BufferedReader input;
		PrintStream output;
		String line;
		boolean done = false;
		
		if (clientSocket != null) {
			try {
				/* open new streams connected to our socket */
				input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				output = new PrintStream(clientSocket.getOutputStream());
				log("Started");
				
				/* loop until the user "gets" it */
				while (!done) {
					line = input.readLine();
					log("Received '" + line + "'");
					if (line.regionMatches(true, 0, MAGIC_WORD, 0, MAGIC_WORD.length())) {
						output.println(line.substring(MAGIC_WORD.length()));
						done = line.substring(MAGIC_WORD.length()).equalsIgnoreCase(EXIT);
					} else {
						output.println("You didn't use the magic word.");
					}
				}
				
				/* close all of our streams and sockets */
				input.close();
				output.close();
				clientSocket.close();
				log("Ended");
			} catch (IOException e) {
				error("Could not open stream with " + clientSocket.getLocalAddress().getHostName());
			}
		} else {
			error("Connection to " + clientSocket.getLocalAddress().getHostName() + " lost.");
		}
	}
}
