package Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
/**
 * @author Thien Nguyen
 *
 */
public class UserManager {
	private ArrayList<User>userList;
	private double userFee = 20.00;
	
	public UserManager(){
		
	}
	
	public UserManager(ArrayList<User> list) {
		this.userList = list;
	}

	public void payMemberShip(RegisteredUser user) {
		for (User u: userList) {
			if(u.getEmail().equals(user.getEmail())) {
				if(u instanceof RegisteredUser) {
					Calendar cal = Calendar.getInstance();
					Date today = new Date(cal.getTime().getTime());
					//update user status
					((RegisteredUser) u).setRegDate(today);
					int paymentID = generateID();
					Payment newPayment = new Payment(paymentID,userFee);
					Receipt r = new Receipt(user, newPayment);
					EmailManager eM = new EmailManager();
					eM.emailPayment(r);
				}
			}
		}
	}
	
	
	
	
	
	
	
	// run this to generate random ID
	private int generateID() {
		Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
	
	
	/**
	 * @return the userList
	 */
	public ArrayList<User> getUserList() {
		return userList;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
}
