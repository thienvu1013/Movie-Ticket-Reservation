/**
 * 
 */
package Client.Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import Client.View.SelectGUI;
import Model.Message;


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
		selectGUI.addReservationButtonListener(new LogoutButtonSelected(),
				new MBackSelected(),new TBackSelected(),new SBackSelected(),
				new iBackSelected(),new MovieButton(), new TimeButton(),
				new SeatButton(), new infoSubmit(),new paySubmit(),new cancelButton());
	}

	@SuppressWarnings("unchecked")
	public void startView() {
		selectGUI.getCl().show(selectGUI.getLayerPane(),"card5");
		outMessage.setController("reservation");
		outMessage.setAction(1);
		modelCtrl.sendMessage(outMessage);
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
			if(!modelCtrl.checkUser()) {
				outMessage.setController("login");
				outMessage.setAction(2);
				modelCtrl.sendMessage(outMessage);
				inMessage = modelCtrl.readMessage();
				selectGUI.getEmailField().setText("");
				selectGUI.getVoucherField().setText("");
				selectGUI.getBankField().setText("");
				selectGUI.getUsernameField().setText("");
				selectGUI.getPasswordField().setText("");
				selectGUI.getResultLabel().setVisible(false);
				selectGUI.getMemSuccess().setVisible(false);
				selectGUI.getSuccessLabel().setVisible(false);
				}
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
			JButton button = (JButton) selectGUI.getSeatButtons()[count];
			if (i.equals("X")) {
				button.setForeground(new java.awt.Color(255, 0, 110));
			}
			else {
				button.setForeground(new java.awt.Color(242, 204, 143));
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
		selectGUI.getTicketID().setText(ticketID);
		selectGUI.getTime().setText(showtime);
		selectGUI.getMovie().setText(movie);
		selectGUI.getSeat().setText(seat);
		selectGUI.getPrice().setText(price);
	}
	
	public void displayError() {
		String message = "INVALID INFO";
		selectGUI.getErrorMessage().setText(message);
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
				selectGUI.getCl().show(selectGUI.getLayerPane(),"card8");
			}else {
				displayError();
				selectGUI.getErrorMessage().setVisible(true);
			}
			//display the ticket
		}

	}
	
	public class paySubmit implements ActionListener {

		@Override
		// need to modify this later once GUI is completed
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("PAY CLICKED");
			if(modelCtrl.reserveTicket()) {
				selectGUI.getSuccessLabel().setText("SUCCESS");
				
			}else {
				selectGUI.getSuccessLabel().setText("ERROR");
			}
			selectGUI.getSuccessLabel().setVisible(true);
		}

	}
	
	public class cancelButton implements ActionListener {

		@Override
		// need to modify this later once GUI is completed
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("CANCEL CLICKED");
			// Action 2 - server should erase all saved data and bring back to homepage
			modelCtrl.reverseTicket();
			selectGUI.getCl().show(selectGUI.getLayerPane(), "card4");
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
