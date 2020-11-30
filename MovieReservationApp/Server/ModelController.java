package Server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.MovieTime;
import Model.Seat;
import Model.Ticket;

public class ModelController {

	DatabaseController connection = new DatabaseController();
	public Statement statement;

	public ArrayList<Ticket> GenerateTicket(int userID) {

		ArrayList<Ticket> ticket = new ArrayList<Ticket>();

		String sql = "SELECT * FROM TICKET" + " WHERE UserID LIKE" + "'%" + userID + "%'";
		ResultSet tickets;

		try {
			statement = connection.jdbc_connection.createStatement();
			tickets = statement.executeQuery(sql);
			if (tickets.next()) {
				ticket.add(new Ticket(tickets.getInt("TicketID"), tickets.getInt("UserID"), tickets.getInt("ReceiptID"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ticket;
	}

	public ArrayList<MovieTime> createShowTime(int movieID) {

		ArrayList<MovieTime> timeList = new ArrayList<MovieTime>();

		String sql = "SELECT DISCTINCT Showtime FROM RESERVATION WHERE MovieID =" + movieID;
		
		ResultSet times;

		try {
			statement = connection.jdbc_connection.createStatement();
			times = statement.executeQuery(sql);
			if (times.next()) {
				timeList.add(new MovieTime(times.getString("Showtime"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return timeList;
	}
	
	public ArrayList<Seat> createSeatingList(int movieID) {

		ArrayList<Seat> timeList = new ArrayList<Seat>();

		String sql = "SELECT RowNum, RowLetter FROM RESERVATION WHERE MovieID =" + movieID;
		
		ResultSet times;

		try {
			statement = connection.jdbc_connection.createStatement();
			times = statement.executeQuery(sql);
			if (times.next()) {
				timeList.add(new Seat(times.getInt("RowNum"));
				timeList.add(new Seat(times.getString("RowLetter"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return seatList;
	}
}
