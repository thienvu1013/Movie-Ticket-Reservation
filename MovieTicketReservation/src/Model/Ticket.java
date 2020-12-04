/**
 * 
 */
package Model;

import java.io.Serializable;

/**
 * @author thien nguyen
 *
 */
public class Ticket implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ticketId;
	private User user;
	private MovieTime time;
	private Seat seat;
	private Movie movie;
	private double price;
	
	public Ticket() {
		
	}
	
	public Ticket(int id, User user, MovieTime time, Seat seat, Movie movie) {
		this.ticketId = id;
		this.user = user;
		this.time = time;
		this.seat = seat;
		this.setMovie(movie);
		this.price = movie.getPrice();
	}
	
	
	/**
	 * @return the ticketId
	 */
	public int getTicketId() {
		return ticketId;
	}

	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * @return the customer
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setUser(User customer) {
		this.user = customer;
	}

	/**
	 * @return the time
	 */
	public MovieTime getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(MovieTime time) {
		this.time = time;
	}

	/**
	 * @return the seat
	 */
	public Seat getSeat() {
		return seat;
	}

	/**
	 * @param seat the seat to set
	 */
	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	/**
	 * @return the movie
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * @param movie the movie to set
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
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
}
