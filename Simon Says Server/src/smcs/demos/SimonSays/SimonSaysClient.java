package smcs.demos.SimonSays;

import java.io.*;
import java.net.*;
import java.util.*;

public class SimonSaysClient implements Runnable {

	private Socket socket;
	
	public SimonSaysClient(String host, int port) {
		try {
			socket = new Socket(host, port);
		} catch (IOException e) {
			System.err.println("Could open a connection to " + host + ":" + port);
		}
		new Thread(this).start();
	}

	@Override
	public void run() {
		DataInputStream in;
		PrintStream out;
		String line;
		String message;
		
		try {
			in = new DataInputStream(socket.getInputStream());
			out = new PrintStream(socket.getOutputStream());
			Scanner keyboardInput = new Scanner(System.in);
			while (!(line = in.readLine()).equals("Simon says good-bye")) {
				System.out.println(line);
				message = keyboardInput.nextLine();
				out.println(message);
			}
			System.out.println(line);
		} catch (IOException e) {
			System.err.println("Connection to socket broken");
		}
	}
}






