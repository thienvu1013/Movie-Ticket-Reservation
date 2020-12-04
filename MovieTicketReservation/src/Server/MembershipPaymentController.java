package Server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.EmailManager;
import Model.Message;

public class MembershipPaymentController {
	private DBController dbCtrl;
	private Message outMessage; 
	
	public MembershipPaymentController(DBController db) {
		this.setDbCtrl(db);
		outMessage = new Message();
		
	}
	
	public Message handle(Message message) {
		int choice = message.getAction();
		switch(choice) {
		case 1:
			ArrayList<String> cred = (ArrayList<String>) message.getObject();
			String user = cred.get(0);
			String pass = cred.get(1);
			ResultSet rs = dbCtrl.renewMembership(user,pass);
			EmailManager eM= new EmailManager();
			try {
				if(rs.next()) {
					eM.setUser(rs.getString("user_email"));
					eM.setExpDate(rs.getDate("exp_date").toString());
					eM.setPayment("$20.00");
					eM.emailPayment();
					outMessage.setObject(true);
				}
				else {
					outMessage.setObject(false);	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		}
		return outMessage;
		
	}

	/**
	 * @return the dbCtrl
	 */
	public DBController getDbCtrl() {
		return dbCtrl;
	}

	/**
	 * @param dbCtrl the dbCtrl to set
	 */
	public void setDbCtrl(DBController dbCtrl) {
		this.dbCtrl = dbCtrl;
	}
}
