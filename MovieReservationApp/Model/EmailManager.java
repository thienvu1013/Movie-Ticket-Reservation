package Model;

import java.io.FileWriter;
import java.io.IOException;

public class EmailManager {
	public EmailManager() {
		
	}
	public void emailTicket(Receipt r) {
		String str = createTicketEmail(r);
		writeEmail(str);
	}
	
	public void emailVoucher(Voucher voucher) {
		String str = createVoucherEmail(voucher);
		writeEmail(str);
			
	}
	
	public void emailPayment(Receipt r) {
		String str = createPaymentEmail(r);
		writeEmail(str);
	}
	
	public void writeEmail(String str) {
		FileWriter writer;
		try {
			writer = new FileWriter("Voucher.txt");
			writer.write(str);
			writer.close();
		} catch (IOException e) {
			System.out.println("Failed to write email");
			e.printStackTrace();
		}
		
	}
	
	public String createVoucherEmail(Voucher voucher) {
		String id = Integer.toString(voucher.getId());
		String expDate = voucher.getExpDate().toString();
		String sep = "\n--------------------------------------------------------------------";
		String result =sep +  "\nYou voucher ID is " + id + " and it will expire on "+
						expDate+"\nThis voucher has no monetary value"
								+ "\nPlease enter the voucher ID if you want a "
								+ "15% off your next purchase";
		return result;
	}
	
	public String createTicketEmail(Receipt r) {
		Ticket ticket = r.getTicket();
		String user = ticket.getUser().getName();
		String seat = ticket.getSeat().getRowLetter()+Integer.toString(ticket.getSeat().getRowNum());
		String time = ticket.getTime().toString();
		String movie = ticket.getMovie().getTitle();
		String payment = Double.toString(r.getPayment().getAmount());
		String date = r.getPayment().getPaidDate().toString();
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
	
	public String createPaymentEmail(Receipt r) {
		RegisteredUser theUser = (RegisteredUser) r.getUser();
		String expDate = theUser.getExpDate().toString();
		String user = r.getUser().getName();
		String payment = Double.toString(r.getPayment().getAmount());
		String date = r.getPayment().getPaidDate().toString();
		String sep = "\n--------------------------------------------------------------------";
		String result ="\nPAYMENT INFORMATION" +
						"\nCUSTOMER: "+user+
						"\nRECEIPT ID: "+ r.getId()+
						"\nPAYMENT: " + payment+
						"\nDATE: "+date+
						sep+
						"THANK YOU FOR YOUR PURCHASE!\nYOU MEMBER EXPIRES ON "+expDate+".";
		return result;
	}
	
}
