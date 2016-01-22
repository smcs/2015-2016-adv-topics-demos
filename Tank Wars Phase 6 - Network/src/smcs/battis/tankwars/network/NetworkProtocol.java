package smcs.battis.tankwars.network;

/**
 * 1. Wait until BOM
 * 2. Read message type
 * 3. Branch based on type
 * 4. Read message data until EOM
 * 
 * @author sethbattis
 *
 */

public interface NetworkProtocol {
    final String BOM = "BOM";
    
    enum MessageType {
	TERRAIN,
	TANK,
	BULLET,
	ASSIGN,
	NEXT,
	REMOVE
    };
        
    final String EOM = "EOM";
}
