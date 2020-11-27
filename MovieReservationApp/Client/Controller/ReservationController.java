/**
 * 
 */
package Client.Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.View.SelectionGUI;
import Model.Message;
import Model.RegisteredUser;


/**
 * @author Thien Nguyen
 * This class handles reservation operation
 *
 */
public class ReservationController {

	//add loggin GUI here
		private SelectionGUI selectGUI;
		private ModelController modelCtrl;
		private Message outMessage;
		private Message inMessage;
		private SelectionController selectCtrl;
		
		
		//add GUI to constructor
		public ReservationController(SelectionGUI selectionView, ModelController model) {
			this.selectGUI = selectionView;
			this.modelCtrl = model;
			outMessage = new Message();
			inMessage = new Message();
		}
		
		public void startView() {
			//selectGUI.getCardLayout().show(selectGUI.getPromptPane(),"4");
			//selectionGUI.addSelectButton(......);
		}
		
		//logout button pressed start up login view
		public class LogoutButtonSelected implements ActionListener{

			@Override
			//need to modify this later once GUI is completed 
			public void actionPerformed(ActionEvent arg0) {
				//Action 2 - server should erase all saved data and bring back to homepage
				outMessage.setAction(2);
				modelCtrl.sendMessage(outMessage);
				//selectGUI.getCardLayout().show(selectGUI.getPromptPane(),"1");
			}
			
		}
		
		//back button pressed start up login view
		public class Back_3ButtonSelected implements ActionListener{

			@Override
			//need to modify this later once GUI is completed 
			public void actionPerformed(ActionEvent arg0) {
				//selectGUI.getCardLayout().show(selectGUI.getPromptPane(),"1");
			}
					
		}
		
		//moviebutton action listener
		public class MovieButton implements ActionListener{

			@Override
			/**
			 * Creates an information packet and send it out to the server, this packet will include the players row and column
			 */
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i<6; i++) {
					//get the button thats been pressed
					if (selectionGui.getMovie()[i] == (JButton) e.getSource()) {
						outMessage.setInfo(selectionGUI.getButton.getText());
						outMessage.setAction(2);
						
						inMessage =modelCtrl.getMessage();
						gui.disableButtons();
						return;
					}
				}
		}
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		

		/**
		 * @return the selectGUI
		 */
		public SelectionGUI getSelectGUI() {
			return selectGUI;
		}


		/**
		 * @param selectGUI the selectGUI to set
		 */
		public void setSelectGUI(SelectionGUI selectGUI) {
			this.selectGUI = selectGUI;
		}


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
		 * @return the user
		 */
		public RegisteredUser getUser() {
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