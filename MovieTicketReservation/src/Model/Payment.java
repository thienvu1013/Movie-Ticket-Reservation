/**
 * 
 */
package Model;

import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

/**
 * @author thien nguyen
 *	Payment id should matches with the receipt id?
 */
public class Payment {
	private int id;
	private double amount;
	private Date paidDate;

	public Payment() {

	}

	// when creating a payment automatically record the date
	public Payment(double amount) {
		Calendar cal = Calendar.getInstance();
		this.setPaidDate(new Date(cal.getTime().getTime()));
		this.id = generateID();
		this.setAmount(amount);
	}

	// run this to generate random ID
	private int generateID() {
		Random r = new Random(System.currentTimeMillis());
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the paidDate
	 */
	public Date getPaidDate() {
		return paidDate;
	}

	/**
	 * @param paidDate the paidDate to set
	 */
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
}
