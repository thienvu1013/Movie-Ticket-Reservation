package Model;
/**
 * @author Thien Nguyen
 *
 */
public class OrdinaryUser extends User {
	private String type;
	
	public OrdinaryUser() {
		
	}
	
	
	//we're keeping email and bankinfo so that we can process refund later
	public OrdinaryUser(String name,String email, String bankInfo, String type) {
		super(name,email,bankInfo);
		this.type = type;
	}


	
	
	
	
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}
