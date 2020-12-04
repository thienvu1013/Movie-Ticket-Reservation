/**
 * 
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Thien Nguyen
 *
 */
public class MovieTime implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String month;
	private String day;
	private String time;
	private ArrayList<Seat> seatList;
	
	public MovieTime() {
		
	}
	
	public MovieTime(String month, String day, String time,ArrayList<Seat> seatList) {
		this.month= month;
		this.day = day;
		this.time = time;
		this.setSeatList(seatList);
	}
	
	public void cancelReservation(Seat seat) {
		for(Seat s: seatList) {
			if(s.getRowLetter().equals(seat.getRowLetter())&&s.getRowNum()==seat.getRowNum()) {
				s.cancelReservation();
			}
		}
	}
	
	public void reserve(Seat seat) {
		for(Seat s: seatList) {
			if(s.getRowLetter().equals(seat.getRowLetter())&&s.getRowNum()==seat.getRowNum()) {
				s.reserve();
			}
		}
	}
	
	
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		String result = "\nDay: "+ day +
						"\nMonth: "+ month +
						"\nTime: "+ time;
		return result;
	}
	/**
	 * @return the seatList
	 */
	public ArrayList<Seat> getSeatList() {
		return seatList;
	}

	/**
	 * @param seatList the seatList to set
	 */
	public void setSeatList(ArrayList<Seat> seatList) {
		this.seatList = seatList;
	}
}
