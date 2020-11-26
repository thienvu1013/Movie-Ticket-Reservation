/**
 * 
 */
package Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author thien nguyen
 * This class is used to read in objects being sent across socket
 */
public class ObjectReader {
	private ObjectInputStream objectIn;
	private Message theMessage;
	
	public ObjectReader(Socket theSocket) {
		try {
			objectIn = new ObjectInputStream(theSocket.getInputStream());
		} catch (IOException e) {
			System.out.println("Reader failed to connect to socket");
			e.printStackTrace();
		}
		
	}
	
	public Message read() {
		try {
			theMessage = (Message) objectIn.readObject();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Reader failed to read object");
			e.printStackTrace();
		}
		return theMessage;
	}
	
	public void close() {
		try {
			objectIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
