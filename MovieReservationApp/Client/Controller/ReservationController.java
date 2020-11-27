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
	
	public void displayListofSeat(ArrayList<String> seats) {
		int count = 0;
		for (String i : seats) {
			JButton button = (JButton) selectGUI.getTimeButtons()[count];
			if (i.equals("TAKEN")) {
				button.setForeground(new java.awt.Color(255, 0, 110));
			}
			button.setText(i);
			count++;
		}
	}
	
	public void displayTicket() {
		String ticketID = Integer.toString(modelCtrl.getTheTicket().getTicketId());
		String showtime = modelCtrl.getTheTicket().getTime().getTime();
		String seat = modelCtrl.getTheTicket().getSeat().toString();
		String movie = modelCtrl.getTheTicket().getMovie().getTitle();
		String price = String.format( "%.2f",modelCtrl.getTheTicket().getPrice());
		
		
	}

	

	// back button pressed start up login view
	public class MBackSelected implements ActionListener {

		@Override
		// need to modify this later once GUI is completed
		public void actionPerformed(ActionEvent arg0) {
			selectGUI.getCl().show(selectGUI.getLayerPane(),"card4");
		}

	}
	
	public class TBackSelected implements ActionListener {

		@Override
		// need to modify this later once GUI is completed
		public void actionPerformed(ActionEvent arg0) {
			selectGUI.getCl().show(selectGUI.getLayerPane(),"card5");
		}

	}
	
	public class SBackSelected implements ActionListener {

		@Override
		// need to modify this later once GUI is completed
		public void actionPerformed(ActionEvent arg0) {
			selectGUI.getCl().show(selectGUI.getLayerPane(),"card11");
		}

	}
	
	public class iBackSelected implements ActionListener {

		@Override
		// need to modify this later once GUI is completed
		public void actionPerformed(ActionEvent arg0) {
			selectGUI.getCl().show(selectGUI.getLayerPane(),"card10");
		}

	}
	

	// movie button action listener
	public class MovieButton implements ActionListener {

		@Override
		/**
		 * Creates an information packet and send it out to the server, this packet will
		 * include the players row and column
		 */
		public void actionPerformed(ActionEvent e) {
			JButton theButton = (JButton) e.getSource();
			selectGUI.getCl().show(selectGUI.getLayerPane(), "card11");
			displayListofTime(modelCtrl.createListofTime(theButton.getText()));
		}
	}
	
	// time button action listener
	public class TimeButton implements ActionListener {

		@Override
		/**
		 * Creates an information packet and send it out to the server, this packet will
		 * include the players row and column
		 */
		public void actionPerformed(ActionEvent e) {
			JButton theButton = (JButton) e.getSource();
			selectGUI.getCl().show(selectGUI.getLayerPane(), "card10");
			displayListofSeat(modelCtrl.createListSeat(theButton.getText()));
		}
	}
	
	// seat button action listener
	public class SeatButton implements ActionListener {

		@Override
		/**
		 * Creates an information packet and send it out to the server, this packet will
		 * include the players row and column
		 */
		public void actionPerformed(ActionEvent e) {
			JButton theButton = (JButton) e.getSource();
			modelCtrl.reserveSeat(theButton.getText());
			if(modelCtrl.checkUser()) {
				selectGUI.getCl().show(selectGUI.getLayerPane(), "card9");
			}
			else {
				//create ticket;
				if(modelCtrl.constructRticket()) {
					displayTicket();
				}
				else {
					displayError();
				}
				selectGUI.getCl().show(selectGUI.getLayerPane(), "card8");
				//display the ticket
			}
			
		}
	}

	public class infoSubmit implements ActionListener {

		@Override
		// need to modify this later once GUI is completed
		public void actionPerformed(ActionEvent arg0) {
			String bank = selectGUI.getBankField().getText();
			String voucher = selectGUI.getVoucherField().getText();
			String email = selectGUI.getEmailField().getText();
			//create ticket;
			if(modelCtrl.constructOticket(email, voucher, bank)) {
				displayTicket();
			}else {
				displayError();
			}
			selectGUI.getCl().show(selectGUI.getLayerPane(),"card8");
			//display the ticket
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
