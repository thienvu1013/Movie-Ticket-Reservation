package Server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.EmailManager;
import Model.Message;
import Model.Movie;
import Model.MovieTime;
import Model.Seat;
import Model.ShowTime;
import Model.Ticket;


public class ReservationServerController {
	private DBController dbCtrl;
	private Message outMessage; 
	private String controller = "reservation";
	private Ticket theTicket;
	private int ticketID=0;
	private double price;
	private String userID;
	private String feedback;
	private int voucher = -1;
	
	private boolean vouchRequire = false;
	
	public ReservationServerController(DBController db) {
		this.dbCtrl = db;
		outMessage = new Message();
		outMessage.setController(controller);
		
	}
	
	public Message handle(Message message) {
		int time;
		String seatL;
		int seatN;
		int movie;
		boolean success;
		String bank;
		int choice = message.getAction();
		switch (choice) {
		//return movielist
		case 1:
			ArrayList<Movie> thelist = createMovieList();
			outMessage.setObject(thelist);
			break;
		//reserve spot for Registered User
		case 2:
			theTicket = (Ticket) message.getObject();
			userID = theTicket.getUser().getEmail();
			time = Integer.parseInt(theTicket.getTime().getTime().split(":")[0]);
			seatL = theTicket.getSeat().getRowLetter();
			seatN = theTicket.getSeat().getRowNum();
			movie = theTicket.getMovie().getMovieID();
			this.ticketID = dbCtrl.createRTicket(movie,userID,time,seatL,seatN);
			feedback = checkTicket();
			outMessage.setInfo(feedback);
			outMessage.setObject(theTicket);
			break;
		//reserve spot for Ordinary User
		case 3:
			try {
				boolean valid=false;
				theTicket = (Ticket) message.getObject();
				String thevoucher = message.getInfo();
				System.out.println(thevoucher);
				if(thevoucher.equals("")) {
					price = theTicket.getPrice();
				}
				else {
					voucher = Integer.parseInt(message.getInfo());
					valid = dbCtrl.checkVoucher(voucher);
				}
				userID = theTicket.getUser().getEmail();
				bank = theTicket.getUser().getBankInfo();
				time =  Integer.parseInt(theTicket.getTime().getTime().split(":")[0]);
				seatL = theTicket.getSeat().getRowLetter();
				seatN = theTicket.getSeat().getRowNum();
				movie = theTicket.getMovie().getMovieID();
				if(valid) {
					price = theTicket.getPrice()*0.85;
				}
				else {
					price = theTicket.getPrice();
				}
				vouchRequire = true;
				//create ticket if not already exist, if the seat already taken the ticketID = 0
				this.ticketID = dbCtrl.createOTicket(movie,userID,time,seatL,seatN,bank);
				theTicket.setTicketId(ticketID);
				theTicket.setPrice(price);
				feedback = checkTicket();
				outMessage.setInfo(feedback);
				outMessage.setObject(theTicket);
				break;
				
			}catch(Exception e){
				System.out.println("incorrect voucher format");
				outMessage.setObject(false);
				e.printStackTrace();
				break;
			}
		//pay receipt
		case 4:
			System.out.println("pay ticket called");
			success =generateEmail(dbCtrl.createReceipt(this.ticketID,this.vouchRequire,this.price,this.voucher));
			outMessage.setObject(success);
			break;
		//cancel reservation
		case 5:
			System.out.println("cancel called");
			success = dbCtrl.deleteTicket(ticketID);
			outMessage.setObject(success);
			break;
		}
		
		return outMessage;
		
		
	}
	
	public boolean generateEmail(ResultSet rs) {
		try {
			rs.next();
			int receiptID = rs.getInt("receipt_id");
			 String[]info = dbCtrl.getInfo(this.ticketID,receiptID);
			 EmailManager eM = new EmailManager();
			 eM.setReceiptID(Integer.toString(receiptID));
			 eM.setMovie(info[0]);
			 eM.setTime(info[1]);
			 eM.setSeat(info[2]);
			 eM.setUser(info[3]);
			 eM.setDate(info[4]);
			 eM.setPayment(info[5]);
			 eM.emailTicket();
			 System.out.println("email created");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public String checkTicket() {
		if(this.ticketID==0) {
			return "FAIL";
		}
		return "PASS";
	}
	
	public ArrayList<Movie> createMovieList(){
		ArrayList<Integer> ids = getMovieIds();
		ArrayList<Movie> theList = new ArrayList<Movie>();
		for(int i:ids) {
			String title = dbCtrl.getTitle(i);
			double price = dbCtrl.getPrice(i);
			ShowTime time = createShowTime(dbCtrl.getTimeList(i),i);
			Movie theMovie = new Movie(i,title,time,price);
			theList.add(theMovie);
		}
		return theList;
	}
	
	
	
	public ShowTime createShowTime(ResultSet rs,int movieID) {
		ShowTime time = new ShowTime();
		ArrayList<MovieTime> theList = new ArrayList<MovieTime>();
		ArrayList<Integer>timeID = createTimeList(rs);
		for (int i: timeID) {
			ArrayList<Seat> seats = createSeatList(dbCtrl.getSeatList(i,movieID));
			MovieTime mt = new MovieTime();
			mt.setSeatList(seats);
			mt.setTime(Integer.toString(i)+":00");
			theList.add(mt);
		}
		time.setMovieTimes(theList);
		return time;
	}
	
	
	
	public ArrayList<Integer> createTimeList(ResultSet rs){
		ArrayList<Integer>timeID = new ArrayList<Integer>();
		try {
			if(!rs.next()) {
				return null;
			}else {
				do {
					timeID.add(rs.getInt("showtime"));
				}while(rs.next());
			}
		}catch(Exception e) {
			System.out.println("Failed to create list of movie");
		}
		return timeID;
	}
	
	
	
	public ArrayList<Seat> createSeatList(ResultSet rs){
		ArrayList<Seat> seats = new ArrayList<Seat>();
		try {
			if(!rs.next()) {
				return null;
			}else {
				do { 
					int rowNum = rs.getInt("row_num");
					String rowLetter = rs.getString("row_letter");
					String isTaken = rs.getString("taken");
					boolean taken;
					if(isTaken.equals("N")) {
						taken  = false;
					}else {
						taken = true;
					}
					Seat s = new Seat();
					s.setRowLetter(rowLetter);
					s.setRowNum(rowNum);
					s.setTaken(taken);
					seats.add(s);
				}while(rs.next());
			}
		}catch(Exception e) {
			System.out.println("Failed to create list of movie");
		}
		return seats;
	}
	
	
	
	public ArrayList<Integer> getMovieIds(){
		ArrayList<Integer> movieId = new ArrayList<Integer>();
		ResultSet rs = dbCtrl.getMovieIds();
		try {
			if(!rs.next()) {
				return null;
			}else {
				do { 
					movieId.add(rs.getInt("movie_id"));
				}while(rs.next());
			}
		}catch(Exception e) {
			System.out.println("Failed to create list of movie");
		}
		
		
		return movieId;	
	}

	/**
	 * @return the dbCtrl
	 */
	public DBController getDbCtrl() {
		return dbCtrl;
	}
	
	/**
	 * @param dbCtrl the dbCtrl to set
	 */
	public void setDbCtrl(DBController dbCtrl) {
		this.dbCtrl = dbCtrl;
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
	 * @return the controller
	 */
	public String getController() {
		return controller;
	}
	
	/**
	 * @param controller the controller to set
	 */
	public void setController(String controller) {
		this.controller = controller;
	}
}
