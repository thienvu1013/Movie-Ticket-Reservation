/**
 * 
 */
package Model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author Thien Nguyen
 * This class will be responsible for writing messages across socket
 *
 */
public class ObjectWriter {
	private ObjectOutputStream objectOut;
	
	public ObjectWriter(Socket theSocket) {
		try {
			objectOut = new ObjectOutputStream(theSocket.getOutputStream());
		} catch (IOException e) {
			System.out.println("Writer failed to connect to socket");
			e.printStackTrace();
		}
	}
	
	public void write(Message theMessage) {
		try {
			objectOut.writeObject(theMessage);
			objectOut.flush();
			objectOut.reset();
		} catch (IOException e) {
			System.out.println("Writer failed to write object");
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			objectOut.close();
		} catch (IOException e) {
			System.out.println("Writer failed to close socket");
			e.printStackTrace();
		}
	}
}
