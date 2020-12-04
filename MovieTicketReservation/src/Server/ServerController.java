package Server;

import java.io.IOException;
import java.net.Socket;

import Model.Message;
import Model.ObjectReader;
import Model.ObjectWriter;

public class ServerController {
	private ObjectWriter serializer;
	private ObjectReader deserializer;
	private Message theMessage;
	private Socket theSocket;
	
	public ServerController() {
		
	}
	
	
	public void setup(Socket theSocket) {
		serializer = new ObjectWriter(theSocket);
		deserializer = new ObjectReader(theSocket);
		theMessage = null;
		
	}
	
	public void closeClient() {
		try {
			if(theSocket!=null) {
				theSocket.close();
			}
			serializer.close();
			deserializer.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Message recieveMessage() {
		theMessage = deserializer.read();
		return theMessage;
	}
	
	public void sendMessage(Message message) {
		serializer.write(message);
	}



	public Socket getTheSocket() {
		return theSocket;
	}



	public void setTheSocket(Socket theSocket) {
		this.theSocket = theSocket;
	}
}
