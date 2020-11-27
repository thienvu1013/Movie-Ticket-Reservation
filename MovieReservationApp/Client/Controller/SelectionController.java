/**
 * 
 */
package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.View.SelectionGUI;
import Model.Message;

/**
 * @author Thien Nguyen
 * This class handles all operation of reservation 
 */
public class SelectionController {
	private SelectionGUI selectionGUI;
	private CancellationController cancelCtrl;
	private ReservationController resCtrl;
	private MembershipController memCtrl;
	private LoginController logCtrl;
	private ModelController modelCtrl;
	private Message outMessage;
	private Message inMessage;
	private int options = -1;
	
	public SelectionController(SelectionGUI selectionView,CancellationController cancelCtrl, ReservationController resCtrl, MembershipController memCtrl,LoginController logCtrl, ModelController modelCtrl) {
		this.selectionGUI = selectionView;
		this.cancelCtrl = cancelCtrl;
		this.resCtrl = resCtrl;
		this.memCtrl = memCtrl;
		this.logCtrl = logCtrl;
		this.modelCtrl = modelCtrl;	
		logCtrl.setSelectCtrl(this);
		resCtrl.setSelectCtrl(this);
		cancelCtrl.setSelectCtrl(this);
		memCtrl.setSelectCtrl(this);
	}

	
	public void startApp() {
<<<<<<< HEAD
		//this should be card 1
		selectionGUI.setVisible(true);
		//selectionGUI.addSelectButton(......);
=======
		selectionGUI.setVisible(true);
>>>>>>> 9ed9d6df84021b439a41d1e4d6c94dbd6304ce77
	}
	
	//login button pressed start up login view
	public class LoginButtonSelected implements ActionListener{

		@Override
		//need to modify this later once GUI is completed 
		public void actionPerformed(ActionEvent arg0) {
			logCtrl.startView();
			
		}
		
	}
	
	//reservation button pressed start up login view
	public class ReserveButtonSelected implements ActionListener{

		@Override
		//need to modify this later once GUI is completed 
		public void actionPerformed(ActionEvent arg0) {
			resCtrl.startView();
				
		}
			
	}
	
	
	//cancel button pressed start up login view
	public class CancelButtonSelected implements ActionListener{

		@Override
		//need to modify this later once GUI is completed 
		public void actionPerformed(ActionEvent arg0) {
			cancelCtrl.startView();
				
		}
			
	}
	
	//membership button pressed start up login view
	public class MemButtonSelected implements ActionListener{

		@Override
		//need to modify this later once GUI is completed 
		public void actionPerformed(ActionEvent arg0) {
			memCtrl.startView();
				
		}
			
	}
	
<<<<<<< HEAD
	//not a membership button pressed start up login view
		public class NonMemButtonSelected implements ActionListener{

			@Override
			//need to modify this later once GUI is completed 
			public void actionPerformed(ActionEvent arg0) {
				//selectGUI.getCardLayout().show(selectGUI.getPromptPane(),"3");
					
			}
				
		}
		
	
=======
>>>>>>> 9ed9d6df84021b439a41d1e4d6c94dbd6304ce77
	
	
	
	
	
	
	
	
	
	
	
	
	//getters and setters 

	/**
	 * @return the selectionGUI
	 */
	public SelectionGUI getSelectionGUI() {
		return selectionGUI;
	}

	/**
	 * @param selectionGUI the selectionGUI to set
	 */
	public void setSelectionGUI(SelectionGUI selectionGUI) {
		this.selectionGUI = selectionGUI;
	}

	/**
	 * @return the cancelCtrl
	 */
	public CancellationController getCancelCtrl() {
		return cancelCtrl;
	}

	/**
	 * @param cancelCtrl the cancelCtrl to set
	 */
	public void setCancelCtrl(CancellationController cancelCtrl) {
		this.cancelCtrl = cancelCtrl;
	}

	/**
	 * @return the resCtrl
	 */
	public ReservationController getResCtrl() {
		return resCtrl;
	}

	/**
	 * @param resCtrl the resCtrl to set
	 */
	public void setResCtrl(ReservationController resCtrl) {
		this.resCtrl = resCtrl;
	}

	/**
	 * @return the memCtr
	 */
	public MembershipController getMemCtrl() {
		return memCtrl;
	}

	/**
	 * @param memCtr the memCtr to set
	 */
	public void setMemCtr(MembershipController memCtrl) {
		this.memCtrl = memCtrl;
	}

	/**
	 * @return the logCtrl
	 */
	public LoginController getLogCtrl() {
		return logCtrl;
	}

	/**
	 * @param logCtrl the logCtrl to set
	 */
	public void setLogCtrl(LoginController logCtrl) {
		this.logCtrl = logCtrl;
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
}

