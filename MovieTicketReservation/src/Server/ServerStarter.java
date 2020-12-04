package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class ServerStarter {
	private static ServerStarter server;
	private ServerSocket serverSocket;
	private ExecutorService executorService = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		server = new ServerStarter();
		server.runServer();
		System.out.println("Server is row running");

	}
	
	public void runServer() {
		int portNumber = 9090;
		try {
			serverSocket = new ServerSocket(portNumber);
			
			while(true) {
				Socket s = serverSocket.accept();
				ServerController serverCtrl = new ServerController();
				DBController dbCtrl = new DBController();
				CancellationServerController cancelCtrl = new CancellationServerController(dbCtrl);
				ReservationServerController resCtrl = new ReservationServerController(dbCtrl);
				MembershipPaymentController memCtrl = new MembershipPaymentController(dbCtrl);
				LoginServerController logCtrl = new LoginServerController(dbCtrl);
				executorService.submit(new ModelServerController(s,serverCtrl,dbCtrl,cancelCtrl,resCtrl,memCtrl,logCtrl));
			}
		} catch (IOException e) {
			System.out.println("Error accepting connec");
			e.printStackTrace();
		}
		
	}

	/**
	 * @return the executorService
	 */
	public ExecutorService getExecutorService() {
		return executorService;
	}

	/**
	 * @param executorService the executorService to set
	 */
	public void setExecutorService(ExecutorService executorService) {
		this.executorService = executorService;
	}

}
