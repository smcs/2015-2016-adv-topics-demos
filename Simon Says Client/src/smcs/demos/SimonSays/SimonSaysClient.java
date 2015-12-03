package smcs.demos.SimonSays;

import java.io.*;
import java.net.*;
import java.util.*;

public class SimonSaysClient implements SimonSaysProtocol {

	private Socket responderSocket;

	public SimonSaysClient(String hostname, int port) {
		try {
			responderSocket = new Socket(hostname, port);
		} catch (UnknownHostException e) {
			System.err.println(hostname + " could not be found");
		} catch (IOException e) {
			System.err.println("Could not connect to " + hostname);
		}
		
		if (responderSocket != null) {
			session();
		}
	}

	private void session() {
		Scanner console = new Scanner(System.in); // listen to user
		BufferedReader input; // listen to server
		PrintStream output; // talk to server
		
		String response = ""; // most recent response from server
		
		try {
			input = new BufferedReader(new InputStreamReader(responderSocket.getInputStream()));
		} catch (IOException e) {
			System.err.println("Could not read from " + responderSocket.getLocalAddress().getHostName());
			return;
		}
		
		try {
			output = new PrintStream(responderSocket.getOutputStream());
		} catch (IOException e) {
			System.err.println("Could not write to " + responderSocket.getLocalAddress().getHostName());
			return;
		}
		
		while(!response.equals(EXIT)) {
			System.out.print("> ");
			output.println(console.nextLine());
			try {
				response = input.readLine();
				System.out.println(response);
			} catch (IOException e) {
				System.err.println("Lost connection to " + responderSocket.getLocalAddress().getHostName());
			}
		}
	}

	public boolean active() {
		return responderSocket != null;
	}
}
