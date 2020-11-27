/**
 * 
 */
package Client.Controller;

import Model.Message;
import Model.User;

/**
 * @author Thien Nguyen
 * This class handles manipulations of the model
 */
public class ModelController {
	ClientController clientCtrl;
	User user;
	Message outMessage;
	Message inMessage;

	public ModelController(ClientController cc) {
		this.clientCtrl = cc;
		this.outMessage = new Message();
		this.inMessage = new Message();
			
	}
	
	public Message readMessage() {
		inMessage = this.clientCtrl.getMessage();
		return inMessage;
	}

	public void sendMessage(Message m) {
		this.clientCtrl.sendMessage(m);
	}
	
	
}
