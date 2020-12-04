package Model;

import java.io.FileWriter;
import java.io.IOException;

public class EmailManager {
	String vouchID;
	String user;
	String seat;
	String time;
	String movie;
	String payment;
	String date;
	String expDate;
	String receiptID;
	public EmailManager() {
		
	}
	
	public void emailTicket() {
		String str = createTicketEmail();
		writeEmail(str);
	}
	public void emailTicket(Receipt r) {
		String str = createTicketEmail(r);
		writeEmail(str);
	}
	public void emailVoucher() {
		String str = createVoucherEmail();
		writeEmail(str);
			
	}
	public void emailVoucher(Voucher voucher) {
		String str = createVoucherEmail(voucher);
		writeEmail(str);		
	}
	
	public void emailPayment() {
		String str = createPaymentEmail();
		writeEmail(str);
	}
	public void emailPayment(Receipt r) {
		String str = createPaymentEmail(r);
		writeEmail(str);
	}
	
	public void writeEmail(String str) {
		FileWriter writer;
		try {
			writer = new FileWriter("Email.txt");
			writer.write(str);
			writer.close();
		} catch (IOException e) {
			System.out.println("Failed to write email");
			e.printStackTrace();
		}
		
	}
	public String createVoucherEmail() {
		String sep = "\n--------------------------------------------------------------------";
		String result =sep +  "\nYou voucher ID is " + vouchID + " and it will expire on "+
						expDate+"\nThis voucher has no monetary value"
								+ "\nPlease enter the voucher ID if you want a "
								+ "15% off your next purchase";
		System.out.println(result);
		return result;
	}
	
	public String createVoucherEmail(Voucher voucher) {
		vouchID = Integer.toString(voucher.getId());
		expDate = voucher.getExpDate().toString();
		String sep = "\n--------------------------------------------------------------------";
		String result =sep +  "\nYou voucher ID is " + vouchID + " and it will expire on "+
						expDate+"\nThis voucher has no monetary value"
								+ "\nPlease enter the voucher ID if you want a "
								+ "15% off your next purchase";
		return result;
	}
	
	public String createTicketEmail() {
		String sep = "\n--------------------------------------------------------------------";
		String result = sep+
						"\nTICKET INFORMATION" +
						"\nMOVIE: "+movie+
						"\nTIME: "+time+
						"\nSEAT: "+seat+
						sep+
						"\nRECEIPT INFORMATION" +
						"\nCUSTOMER: "+user+
						"\nRECEIPT ID: "+ receiptID+
						"\nPAYMENT: " + payment+
						"\nDATE: "+date+
						sep+
						"\nTHANK YOU FOR YOUR PURCHASE!\nREFUNDABLE WITHIN 72 HOURS FROM PURCHASE.";
		System.out.println(result);
		return result;
	}
	
	public String createTicketEmail(Receipt r) {
		Ticket ticket = r.getTicket();
		user = ticket.getUser().getName();
		seat = ticket.getSeat().getRowLetter()+Integer.toString(ticket.getSeat().getRowNum());
		time = ticket.getTime().toString();
		movie = ticket.getMovie().getTitle();
		payment = Double.toString(r.getPayment().getAmount());
		date = r.getPayment().getPaidDate().toString();
		String sep = "\n--------------------------------------------------------------------";
		String result = sep+
						"\nTICKET INFORMATION" +
						"\nMOVIE: "+movie+
						"\nTIME: "+time+
						"\nSEAT: "+seat+
						sep+
						"\nRECEIPT INFORMATION" +
						"\nCUSTOMER: "+user+
						"\nRECEIPT ID: "+ r.getId()+
						"\nPAYMENT: " + payment+
						"\nDATE: "+date+
						sep+
						"THANK YOU FOR YOUR PURCHASE!\nREFUNDABLE WITHIN 72 HOURS FROM PURCHASE.";
		return result;
	
	}
	
	public String createPaymentEmail() {
		String sep = "\n--------------------------------------------------------------------";
		String result ="\nPAYMENT INFORMATION" +
						"\nCUSTOMER: "+user+
						"\nPAYMENT: "+payment+
						"\nEXPIRE DATE: "+expDate+
						sep+
						"\nTHANK YOU FOR YOUR PURCHASE!\nYOUR MEMBERSHIP EXPIRES ON "+expDate+".";
		return result;
	}
	
	
	//generate email for payments
	public String createPaymentEmail(Receipt r) {
		RegisteredUser theUser = (RegisteredUser) r.getUser();
		expDate = theUser.getExpDate().toString();
		user = r.getUser().getName();
		payment = Double.toString(r.getPayment().getAmount());
		date = r.getPayment().getPaidDate().toString();
		String sep = "\n--------------------------------------------------------------------";
		String result ="\nPAYMENT INFORMATION" +
						"\nCUSTOMER: "+user+
						"\nRECEIPT ID: "+ r.getId()+
						"\nPAYMENT: " + payment+
						"\nDATE: "+date+
						sep+
						"\nTHANK YOU FOR YOUR PURCHASE!\nYOUR MEMBERSHIP EXPIRES ON "+expDate+".";
		return result;
	}
	/**
	 * @return the vouchID
	 */
	public String getVouchID() {
		return vouchID;
	}
	/**
	 * @param vouchID the vouchID to set
	 */
	public void setVouchID(String vouchID) {
		this.vouchID = vouchID;
	}
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the seat
	 */
	public String getSeat() {
		return seat;
	}
	/**
	 * @param seat the seat to set
	 */
	public void setSeat(String seat) {
		this.seat = seat;
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
	/**
	 * @return the movie
	 */
	public String getMovie() {
		return movie;
	}
	/**
	 * @param movie the movie to set
	 */
	public void setMovie(String movie) {
		this.movie = movie;
	}
	/**
	 * @return the payment
	 */
	public String getPayment() {
		return payment;
	}
	/**
	 * @param payment the payment to set
	 */
	public void setPayment(String payment) {
		this.payment = payment;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the expDate
	 */
	public String getExpDate() {
		return expDate;
	}
	/**
	 * @param expDate the expDate to set
	 */
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	/**
	 * @return the receiptID
	 */
	public String getReceiptID() {
		return receiptID;
	}
	/**
	 * @param receiptID the receiptID to set
	 */
	public void setReceiptID(String receiptID) {
		this.receiptID = receiptID;
	}
	
}
