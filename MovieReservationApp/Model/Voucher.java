/**
 * 
 */
package Model;

import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

/**
 * @author Thien Nguyen
 *
 */
public class Voucher{
	private int id;
	private Date expDate;
		
	public Voucher() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 2);
		this.setExpDate((Date) cal.getTime());
		this.setId(generateID());
		
		
	}

	private int generateID() {
		Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
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

	/**
	 * @return the expDate
	 */
	public Date getExpDate() {
		return expDate;
	}

	/**
	 * @param expDate the expDate to set
	 */
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	
}
