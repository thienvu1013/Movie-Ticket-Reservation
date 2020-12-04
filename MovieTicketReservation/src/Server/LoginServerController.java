package Server;

import Model.Message;
import Model.RegisteredUser;

public class LoginServerController {
	private DBController dbCtrl;
	private Message outMessage; 
	private String controller = "login";
	private RegisteredUser myUser;
	public LoginServerController(DBController db) {
		this.dbCtrl = db;
		outMessage = new Message();
		outMessage.setController(controller);
		
	}
	
	public Message handle(Message message) {
		int choice = message.getAction();
		switch (choice) {
		// login
		case 1:
			String email = ((RegisteredUser) message.getObject()).getEmail();
			String password = ((RegisteredUser) message.getObject()).getPassword();
			boolean valid = dbCtrl.verify(email, password);
			if (valid) {
				myUser = new RegisteredUser();
				myUser.setEmail(email);
				myUser.setPassword(password);
				outMessage.setAction(1);
				outMessage.setInfo("User Verified");
			} else {
				outMessage.setAction(0);
				outMessage.setInfo("User Failed");
			}
			break;
		case 2:
			this.myUser = new RegisteredUser();
			outMessage.setInfo("User logout");

		}
		return outMessage;
		
		
	}
	
	
	
	
	
	/**
	 * @return the dbCtrl
	 */
	public DBController getDbCtrl() {
		return dbCtrl;
	}
	/**
	 * @param dbCtrl the dbCtrl to set
	 */
	public void setDbCtrl(DBController dbCtrl) {
		this.dbCtrl = dbCtrl;
	}
	/**
	 * @return the outMessage
	 */
	public Message getOutMessage() {
		return outMessage;
	}
	/**
	 * @param outMessage the outMessage to set
	 */
	public void setOutMessage(Message outMessage) {
		this.outMessage = outMessage;
	}
	/**
	 * @return the controller
	 */
	public String getController() {
		return controller;
	}
	/**
	 * @param controller the controller to set
	 */
	public void setController(String controller) {
		this.controller = controller;
	}

}
