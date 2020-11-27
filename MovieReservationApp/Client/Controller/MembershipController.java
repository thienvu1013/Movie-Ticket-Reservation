/**
 * 
 */
package Client.Controller;

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
