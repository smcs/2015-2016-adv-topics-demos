package smcs.battis.tankwars.network;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

import objectdraw.*;
import smcs.battis.tankwars.*;

public class Client implements Runnable, NetworkProtocol {

    private Socket socket;
    private LocalReferee referee;
    private DrawingCanvas canvas; /*
				   * FIXME we don't good about the
				   * cross-pollination of model, view and
				   * controller here!
				   */
    private Component app;

    public Client(String hostname, int port, LocalReferee referee, DrawingCanvas canvas, Component app) {
	try {
	    socket = new Socket(hostname, port);
	    this.referee = referee;
	    this.canvas = canvas;
	    this.app = app;
	    new Thread(this).start();
	} catch (UnknownHostException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Override
    public void run() {
	try {
	    Scanner scanner = new Scanner(socket.getInputStream());
	    ObjectInputStream obj = new ObjectInputStream(socket.getInputStream());
	    HashMap<Integer, TankView> views = new HashMap<Integer, TankView>();
	    while (!referee.gameOver()) {
		while (!scanner.nextLine().equals(BOM)) {
		}
		switch (MessageType.valueOf(scanner.nextLine())) {
		    case TERRAIN:
			new TerrainView((Terrain) obj.readObject(), canvas).draw();
			break;
		    case TANK:
			Tank t = (Tank) obj.readObject();
			TankView tv = new TankView(t, canvas);
			referee.addPlayer(t);
			views.put(t.getId(), tv);
			tv.draw();
			break;
		    case BULLET:
			Bullet b = (Bullet) obj.readObject();
			b.addBulletListener(referee);
			new BulletController(b, new BulletView(b, canvas));
			break;
		    case ASSIGN:
			int tankId = scanner.nextInt();
			app.addKeyListener(new TankController(referee.getPlayer(tankId), views.get(tankId), referee));
			break;
		    case NEXT:
			referee.setActive(scanner.nextInt());
			break;
		    case REMOVE:
			referee.removePlayer(scanner.nextInt());
			break;
		}
		while (!scanner.nextLine().equals(EOM)) {
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
}
