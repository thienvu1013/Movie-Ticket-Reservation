/**
 * 
 */
package Model;

import java.io.Serializable;

/**
 * @author thien nguyen
 *
 */
public class Seat implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rowNum;
	private String rowLetter;
	private boolean taken = false;
	
	public Seat() {
		
	}
	
	public Seat(int rowNum, String rowLetter) {

	}
	
	
	public void cancelReservation() {
		this.taken = false;
	}
	
	public void reserve() {
		this.taken = true;
	}
	
	

	/**
	 * @return the rowNum
	 */
	public int getRowNum() {
		return rowNum;
	}

	/**
	 * @param rowNum the rowNum to set
	 */
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	/**
	 * @return the rowLetter
	 */
	public String getRowLetter() {
		return rowLetter;
	}

	/**
	 * @param rowLetter the rowLetter to set
	 */
	public void setRowLetter(String rowLetter) {
		this.rowLetter = rowLetter;
	}

	/**
	 * @return the taken
	 */
	public boolean isTaken() {
		return taken;
	}

	/**
	 * @param taken the taken to set
	 */
	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	@Override
	public String toString() {
		return rowNum+"-"+rowLetter;
	}
}
