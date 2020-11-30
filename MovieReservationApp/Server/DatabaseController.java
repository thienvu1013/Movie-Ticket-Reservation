package Server;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseController {

	public Connection jdbc_connection;
	public Statement statement;
	public String databaseName = "TheatreDB";

	public String connectionInfo = "jdbc:mysql://localhost:3306/TheatreDB", 
							login = "root", 
						password = "Fatsam123";
	
	
	public DatabaseController() {
		try{
			// If this throws an error, make sure you have added the mySQL connector JAR to the project
			Class.forName("com.mysql.jdbc.Driver");
			
			// If this fails make sure your connectionInfo and login/password are correct
			jdbc_connection = DriverManager.getConnection(connectionInfo, login, password);
			//System.out.println("Connected to: " + connectionInfo + "\n");
		}
		catch(SQLException e) { e.printStackTrace(); 
		}
		catch(Exception e) { e.printStackTrace(); 
		}
	}
	
}
