/**
 * 
 */
package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Client.View.SelectGUI;
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

	private SelectGUI selectGUI;
	private ModelController modelCtrl;
	private boolean logginIn = false;
	private RegisteredUser user;
	private Message outMessage;
	private Message inMessage;
	private SelectionController selectCtrl;
	
	
	//add GUI to constructor
	public LoginController(SelectGUI selectionView, ModelController model) {

		this.setSelectGUI(selectionView);
		this.modelCtrl = model;
		user = new RegisteredUser();
		outMessage = new Message();
		inMessage = new Message();
	}
	

	public void startView() {
		selectGUI.getCl().show(selectGUI.getLayerPane(),"card3");
		selectGUI.addLoginListener(new LoginButtonListener());
	}
	
	

	//need to update once we know the action case for loggin in
	public void verifyUser() {
		user.setEmail(selectGUI.getUsernameField().getText());
		user.setPassword(selectGUI.getPasswordField().getPassword().toString());
		outMessage.setAction(1);
		outMessage.setObject(this.getUser());
		modelCtrl.sendMessage(outMessage);
		inMessage = modelCtrl.readMessage();

		//action 1 for server side - check user credential

		if(inMessage.getAction() ==1) {
			accept();
		}
		else {
			System.out.println("User not verified");
			deny();
		}
	}

	public void accept() {
		selectCtrl.startSecondary();
	}
	
	public void deny() {
		selectGUI.getUsernameField().setText("INVALID CREDENTIALS");
	}
	
	
	public class LoginButtonListener implements ActionListener{

		@Override
		//need to modify this later once GUI is completed 
		public void actionPerformed(ActionEvent arg0) {
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


	/**
	 * @return the selectGUI
	 */
	public SelectGUI getSelectGUI() {
		return selectGUI;
	}


	/**
	 * @param selectGUI the selectGUI to set
	 */
	public void setSelectGUI(SelectGUI selectGUI) {
		this.selectGUI = selectGUI;
	}

}
