package smcs.demos.SimonSays;

import java.io.*;
import java.net.*;

/**
 * A thread to respond to incoming Simon Says client communication
 * 
 * @author sethbattis
 *
 */
public class SimonSaysResponder implements Runnable, SimonSaysProtocol {

	/* Generate a unique, sequential session number for each responder */
	private static int nextSessionId = 1;
	private int sessionId = nextSessionId++;

	/* the socket on which we are communicating with the client */
	private Socket clientSocket;

	/**
	 * Constructor
	 * 
	 * @param clientSocket
	 *            A socket connection to a client
	 */
	public SimonSaysResponder(Socket clientSocket) {
		this.clientSocket = clientSocket;
		new Thread(this).start();
	}

	/**
	 * Thread logic. Play "Simon Says" with the client until they use the magic
	 * words to end the session.
	 */
	public void run() {

		/* Streams for text input and output */
		BufferedReader input;
		PrintStream output;

		/* Current line received */
		String line;

		/* Are we done yet? */
		boolean done = false;

		/* Make sure that we have a valid socket connection to the client */
		if (clientSocket != null) {
			try {
				/* open new streams connected to our socket */
				input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				output = new PrintStream(clientSocket.getOutputStream());
				log("Started with " + clientSocket.getInetAddress().getHostName());

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
				error("Could not open stream with " + clientSocket.getInetAddress().getHostName());
			}
		} else {
			error("Connection to " + clientSocket.getInetAddress().getHostName() + " lost.");
		}
	}

	/**
	 * Print log messages to the system console, with session identification
	 * 
	 * @param message
	 *            Message to be displayed
	 */
	private void log(String message) {
		System.out.println("Session " + sessionId + ": " + message);
	}

	/**
	 * Print error messages to the system console, with session identification
	 * 
	 * @param message
	 *            Message to be displayed
	 */
	private void error(String message) {
		System.err.println("Session " + sessionId + ": " + message);
	}
}
