package Server;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.EmailManager;
import Model.Message;

public class CancellationServerController {
	private DBController dbCtrl;
	private Message outMessage; 
	
	public CancellationServerController(DBController db) {
		this.dbCtrl = db;
		outMessage = new Message();
		
	}
	
	public Message handle(Message message) {
		int choice = message.getAction();
		switch(choice) {
		case 1:
			int receiptId = (int) message.getObject();
			ResultSet rs = dbCtrl.getVoucherStatus(receiptId);
			try {
				rs.next();
				String vouch = rs.getString("voucher_require");
				if(vouch.equals("Y")) {
					generateVoucherEmail();
				}
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
			boolean success = dbCtrl.cancelTicket(receiptId);
			outMessage.setObject(success);
			break;
			
		}
		return outMessage;
		
	}
	
	public void generateVoucherEmail() {
		ResultSet rs = dbCtrl.createVoucher();
		try {
			rs.next();
			String vouch_id = rs.getString("voucher_id");
			String exp_date = rs.getString("exp_date").toString();
			EmailManager eM = new EmailManager();
			eM.setExpDate(exp_date);
			eM.setVouchID(vouch_id);
			eM.emailVoucher();
		} catch (SQLException e) {
			System.out.println("failed to create voucher email");
			e.printStackTrace();
			return;
		}
		
	}
}
