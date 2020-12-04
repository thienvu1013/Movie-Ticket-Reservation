package Server;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBController {
	private Connection jdbc_connection;
	private CallableStatement myCall;
	private boolean success;

		
				
	
	
	// Students should configure these variables for their own MySQL environment
	// If you have not created your first database in mySQL yet, you can leave the 
	// "[DATABASE NAME]" blank to get a connection and create one with the createDB() method.
	public String connectionInfo = "jdbc:mysql://localhost:3306/MovieApp",  
				  login          = "root",
				  password       = "Ohohoh123";

	public DBController() {
		try{
			// If this throws an error, make sure you have added the mySQL connector JAR to the project
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// If this fails make sure your connectionInfo and login/password are correct
			setJdbc_connection(DriverManager.getConnection(connectionInfo, login, password));
			System.out.println("Connected to: " + connectionInfo + "\n");
		}
		catch(SQLException e) { e.printStackTrace(); }
		catch(Exception e) { e.printStackTrace(); }
	}
	
	public boolean verify(String email, String password) {
		try {
			myCall = jdbc_connection.prepareCall("{call check_cred(?,?)}");
			myCall.setString(1,email);
			myCall.setString(2,password);
			return myCall.execute();
		}catch (SQLException e) {
			System.out.println("database failed to create tickets");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkVoucher(int v) {
		try {
			myCall = jdbc_connection.prepareCall("{call check_voucher(?)}");
			myCall.setInt(1,v);
			return myCall.execute();
		}catch (SQLException e) {
			System.out.println("database failed to create tickets");
			e.printStackTrace();
		}
		return false;

	}
	
	//create ticket then return the id of that ticket
	public int createRTicket(int movie,String userID,int time,String seatL,int seatN) {
		ResultSet myRs = null;
		try {
			myCall = jdbc_connection.prepareCall("{call check_seat(?,?,?,?,?)}");
			myCall.setInt(1,time);
			myCall.setInt(2,movie);
			myCall.setInt(3, seatN);
			myCall.setString(4, seatL);
			myCall.setString(5,"N");
			
			if(myCall.execute()) {
				myRs = myCall.getResultSet();
				myRs.next();
				int id = myRs.getInt("res_id");
				myCall = jdbc_connection.prepareCall("{call create_ticket(?,?)}");
				myCall.setInt(1, id);
				myCall.setString(2, userID);
				myCall.execute();
				myRs = myCall.getResultSet();
				myRs.next();
				return myRs.getInt("ticket_id");
			}
			else {
				return 0;
			}
		} catch (SQLException e) {
			System.out.println("database failed to create tickets");
			e.printStackTrace();
		}
		return 0;
	}
	
	public int createOTicket(int movie,String userID,int time,String seatL,int seatN,String bank) {
		System.out.println("creating ticket");
		ResultSet myRs = null;
		try {
			myCall =  jdbc_connection.prepareCall("{call create_ordinary(?,?)}");
			myCall.setString(1,userID);
			myCall.setString(2, bank);
			myCall.execute();
			myCall = jdbc_connection.prepareCall("{call check_seat(?,?,?,?,?)}");
			myCall.setInt(1,time);
			myCall.setInt(2, movie);
			myCall.setInt(3, seatN);
			myCall.setString(4, seatL);
			myCall.setString(5,"N");
			
			if(myCall.execute()) {
				myRs = myCall.getResultSet();
				myRs.next();
				int id = myRs.getInt("res_id");
				myCall = jdbc_connection.prepareCall("{call create_ticket(?,?)}");
				myCall.setInt(1, id);
				myCall.setString(2, userID);
				myCall.execute();
				myRs = myCall.getResultSet();
				myRs.next();
				return myRs.getInt("ticket_id");
			}
			else {
				return 0;
			}
		} catch (SQLException e) {
			System.out.println("database failed to create tickets");
			e.printStackTrace();
		}
		return 0;
	}
	
	public ResultSet createReceipt(int ticketID, boolean vouchRequire,double price,int voucher) {
		String vouch;
		if (vouchRequire) {
			vouch = "Y";
		}
		else {
			vouch = "N";
		}
		ResultSet myRs = null;
		try {
			
			//delete voucher
			myCall =  jdbc_connection.prepareCall("{call redeem_voucher(?)}");
			myCall.setInt(1,voucher);
			myCall.execute();
			
			
			//create payment
			myCall =  jdbc_connection.prepareCall("{call create_payment(?,?)}");
			myCall.setInt(1,ticketID);
			myCall.setDouble(2, price);
			myCall.execute();
			myRs = myCall.getResultSet();
			myRs.next();
			int paymentID = myRs.getInt("payment_id");
			System.out.println("payment "+paymentID);
			
			//create receipt
			myCall =  jdbc_connection.prepareCall("{call create_receipt(?,?)}");
			myCall.setInt(1,paymentID);
			myCall.setString(2, vouch);
			myCall.execute();
			System.out.println("sucessfully created receipt");
			myRs = myCall.getResultSet();
		}catch (SQLException e) {
			System.out.println("database failed to create receipt");
			e.printStackTrace();
		}
		return myRs;
		
	}
	
	public String[] getInfo(int ticketID, int receiptID){
		ResultSet myRs = null;
		try {
			myCall =  jdbc_connection.prepareCall("{call get_ticket_info(?)}");
			myCall.setInt(1,ticketID);
			myCall.execute();
			myRs = myCall.getResultSet();
			myRs.next();
			String movie = myRs.getString("movie_title");
			String time =Integer.toString(myRs.getInt("showtime"));
			String seat = Integer.toString(myRs.getInt("row_num"))+"-"+myRs.getString("row_letter");
			String user = myRs.getString("user_id");
			myCall =  jdbc_connection.prepareCall("{call get_receipt_info(?)}");
			myCall.setInt(1,receiptID);
			myCall.execute();
			myRs = myCall.getResultSet();
			myRs.next();
			String date = myRs.getDate("payment_date").toString();
			String price = String.format("%.2f",myRs.getDouble("amount"));
			System.out.println("THE PRICE IS: "+price);
			String[] info = {movie,time,seat,user,date,price};
			return info;
			
			
		} catch (SQLException e) {
			System.out.println("database failed to get info");
			e.printStackTrace();
		}
		return null;
			
	}
	
	
	public ResultSet getMovieIds() {
		ResultSet myRs = null;
		try {
			myCall = jdbc_connection.prepareCall("{call get_movies()}");
			myCall.execute();
			myRs = myCall.getResultSet();
		} catch (SQLException e) {
			System.out.println("database failed to get movies");
			e.printStackTrace();
		}
		return myRs;
	}
	
	
	public String getTitle(int m) {
		ResultSet myRs = null;
		String result = "";
		try {
			myCall = jdbc_connection.prepareCall("{call get_title(?)}");
			myCall.setInt(1, m);
			myCall.execute();
			myRs = myCall.getResultSet();
			myRs.next();
			result = myRs.getString("movie_title");
		} catch (SQLException e) {
			System.out.println("database failed to get title");
			e.printStackTrace();
		}
		return result;
	}
	
	public double getPrice(int m) {
		ResultSet myRs = null;
		double result = 0;
		try {
			myCall = jdbc_connection.prepareCall("{call get_price(?)}");
			myCall.setInt(1, m);
			myCall.execute();
			myRs = myCall.getResultSet();
			myRs.next();
			result = myRs.getDouble("movie_price");
		} catch (SQLException e) {
			System.out.println("database failed to get price");
			e.printStackTrace();
		}
		return result;
	}

	//get time list
	public ResultSet getTimeList(int m) {
		ResultSet myRs = null;
		try {
			myCall = jdbc_connection.prepareCall("{call get_times(?)}");
			myCall.setInt(1, m);
			myCall.execute();
			myRs = myCall.getResultSet();
		} catch (SQLException e) {
			System.out.println("database failed to get times");
			e.printStackTrace();
		}
		return myRs;
		
	}
	// get seat list
	public ResultSet getSeatList(int t, int m) {
		ResultSet myRs = null;
		try {
			myCall = jdbc_connection.prepareCall("{call get_seats(?,?)}");
			myCall.setInt(1, t);
			myCall.setInt(2, m);
			myCall.execute();
			myRs = myCall.getResultSet();
		} catch (SQLException e) {
			System.out.println("database failed to get seats");
			e.printStackTrace();
		}
		return myRs;
		
	}
	
	
	
	public boolean deleteTicket(int id) {
		try {
			myCall = jdbc_connection.prepareCall("{call delete_ticket(?)}");
			myCall.setInt(1, id);
			myCall.execute();
		} catch (SQLException e) {
			System.out.println("database failed to delete ticket");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	public boolean cancelTicket(int receiptId) {
		try {
			myCall = jdbc_connection.prepareCall("{call cancel_ticket(?)}");
			myCall.setInt(1, receiptId);
			myCall.execute();
		}catch (SQLException e) {
			System.out.println("database failed to cancel ticket");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public ResultSet getVoucherStatus(int receiptId) {
		ResultSet myRs = null;
		try {
			myCall = jdbc_connection.prepareCall("{call get_voucher_status(?)}");
			myCall.setInt(1, receiptId);
			myCall.execute();
			myRs = myCall.getResultSet();	
		}catch (SQLException e) {
			System.out.println("database failed to fetch voucher status");
			e.printStackTrace();
		}
		return myRs;
	}
	
	public ResultSet createVoucher() {
		ResultSet myRs = null;
		try {
			myCall = jdbc_connection.prepareCall("{call create_voucher()}");
			myCall.execute();
			myRs = myCall.getResultSet();
		}catch (SQLException e) {
			System.out.println("database failed to create voucher");
			e.printStackTrace();
			return myRs;
		}
		
		return myRs;
	}
	
	public ResultSet renewMembership(String user, String pass) {
		ResultSet myRs = null;
		try {
			myCall = jdbc_connection.prepareCall("{call renew_member(?,?)}");
			myCall.setString(1, user);
			myCall.setString(2,pass);
			myCall.execute();
			myRs = myCall.getResultSet();
		}catch (SQLException e) {
			System.out.println("database failed to renew");
			e.printStackTrace();
			return myRs;
		}
		return myRs;
	}
	
	
	
	
	
	
	
	
	

	/**
	 * @return the jdbc_connection
	 */
	public Connection getJdbc_connection() {
		return jdbc_connection;
	}

	/**
	 * @param jdbc_connection the jdbc_connection to set
	 */
	public void setJdbc_connection(Connection jdbc_connection) {
		this.jdbc_connection = jdbc_connection;
	}


	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}


	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}


	/**
	 * @return the myCall
	 */
	public CallableStatement getMyCall() {
		return myCall;
	}


	/**
	 * @param myCall the myCall to set
	 */
	public void setMyCall(CallableStatement myCall) {
		this.myCall = myCall;
	}


	
	/**
	 * @return the connectionInfo
	 */
	public String getConnectionInfo() {
		return connectionInfo;
	}



	/**
	 * @param connectionInfo the connectionInfo to set
	 */
	public void setConnectionInfo(String connectionInfo) {
		this.connectionInfo = connectionInfo;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}


	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}