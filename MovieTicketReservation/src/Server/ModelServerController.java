package Server;

import java.net.Socket;

import Model.Message;

public class ModelServerController implements Runnable {
	private Socket clientSocket;
	private LoginServerController logCtrl;
	private DBController dbCtrl;
	private CancellationServerController canCtrl;
	private ReservationServerController resCtrl;
	private MembershipPaymentController memCtrl;
	private ServerController serverCtrl;
	private boolean isRunning = true;
	private Message inMessage;
	private Message outMessage;
	
	public ModelServerController(Socket clientSocket,ServerController server, DBController db,
							CancellationServerController cancel, ReservationServerController res,
							MembershipPaymentController mem,LoginServerController logCtrl) {
		this.clientSocket = clientSocket;
		this.serverCtrl = server;
		this.dbCtrl = db;
		this.canCtrl = cancel;
		this.resCtrl = res;
		this.memCtrl = mem;
		this.logCtrl = logCtrl;
	}

	@Override
	public void run() {
		try {
			serverCtrl.setup(clientSocket);
			while(isRunning) {
				inMessage = serverCtrl.recieveMessage();
				if(inMessage.getAction()==-1) {
					break;
				}
				else if(inMessage != null) {
					actionCase(inMessage);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("Client Terminated");
			serverCtrl.closeClient();
		}
		
	}
	
	public void actionCase(Message message) {
		String controller = message.getController();
		switch(controller) {
		case "login":
			serverCtrl.sendMessage(logCtrl.handle(message));
			break;
		case "reservation":
			serverCtrl.sendMessage(resCtrl.handle(message));
			break;
		case "cancellation":
			serverCtrl.sendMessage(canCtrl.handle(message));
			break;
		case "membership":
			serverCtrl.sendMessage(memCtrl.handle(message));
			break;
			
			
		}
	}
	
}
