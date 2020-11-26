package Model;

import java.util.ArrayList;

/**
 * @author Thien Nguyen
 * This class should handle all operation done related to movie.
 */
public class MovieManager {
	private ArrayList<Movie> movies;
	
	public MovieManager() {
	
	}
	
	public MovieManager(ArrayList<Movie> movie) {
		this.setMovies(movie);
	}
	
	
	public void cancelReservation(Receipt r) {
		Ticket ticket = r.getTicket();
		Movie movie = ticket.getMovie();
		Seat seat = ticket.getSeat();
		MovieTime time = ticket.getTime();
		for(Movie m: movies) {
			if(m.getMovieID() == movie.getMovieID()) {
				m.cancelReservation(time, seat);
			}
		}
	}
	
	public void reserve(Receipt r) {
		Ticket ticket = r.getTicket();
		Movie movie = ticket.getMovie();
		Seat seat = ticket.getSeat();
		MovieTime time = ticket.getTime();
		for(Movie m: movies) {
			if(m.getMovieID() == movie.getMovieID()) {
				m.reserve(time, seat);
			}
		}
	}

	/**
	 * @return the movies
	 */
	public ArrayList<Movie> getMovies() {
		return movies;
	}

	/**
	 * @param movies the movies to set
	 */
	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}
	
}
