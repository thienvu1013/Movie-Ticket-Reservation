/**
 * 
 */
package Client.Controller;

import java.util.ArrayList;

import Model.Message;
import Model.Movie;
import Model.MovieTime;
import Model.OrdinaryUser;
import Model.RegisteredUser;
import Model.Seat;
import Model.ShowTime;
import Model.Ticket;
import Model.TicketManager;
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
	MovieTime theMovietime;
	ArrayList<Seat> seatList;
	Seat theSeat;
	Ticket theTicket;
	TicketManager tManager;

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
	
	public void setRUser(RegisteredUser user) {
		this.user = user;
	}
	
	public void setOUser() {
		this.user = new OrdinaryUser();
	}
	
	//true if ordinary false if registered
	public boolean checkUser() {
		if(this.user instanceof OrdinaryUser) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean constructRticket() {
		//set controller maybe
		outMessage.setController("reservation");
		outMessage.setAction(2);
		tManager = new TicketManager();
		this.theTicket= tManager.generateTicket(this.user, theMovietime, theSeat, theMovie);
		outMessage.setObject(theTicket);
		clientCtrl.sendMessage(outMessage);
		inMessage = clientCtrl.getMessage();
		if(inMessage.getInfo().equals("PASS")) {
			this.theTicket = (Ticket)inMessage.getObject();
			return true;
		}else {
			return false;
		}
	}
	
	public boolean constructOticket(String email, String vouch, String bank) {
		this.user.setBankInfo(bank);
		this.user.setEmail(email);
		tManager = new TicketManager();
		this.theTicket= tManager.generateTicket(this.user, theMovietime, theSeat, theMovie);
		outMessage.setController("reservation");
		outMessage.setAction(3);
		outMessage.setInfo(vouch);
		outMessage.setObject(this.theTicket);
		clientCtrl.sendMessage(outMessage);
		inMessage = clientCtrl.getMessage();
		if(inMessage.getInfo().equals("PASS")) {
			this.theTicket = (Ticket)inMessage.getObject();
			return true;
		}else {
			return false;
		}
	}
	
	public boolean reserveTicket() {
		outMessage.setController("reservation");
		outMessage.setAction(4);
		clientCtrl.sendMessage(outMessage);
		inMessage = clientCtrl.getMessage();
		boolean success = (boolean) inMessage.getObject();
		return success;
		
	}
	
	public void reverseTicket() {
		outMessage.setController("reservation");
		outMessage.setAction(5);
		clientCtrl.sendMessage(outMessage);
		inMessage = clientCtrl.getMessage();
		inMessage = new Message();
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> createListofMovies(Message message) {
		this.movies =(ArrayList<Movie>) message.getObject();
		ArrayList<String> listofMovies = new ArrayList<String>();
		for(Movie m: this.movies) {
			String id = Integer.toString(m.getMovieID());
			String title = m.getTitle();
			String result = id+"-"+title;
			listofMovies.add(result);
		}
		return listofMovies;
	}
	

	
	public ArrayList<String> createListofTime(String movietext) {
		String[] info = movietext.split("-");
		int id = Integer.parseInt(info[0]);
		for(Movie m: this.movies) {
			if(m.getMovieID()==id) {
				setTheMovie(m);
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
	
	public ArrayList<String> createListSeat(String timetext){
		ArrayList<MovieTime> times = theShowtime.getMovieTimes();
		for(MovieTime m: times) {
			if(m.getTime().equals(timetext)) {
				this.theMovietime = m;
				ArrayList<String> seats = createSeats(m);
				return seats;
			}
		}
		return null;
	}
	
	public ArrayList<String> createSeats(MovieTime m){
		ArrayList<String> result = new ArrayList<String>();
		this.seatList = m.getSeatList();
		for(Seat  s : seatList) {
			String seat;
			if (!s.isTaken()) {
				seat = s.toString();
			}
			else {
				seat = "X";
			}
			result.add(seat);
		}
		return result;
	}
	
	public void reserveSeat(String seattext) {
		String[] info = seattext.split("-");
		String seatL = info[1];
		int seatN = Integer.parseInt(info[0]);
		for(Seat s:this.seatList) {
			if(s.getRowLetter().equals(seatL) && s.getRowNum()==seatN) {
				this.theSeat = new Seat();
				this.theSeat.setRowLetter(seatL);
				this.theSeat.setRowNum(seatN);
			}
		}
	}
	
	public boolean checkReceipt(String receipt) {
		int id = Integer.parseInt(receipt);
		outMessage.setController("cancellation");
		outMessage.setAction(1);
		outMessage.setObject(id);
		clientCtrl.sendMessage(outMessage);
		inMessage = clientCtrl.getMessage();
		boolean success = (boolean) inMessage.getObject();
		return success;
	}
	
	public boolean payMembership(ArrayList<String> cred) {
		outMessage.setController("membership");
		outMessage.setAction(1);
		outMessage.setObject(cred);
		clientCtrl.sendMessage(outMessage);
		inMessage = clientCtrl.getMessage();
		boolean success = (boolean) inMessage.getObject();
		return success;
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

	/**
	 * @return the theShowtime
	 */
	public ShowTime getTheShowtime() {
		return theShowtime;
	}

	/**
	 * @param theShowtime the theShowtime to set
	 */
	public void setTheShowtime(ShowTime theShowtime) {
		this.theShowtime = theShowtime;
	}

	/**
	 * @return the theMovietime
	 */
	public MovieTime getTheMovietime() {
		return theMovietime;
	}

	/**
	 * @param theMovietime the theMovietime to set
	 */
	public void setTheMovietime(MovieTime theMovietime) {
		this.theMovietime = theMovietime;
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

	/**
	 * @return the theSeat
	 */
	public Seat getTheSeat() {
		return theSeat;
	}

	/**
	 * @param theSeat the theSeat to set
	 */
	public void setTheSeat(Seat theSeat) {
		this.theSeat = theSeat;
	}

	/**
	 * @return the theTicket
	 */
	public Ticket getTheTicket() {
		return theTicket;
	}

	/**
	 * @param theTicket the theTicket to set
	 */
	public void setTheTicket(Ticket theTicket) {
		this.theTicket = theTicket;
	}

	/**
	 * @return the tManager
	 */
	public TicketManager gettManager() {
		return tManager;
	}

	/**
	 * @param tManager the tManager to set
	 */
	public void settManager(TicketManager tManager) {
		this.tManager = tManager;
	}
}
