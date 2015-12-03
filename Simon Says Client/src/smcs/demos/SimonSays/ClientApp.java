package smcs.demos.SimonSays;

import java.util.*;

public class ClientApp {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String hostname;
		int port;
		SimonSaysClient client;
		
		do {
			System.out.print("Server: ");
			hostname = console.next();
			System.out.print("Port: ");
			port = console.nextInt();
			
			client = new SimonSaysClient(hostname, port);
		} while (!client.active());
	}

}
