package Model;

import java.sql.Date;
import java.util.Calendar;
/**
 * @author Thien Nguyen
 *
 */
public class RegisteredUser extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//R for register O for ordinary
	private String type;
	private Date regDate;
	private Date expDate;
	private String password;
	private boolean isRegister;
	
	
	//constructor
	public RegisteredUser() {
		super();
		
	}
	
	//constructor
	public RegisteredUser(String name, String email, String bankInfo, String type, String password) {
		super(name,email,bankInfo);
		Calendar cal = Calendar.getInstance();
		this.type = type;
		this.password = password;
		this.regDate = new Date(cal.getTime().getTime());
		cal.add(Calendar.MONTH, 12);
		this.expDate = (Date) cal.getTime();
	}
	
	
	
	
	//check to see if the user is registered and not reach expiry date
	public boolean isRegistered() {
		boolean registered;
		Date today =(Date) Calendar.getInstance().getTime();
		if (today.before(expDate) || today.equals(expDate)) {
			registered = true;
		}
		else {
			registered = false;
		}
		return registered;
	}
	


	
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the regDate
	 */
	public Date getRegDate() {
		return regDate;
	}

	/**
	 * @param regDate the regDate to set
	 */
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
		Calendar cal = Calendar.getInstance();cal.add(Calendar.MONTH, 12);
		this.expDate = (Date) cal.getTime();
		
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the isRegister
	 */
	public boolean isRegister() {
		return isRegister;
	}

	/**
	 * @param isRegister the isRegister to set
	 */
	public void setRegister(boolean isRegister) {
		this.isRegister = isRegister;
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
