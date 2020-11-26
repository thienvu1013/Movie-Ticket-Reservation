/**
 * 
 */
package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.View.SelectionGUI;
import Model.Message;
import Model.RegisteredUser;
import Model.User;

/**
 * @author Thien Nguyen
 * This controll control the client side log/logout operations
 *
 */
public class LoginController {
	//add loggin GUI here
	private SelectionGUI selectionGUI;
	private ModelController modelCtrl;
	private boolean logginIn = false;
	private RegisteredUser user;
	private Message outMessage;
	private Message inMessage;
	private SelectionController selectCtrl;
	
	
	//add GUI to constructor
	public LoginController(SelectionGUI selectionView, ModelController model) {
		this.selectionGUI = selectionView;
		this.modelCtrl = model;
		user = new RegisteredUser();
		outMessage = new Message();
		inMessage = new Message();
	}
	
	public void startApp(SelectionController selCtrl) {
		this.selectCtrl = selCtrl;
		while(true) {
			if(logginIn == true) {
				break;
			}
			continue;
		}
	}
	
	//need to update once we know the action case for loggin in
	public void verifyUser() {
		outMessage.setAction(1);
		outMessage.setObject(this.getUser());
		modelCtrl.sendMessage(outMessage);
		inMessage = modelCtrl.getMessage();
		
		if(inMessage.getAction() ==1) {
			accept();
		}
		else {
			System.out.println("User not verified");
			deny();
		}
	}
	
	
	
	
	public void startApp() {
		selectionGUI.setVisible(true);
	}
	
	
	public class LoginButtonListener implements ActionListener{

		@Override
		//need to modify this later once GUI is completed 
		public void actionPerformed(ActionEvent arg0) {
			user.setEmail(loginGUI.getUserField().getText());
			user.setPassword(loginGUI.getPassField().getPassword());
			setLoginIn(true);
			verifyUser();
			
		}
		
	}
	
	
	
	
	//getters and setters


	/**
	 * @return the modelCtrl
	 */
	public ModelController getModelCtrl() {
		return modelCtrl;
	}

	/**
	 * @param modelCtrl the modelCtrl to set
	 */
	public void setModelCtrl(ModelController modelCtrl) {
		this.modelCtrl = modelCtrl;
	}

	/**
	 * @return the logginIn
	 */
	public boolean isLogginIn() {
		return logginIn;
	}

	/**
	 * @param logginIn the logginIn to set
	 */
	public void setLogginIn(boolean logginIn) {
		this.logginIn = logginIn;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(RegisteredUser user) {
		this.user = user;
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
	 * @return the inMessage
	 */
	public Message getInMessage() {
		return inMessage;
	}

	/**
	 * @param inMessage the inMessage to set
	 */
	public void setInMessage(Message inMessage) {
		this.inMessage = inMessage;
	}

	/**
	 * @return the selectCtrl
	 */
	public SelectionController getSelectCtrl() {
		return selectCtrl;
	}

	/**
	 * @param selectCtrl the selectCtrl to set
	 */
	public void setSelectCtrl(SelectionController selectCtrl) {
		this.selectCtrl = selectCtrl;
	}

}
