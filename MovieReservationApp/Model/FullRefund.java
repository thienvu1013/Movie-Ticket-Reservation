/**
 * 
 */
package Model;

/**
 * @author Thien Nguyen
 *
 */
public class FullRefund implements Refund {
	private double amount;
	
	public FullRefund() {
	}

	@Override
	
	//return 
	public double CalculateRefund(double amount) {
		this.amount = amount;
		return this.amount;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}


