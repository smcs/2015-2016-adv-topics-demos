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
    private DrawingCanvas canvas;
    private JFrame frame;

    private ObjectOutputStream obj;
    private PrintStream out;
    private Scanner scanner;

    public Server(Socket socket, Referee referee, JDrawingCanvas canvas, JFrame frame) {

	if (clients == null) {
	    clients = new Vector<Server>();
	    terrain = new Terrain(canvas.getWidth(), canvas.getHeight());
	    new TerrainView(terrain, canvas).draw();
	}
	clients.add(this);

	this.socket = socket;
	this.referee = referee;
	this.canvas = canvas;
	this.frame = frame;

	new Thread(this).start();
    }

    private void sendMessage(MessageType type, Object data) {
	try {
	    out.println(BOM);
	    out.println(type);
	    obj.writeObject(data);
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

	    // tell THIS client about the terrain
	    sendMessage(MessageType.TERRAIN, terrain);

	    // tell THIS client about all the other tanks
	    for (Tank player : referee.getPlayers()) {
		sendMessage(MessageType.TANK, player);
	    }

	    // add a tank (for this client)
	    // where does i come from? -- probably clients
	    // where does TANK_COUNT cosme from? -- probably the ClientConnector
	    Tank tank = new Tank(terrain, new Location(clients.size() * (i / (TANK_COUNT + 1)), 0));
	    // what else needs to happen?
	    
	    // tell ALL the clients about this tank
	    
	    // tell THIS client that THIS tank is his/hers
	    // hmm... our current SendMessage may not work for this message

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

}
