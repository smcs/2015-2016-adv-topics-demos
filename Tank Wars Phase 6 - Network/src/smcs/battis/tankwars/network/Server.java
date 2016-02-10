package smcs.battis.tankwars.network;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;

import objectdraw.*;
import smcs.battis.tankwars.*;

public class Server implements Runnable, NetworkProtocol {

    /* a list of all connected clients */
    private static Vector<Server> clients;
    private static Terrain terrain;

    private Socket socket;
    private Referee referee;
    private int clientCount;
    private DrawingCanvas canvas;
    private JFrame frame;
    private boolean ready;

    private ObjectOutputStream obj;
    private PrintStream out;
    private Scanner scanner;

    public Server(Socket socket, Referee referee, int clientCount, JDrawingCanvas canvas, JFrame frame) {

	if (clients == null) {
	    clients = new Vector<Server>();
	    terrain = new Terrain(canvas.getWidth(), canvas.getHeight());
	    new TerrainView(terrain, canvas).draw();
	}
	clients.add(this);

	ready = false;
	this.socket = socket;
	this.referee = referee;
	this.clientCount = -clientCount;
	this.canvas = canvas;
	this.frame = frame;

	new Thread(this).start();
    }

    private void sendMessage(MessageType type, Object data) {
	try {
	    out.println(BOM);
	    out.println(type);
	    if (data.getClass() == Integer.class) {
		out.println(data);
	    } else {
		obj.writeObject(data);
	    }
	    out.println(EOM);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Override
    public void run() {
	try {
	    obj = new ObjectOutputStream(socket.getOutputStream());
	    out = new PrintStream(socket.getOutputStream());
	    scanner = new Scanner(socket.getInputStream());
	    ObjectInputStream objIn = new ObjectInputStream(socket.getInputStream());

	    // tell THIS client about the terrain
	    sendMessage(MessageType.TERRAIN, terrain);

	    // wait for preceding players to be ready
	    while (!allClientsBeforeMeReady()) {
	    }

	    // tell THIS client about all the other tanks
	    for (Tank player : referee.getPlayers()) {
		sendMessage(MessageType.TANK, player);
	    }

	    // add a tank (for this client)
	    Tank tank = new Tank(terrain, new Location(clients.size() * (clients.size() / (clientCount + 1)), 0));
	    /*
	     * TODO if we want the server to be able to play too, we've got some
	     * work to do in terms of setting up views and controllers (and
	     * thinking about our referee player-turn model)
	     */

	    // tell ALL the clients about this tank
	    for (Server client : clients) {
		client.sendMessage(MessageType.TANK, tank);
	    }

	    // tell THIS client that THIS tank is his/hers
	    sendMessage(MessageType.ASSIGN, tank.getId());

	    // ok, now the client is set up
	    ready = true;

	    // wait for communication from the client
	    while (!referee.gameOver()) {
		while (scanner.nextLine() != BOM) {
		}
		switch (MessageType.valueOf(scanner.nextLine())) {
		    case BULLET:
			Bullet bullet = (Bullet) objIn.readObject();
			bullet.addBulletListener(referee);
			new BulletController(bullet, new BulletView(bullet, canvas));
			for (Server clients : clients) {
			    sendMessage(MessageType.BULLET, bullet);
			}
			break;
		}
		while (scanner.nextLine() != EOM) {
		}
	    }

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    private boolean allClientsBeforeMeReady() {
	for (Server client : clients) {
	    if (client == this) {
		return true;
	    } else if (!client.ready) {
		return false;
	    }
	}
	return true;
    }

    public static boolean allClientsReady() {
	for (Server client : clients) {
	    if (!client.ready) {
		return false;
	    }
	}
	return true;
    }
}
