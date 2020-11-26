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
	private String diaglog;
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

	public String getDiaglog() {
		return diaglog;
	}

	public void setDiaglog(String diaglog) {
		this.diaglog = diaglog;
	}

	public Serializable getObject() {
		return object;
	}

	public void setObject(Serializable object) {
		this.object = object;
	}
	
}
