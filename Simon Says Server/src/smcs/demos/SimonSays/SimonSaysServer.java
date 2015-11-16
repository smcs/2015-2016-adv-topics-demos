package smcs.demos.SimonSays;

import java.io.*;
import java.net.*;

public class SimonSaysServer implements Runnable {

	private ServerSocket serverSocket;
	
	public SimonSaysServer(int port) {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.err.println("Could not create a server socket on port " + port);
		}
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		Socket clientSocket;
		DataInputStream in;
		PrintStream out;
		String line;
		
		try {
			clientSocket = serverSocket.accept();
			in = new DataInputStream(clientSocket.getInputStream());
			out = new PrintStream(clientSocket.getOutputStream());
			
			out.println("Let's play Simon says");
			while (!(line = in.readLine()).equals("Simon says")) {
				out.println("[ignoring you]");
			}
			out.println(line + " good-bye");
			
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException e) {
			System.err.println("Could not connect to a client");
		}
	}

}
















