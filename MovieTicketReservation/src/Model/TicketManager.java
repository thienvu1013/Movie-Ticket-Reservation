package Model;
/**
 * @author Thien Nguyen
 *
 */

import java.util.ArrayList;
import java.util.Random;

public class TicketManager {
	private ArrayList<Receipt> receiptList;
	private ArrayList<Voucher> voucherList;
	private MovieManager movieManager;
	private UserManager userManager;
	private EmailManager emailManager;
	
	
	public TicketManager() {
		
	}
	
	public TicketManager(ArrayList<Receipt> rl, ArrayList<Voucher> vl) {
		this.receiptList = rl;
		this.voucherList = vl;
	}
	
	// construct ticket to show to user
	public Ticket generateTicket(User user, MovieTime time, Seat seat, Movie movie) {
		int id = generateID();
		Ticket theTicket = new Ticket(id, user, time, seat, movie);
		return theTicket;
	}
	
	public Ticket applyVoucher(Ticket theTicket, int v) {
		Ticket ticket = theTicket;
		if(verifyVoucher(v)){
			ticket.setPrice(ticket.getPrice()*0.15);
			return ticket;
		}
		else {
			return ticket;
		}
	}

	
	// run this when user accept the ticket
	public Receipt buyTicket(Ticket ticket, Payment payment ) {
		int id = generateID();
		Receipt theReceipt = new Receipt(id,ticket, payment);
		receiptList.add(theReceipt);
		movieManager.reserve(theReceipt);
		emailManager.emailTicket(theReceipt);
		return theReceipt;
	}
	
	// run this when user need a voucher
	public Voucher generateVoucher() {
		Voucher theVoucher = new Voucher();
		voucherList.add(theVoucher);
		return theVoucher;
	}
	
	public boolean cancelTicket(int receiptID) {
		boolean valid = verifyReceipt(receiptID);
		Receipt theReceipt = findReceipt(receiptID);
		if (valid) {
			this.movieManager.cancelReservation(theReceipt);
			 theReceipt.createRefund();
			if (theReceipt.isRequireVoucher()) {
				Voucher voucher = new Voucher();
				emailManager.emailVoucher(voucher);
			}
			receiptList.remove(theReceipt);
			return true;
		}
		return false;
	}
	
	
	
	// verify voucher
	public boolean verifyVoucher(int voucherID) {
		for( Voucher v: voucherList) {
			if(v.getId() == voucherID) {
				return true;
			}
		}
		return false;
	}
	
	public boolean verifyReceipt(int receiptID) {
		for (Receipt r: receiptList) {
			if(r.getId() == receiptID){
				return true;
			}
		}
		return false;
	}
	
	public Receipt findReceipt(int receiptID) {
		for (Receipt r: receiptList) {
			if(r.getId() == receiptID){
				return r;
			}
		}
		return null;
	}
	
	// run this to generate random ID
	private int generateID() {
		Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @return the receiptList
	 */
	public ArrayList<Receipt> getReceiptList() {
		return receiptList;
	}
	/**
	 * @param receiptList the receiptList to set
	 */
	public void setReceiptList(ArrayList<Receipt> receiptList) {
		this.receiptList = receiptList;
	}
	/**
	 * @return the voucherList
	 */
	public ArrayList<Voucher> getVoucherList() {
		return voucherList;
	}
	/**
	 * @param voucherList the voucherList to set
	 */
	public void setVoucherList(ArrayList<Voucher> voucherList) {
		this.voucherList = voucherList;
	}

	/**
	 * @return the movieManager
	 */
	public MovieManager getMovieManager() {
		return movieManager;
	}

	/**
	 * @param movieManager the movieManager to set
	 */
	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}

	/**
	 * @return the userManager
	 */
	public UserManager getUserManager() {
		return userManager;
	}

	/**
	 * @param userManager the userManager to set
	 */
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	/**
	 * @return the emailManager
	 */
	public EmailManager getEmailManager() {
		return emailManager;
	}

	/**
	 * @param emailManager the emailManager to set
	 */
	public void setEmailManager(EmailManager emailManager) {
		this.emailManager = emailManager;
	}
	
	
}
