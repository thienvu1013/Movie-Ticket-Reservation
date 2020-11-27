/**
 * 
 */
package Client;

import Client.Controller.CancellationController;
import Client.Controller.ClientController;
import Client.Controller.LoginController;
import Client.Controller.MembershipController;
import Client.Controller.ModelController;
import Client.Controller.ReservationController;
import Client.Controller.SelectionController;
import Client.View.SelectGUI;

/**
 * @author Thien Nguyen
 * This class signifies the connection of the client
 *
 */
public class ClientApp {
	public static void main(String[] args) {
		int portNumber = 9090;
		String serverName = "localhost";
		//instantiate the view here
		SelectGUI selectionView = new SelectGUI();
		ClientController clientCtrl = new ClientController(serverName, portNumber);
		ModelController modelCtrl = new ModelController(clientCtrl, modelCtrl);
		CancellationController cancelCtrl = new CancellationController(selectionView, modelCtrl);
		ReservationController resCtrl = new ReservationController(selectionView, modelCtrl);
		MembershipController memCtrl = new MembershipController(selectionView, modelCtrl);
		LoginController logCtrl = new LoginController(selectionView, modelCtrl);
		SelectionController selCtrl = new SelectionController(selectionView,cancelCtrl, resCtrl, memCtrl,logCtrl, modelCtrl);
		selCtrl.startApp();
	}
}
