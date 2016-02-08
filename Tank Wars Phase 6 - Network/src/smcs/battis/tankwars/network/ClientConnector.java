package smcs.battis.tankwars.network;

import java.io.*;
import java.net.*;

import javax.swing.*;

import objectdraw.*;
import smcs.battis.tankwars.*;

/**
 * 
 * @author sethbattis
 *
 */
public class ClientConnector {

    public ClientConnector(int port, int clients, Referee referee, JDrawingCanvas canvas, JFrame frame) {
	try {
	    ServerSocket socket = new ServerSocket(port);
	    for (int i = 0; i < clients; i++) {
		new Server(socket.accept(), referee, canvas, frame);
	    }
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
