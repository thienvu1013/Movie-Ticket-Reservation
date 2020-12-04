package Model;

import java.io.Serializable;

/**
 * @author Thien Nguyen
 *
 */
public abstract class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String bankInfo;
	
	public User() {
		
	}
	
	public User(String name,String email,String bankinfo) {
		this.email = email;
		this.bankInfo = bankinfo;
		this.setName(name);
	}
	
	
	
	//getter and setter

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the bankInfo
	 */
	public String getBankInfo() {
		return bankInfo;
	}

	/**
	 * @param bankInfo the bankInfo to set
	 */
	public void setBankInfo(String bankInfo) {
		this.bankInfo = bankInfo;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
