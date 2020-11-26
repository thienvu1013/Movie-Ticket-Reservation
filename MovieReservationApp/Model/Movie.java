package Model;

/**
 * @author Thien Nguyen
 *
 */
public class Movie {
	private String title;
	private ShowTime showTime;
	private int movieID;
	private double price;
	
	
	public Movie(){
		
	}
	
	public Movie(int id,String title, ShowTime time,double price){
		this.movieID = id;
		this.setShowTime(time);
		this.title = title;
		this.price = price;
	}
	
	public void cancelReservation(MovieTime time,Seat seat) {
		showTime.cancelReservation(time,seat);
	}
	
	public void reserve(MovieTime time,Seat seat) {
		showTime.reserve(time,seat);
	}

	
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the movieID
	 */
	public int getMovieID() {
		return movieID;
	}

	/**
	 * @param movieID the movieID to set
	 */
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the showTime
	 */
	public ShowTime getShowTime() {
		return showTime;
	}

	/**
	 * @param showTime the showTime to set
	 */
	public void setShowTime(ShowTime showTime) {
		this.showTime = showTime;
	}
	
	
	
}
