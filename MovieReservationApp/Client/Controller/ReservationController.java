/**
 * 
 */
package Client.Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import Client.Controller.SelectionController.LoginButtonSelected;
import Client.Controller.SelectionController.MemButtonSelected;
import Client.Controller.SelectionController.NonMemButtonSelected;
import Client.View.SelectGUI;
import Model.Message;
import Model.RegisteredUser;


/**
 * @author Thien Nguyen This class handles reservation operation
 *
 */
public class ReservationController {

	// add loggin GUI here
	private SelectGUI selectGUI;
	private ModelController modelCtrl;
	private Message outMessage;
	private Message inMessage;
	private SelectionController selectCtrl;

	// add GUI to constructor
	public ReservationController(SelectGUI selectionView, ModelController model) {
		this.selectGUI = selectionView;
		this.modelCtrl = model;
		outMessage = new Message();
		inMessage = new Message();
		selectGUI.addReservationnButtonListener(new LogoutButtonSelected(),
				new NonMemButtonSelected(),
				new MemButtonSelected());
	}

	public void startView() {
		selectGUI.getCl().show(selectGUI.getLayerPane(),"card5");
		outMessage.setAction(1);
		inMessage = modelCtrl.readMessage();
		ArrayList<String> listofMovies = modelCtrl.createListofMovies(inMessage);
		displayMovieOptions(listofMovies);
	}

	// logout button pressed start up login view
	public class LogoutButtonSelected implements ActionListener {

		@Override
		// need to modify this later once GUI is completed
		public void actionPerformed(ActionEvent arg0) {
			// Action 2 - server should erase all saved data and bring back to homepage
			outMessage.setAction(2);
			modelCtrl.sendMessage(outMessage);
			selectCtrl.startApp();
		}

	}

	public void actionCase(Message message) {
			int choice = message.getAction();
			switch(choice) {
			//display movie time 
			}
			case 1:
				ArrayList<String> times = message.getObject();
				displayListofTime(times);
				break;
				
			}
	
	// write movies to display
	public void displayMovieOptions(ArrayList<String> movies) {
		int count = 0;
		for(String i:movies) {
			JButton button = (JButton) selectGUI.getMovieButtons()[count];
			button.setText(i);
			count++;
		}
	}

	//loop through the list of time and write them on the 
	public void displayListofTime(ArrayList<String> times) {
		int count = 0;
		for (String i : times) {
			JButton button = (JButton) selectGUI.getTimeButtons()[count];
			button.setText(i);
			count++;
		}
	}

	

	// back button pressed start up login view
	public class Back_3ButtonSelected implements ActionListener {

		@Override
		// need to modify this later once GUI is completed
		public void actionPerformed(ActionEvent arg0) {
			// selectGUI.getCardLayout().show(selectGUI.getPromptPane(),"1");
		}

	}

	// movie button action listener
	public class MovieButton implements ActionListener{

			@Override
			/**
			 * Creates an information packet and send it out to the server, this packet will include the players row and column
			 */
			public void actionPerformed(ActionEvent e) {
					JButton theButton = (JButton) e.getSource();
					selectGUI.getCl().show(selectGUI.getLayerPane(),"card11");
					displayListofTime(modelCtrl.createListofTime(theButton.getText()));
				}
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
