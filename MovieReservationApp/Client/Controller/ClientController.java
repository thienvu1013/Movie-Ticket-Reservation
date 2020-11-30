/**
 * 
 */
package Client.Controller;

import java.io.IOException;
import java.net.Socket;

import Model.Message;
import Model.ObjectReader;
import Model.ObjectWriter;

/**
 * @author Thien Nguyen
 * This class handles the communication between client and server on the client side
 *
 */
public class ClientController {
	private Socket theSocket;
	private ObjectReader reader;
	private ObjectWriter writer;
	private Message theMessage = null;
	
	public ClientController(String servername, int portname) {
		Socket theSocket;
		try {
			theSocket = new Socket(servername, portname);
			reader = new ObjectReader(theSocket);	
			writer = new ObjectWriter(theSocket);
			
		} catch (IOException e) {
			System.out.println("Client failed to create socket");
			e.printStackTrace();
		}
		
	}
	
	public Message getMessage() {
		theMessage = reader.read();
		return theMessage;
	}
	
	public void sendMessage(Message message) {
		writer.write(message);
	}

	public Socket getTheSocket() {
		return theSocket;
	}

	public void setTheSocket(Socket theSocket) {
		this.theSocket = theSocket;
	}
	
	
}
