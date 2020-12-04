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
public class ShowTime implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<MovieTime> movieTimes;
	
	
	public ShowTime() {
		
	}
	
	public ShowTime(ArrayList<MovieTime> times) {
		this.setMovieTimes(times);
		
	}
	
	public void cancelReservation(MovieTime time, Seat seat) {
		for (MovieTime t:movieTimes) {
			if(t.getTime() == time.getTime() &&t.getDay() == time.getDay()&&t.getMonth() == time.getMonth()) {
				t.cancelReservation(seat);
			}
		}
	}
	
	public void reserve(MovieTime time, Seat seat) {
		for (MovieTime t:movieTimes) {
			if(t.getTime() == time.getTime() &&t.getDay() == time.getDay()&&t.getMonth() == time.getMonth()) {
				t.reserve(seat);
			}
		}
	}


	
	/**
	 * @return the movieTimes
	 */
	public ArrayList<MovieTime> getMovieTimes() {
		return movieTimes;
	}

	/**
	 * @param movieTimes the movieTimes to set
	 */
	public void setMovieTimes(ArrayList<MovieTime> movieTimes) {
		this.movieTimes = movieTimes;
	}


}
