package Server;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Message;
import Model.ObjectReader;
import Model.ObjectWriter;
import Model.Ticket;

public class ServerApp {
	private ObjectReader reader;
	private ObjectWriter writer;;
	private Socket aSocket;
	private Message message;
	private ServerSocket serverSocket;
	private ModelController modelController;
	

	/**
	 * Construct a Server with Port 9090
	 */
	public ServerApp() {
		try {
			serverSocket = new ServerSocket(9090);
			System.out.println("Server is now running.");
			aSocket = serverSocket.accept();
			reader = new ObjectReader(aSocket);	
			writer = new ObjectWriter(aSocket);
			this.message = new Message();
			this.message = new Message();
		} catch (IOException e) {
		}
	}

	/**
	 * communicating with Client.
	 * 
	 * @throws IOException
	 */
	public void communicate() throws IOException {
		StringBuffer line = null;
		message = reader.read();
		//writer.write(theMessage);
		
		
		int task = message.getAction();
		
		switch(task) {
		case 2:
			
			Ticket theTicket = (Ticket) message.getObject();
			message.setObject(theTicket);
			
			writer.write(message);
			
			
			break;
		case 3:
			
			theTicket = (Ticket) message.getObject();
			message.setObject(theTicket);
			
			writer.write(message);
			
			break;
			
		case 4:
			
			theTicket = (Ticket) message.getObject();
			message.setObject(theTicket);
			
			writer.write(message);
			
			break;
		}
	
		
		serverSocket.close();
	}

	/**
	 * Run the Server.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ServerApp ds = new ServerApp();
		ds.communicate();
	}
}
