/**
 * 
 */
package Client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Client.View.SelectGUI;
import Model.Message;

/**
 * @author Thien Nguyen
 * This controller handles the cancellation operations
 *
 */
public class CancellationController {
	private SelectGUI selectGUI;
	private ModelController modelCtrl;
	private Message outMessage;
	private Message inMessage;
	private SelectionController selectCtrl;

	public CancellationController(SelectGUI selectionView, ModelController model) {
		this.selectGUI = selectionView;
		this.modelCtrl = model;
		outMessage = new Message();
		inMessage = new Message();
		selectGUI.addCancelButtonListener(new CancelSubmit(), new CBackSelected());
	}
	
	public void startView() {
		selectGUI.getCl().show(selectGUI.getLayerPane(),"card7");

	}


	public class CBackSelected implements ActionListener {

		@Override
		// need to modify this later once GUI is completed
		public void actionPerformed(ActionEvent arg0) {
			selectGUI.getCl().show(selectGUI.getLayerPane(), "card4");
		}

	}

	public class CancelSubmit implements ActionListener {

		@Override
		// need to modify this later once GUI is completed
		public void actionPerformed(ActionEvent arg0) {
			String receipt = selectGUI.getReceipt().getText();
			if(modelCtrl.checkReceipt(receipt)) {
				selectGUI.getResultLabel().setText("SUCCESSFULLY CANCELLED");
			}
			else {
				selectGUI.getResultLabel().setText("CANCELLATION FAILED");
			}
			selectGUI.getResultLabel().setVisible(true);
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
