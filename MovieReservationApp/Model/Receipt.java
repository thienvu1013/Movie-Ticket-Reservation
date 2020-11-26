package Model;



public class Receipt {
	private int id;
	private Ticket ticket;
	private Payment payment;
	private Refund refund;
	private boolean requireVoucher = false;
	private User user;
	
	
	public Receipt(){
		
	}
	
	public Receipt(int id, Ticket ticket, Payment payment) {
		this.setId(id);
		this.ticket = ticket;
		this.setPayment(payment);
	}
	
	public Receipt(User user,Payment payment) {
		this.setUser(user);
	}
	
	public double createRefund() {
		double amount = this.payment.getAmount();
		boolean isRegistered = checkUserType();
		Refund refundMethod;
		if(isRegistered) {
			refundMethod = new FullRefund();
		}
		else {
			setRequireVoucher(true);
			refundMethod = new RegularRefund();
		}
		setRefund(refundMethod);
		
		return refund.CalculateRefund(amount);
		
	}
	
	
	
	//return true if user is registered, false if user is ordinary
	public boolean checkUserType() {
		User theUser = this.ticket.getUser();
		if(theUser instanceof RegisteredUser) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/**
	 * @return the ticket
	 */
	public Ticket getTicket() {
		return ticket;
	}

	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	/**
	 * @return the refund
	 */
	public Refund getRefund() {
		return refund;
	}

	/**
	 * @param refund the refund to set
	 */
	public void setRefund(Refund refund) {
		this.refund = refund;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the requireVoucher
	 */
	public boolean isRequireVoucher() {
		return requireVoucher;
	}

	/**
	 * @param requireVoucher the requireVoucher to set
	 */
	public void setRequireVoucher(boolean requireVoucher) {
		this.requireVoucher = requireVoucher;
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
	
}


