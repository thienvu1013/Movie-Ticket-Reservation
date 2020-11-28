/**
 * 
 */
package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Client.Controller.CancellationController.CBackSelected;
import Client.Controller.CancellationController.CancelSubmit;
import Client.View.SelectGUI;
import Model.Message;

/**
 * @author Thien Nguyen
 * This class handles the paying for membership operation
 *
 */
public class MembershipController {
	private SelectGUI selectGUI;
	private ModelController modelCtrl;
	private Message outMessage;
	private Message inMessage;
	private SelectionController selectCtrl;

	public MembershipController(SelectGUI selectionView, ModelController model) {
		this.selectGUI = selectionView;
		this.modelCtrl = model;
		outMessage = new Message();
		inMessage = new Message();
		selectGUI.addMemberButtonListener(new MemBackSelected(), new MemPaySubmit());
	}
	
	public void startView() {
		selectGUI.getCl().show(selectGUI.getLayerPane(), "card6");
		
	}
	
	public class MemBackSelected implements ActionListener {

		@Override
		// need to modify this later once GUI is completed
		public void actionPerformed(ActionEvent arg0) {
			selectGUI.getCl().show(selectGUI.getLayerPane(), "card2");
		}

	}
	
	public class MemPaySubmit implements ActionListener {
		
		@Override
		// need to modify this later once GUI is completed
		public void actionPerformed(ActionEvent arg0) {
			String email = selectGUI.getMemEmailField().getText();
			String password = selectGUI.getMemPassField().getText();
			ArrayList<String> credentials = new ArrayList<String>();
			credentials.add(email);
			credentials.add(password);
			if(modelCtrl.payMembership(credentials)) {
				selectGUI.getResultLabel().setText("SUCCESSFULLY RENEW");
			}
			else {
				selectGUI.getResultLabel().setText("RENEWAL FAILED");
			}
			selectGUI.getReceipt().setText("");
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
