/**
 * 
 */
package Client.Controller;

import java.util.ArrayList;

import Model.Message;
import Model.Movie;
import Model.MovieTime;
import Model.ShowTime;
import Model.User;

/**
 * @author Thien Nguyen
 * This class handles manipulations of the model
 */
public class ModelController {
	ClientController clientCtrl;
	User user;
	Message outMessage;
	Message inMessage;
	ArrayList<Movie> movies;
	Movie theMovie;
	ShowTime theShowtime;

	public ModelController(ClientController cc) {
		this.clientCtrl = cc;
		this.outMessage = new Message();
		this.inMessage = new Message();
			
	}
	
	public Message readMessage() {
		inMessage = this.clientCtrl.getMessage();
		return inMessage;
	}

	public void sendMessage(Message m) {
		this.clientCtrl.sendMessage(m);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> createListofMovies(Message message) {
		this.movies =(ArrayList<Movie>) message.getObject();
		ArrayList<String> listofMovies = new ArrayList<String>();
		for(Movie m: this.movies) {
			String id = Integer.toString(m.getMovieID());
			String title = m.getTitle();
			String price = Double.toString(m.getPrice());
			String result = id+":"+ title + "\n" + price;
			listofMovies.add(result);
		}
		return listofMovies;
	}
	
	public ArrayList<String> createListofTime(String movietext) {
		String[] info = movietext.split(":");
		int id = Integer.parseInt(info[0]);
		for(Movie m: this.movies) {
			if(m.getMovieID()==id) {
				ArrayList<String> times;
				times = createMovieTimes(m.getShowTime());
				return times;
			}
		}
		return null;

	}
	
	public ArrayList<String> createMovieTimes(ShowTime theShowtime){
		this.theShowtime = theShowtime;
		ArrayList<MovieTime> timeList = theShowtime.getMovieTimes();
		ArrayList<String>times = new ArrayList<String>();
		for(MovieTime mt: timeList) {
			times.add(mt.getTime());
		}
		return times;
		
	}

	/**
	 * @return the clientCtrl
	 */
	public ClientController getClientCtrl() {
		return clientCtrl;
	}

	/**
	 * @param clientCtrl the clientCtrl to set
	 */
	public void setClientCtrl(ClientController clientCtrl) {
		this.clientCtrl = clientCtrl;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the outMessage
	 */
	public Message getOutMessage() {
		return outMessage;
	}

	/**
	 * @param outMessage the outMessage to set
	 */
	public void setOutMessage(Message outMessage) {
		this.outMessage = outMessage;
	}

	/**
	 * @return the inMessage
	 */
	public Message getInMessage() {
		return inMessage;
	}

	/**
	 * @param inMessage the inMessage to set
	 */
	public void setInMessage(Message inMessage) {
		this.inMessage = inMessage;
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

	/**
	 * @return the theMovie
	 */
	public Movie getTheMovie() {
		return theMovie;
	}

	/**
	 * @param theMovie the theMovie to set
	 */
	public void setTheMovie(Movie theMovie) {
		this.theMovie = theMovie;
	}
}
