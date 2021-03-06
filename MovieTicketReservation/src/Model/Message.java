/**
 * 
 */
package Model;

import java.io.Serializable;

/**
 * @author Thien Nguyen	
 *
 */
public class Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int action;
	private String Controller;
	private String info;
	private Voucher voucher;
	private Serializable object;
	
	public Message() {
		

	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public String getController() {
		return Controller;
	}

	public void setController(String controller) {
		Controller = controller;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Serializable getObject() {
		return object;
	}

	public void setObject(Serializable object) {
		this.object = object;
	}

	/**
	 * @return the voucher
	 */
	public Voucher getVoucher() {
		return voucher;
	}

	/**
	 * @param voucher the voucher to set
	 */
	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
	}
	
}
