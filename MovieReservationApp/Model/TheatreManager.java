package Model;

/**
 * @author Thien Nguyen
 * This class handles all operation of the theatre, it should call the method in the other managers
 */
public class TheatreManager {
	private TicketManager ticketManager;
	private MovieManager movieManager;
	private UserManager userManager;
	private EmailManager emailManager;
	
	public TheatreManager() {
		
	}
	
	public TheatreManager(TicketManager ticket, MovieManager movie, UserManager user,EmailManager emailManager) {
		this.setTicketManager(ticket);
		this.setMovieManager(movie);
		this.setUserManager(user);
		this.setEmailManager(emailManager);
	}


	
	/**
	 * @return the ticketManager
	 */
	public TicketManager getTicketManager() {
		return ticketManager;
	}

	/**
	 * @param ticketManager the ticketManager to set
	 */
	public void setTicketManager(TicketManager ticketManager) {
		this.ticketManager = ticketManager;
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
