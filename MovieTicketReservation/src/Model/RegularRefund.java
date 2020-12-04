package Model;

public class RegularRefund implements Refund{
	private double amount;
	
	public RegularRefund() {
	}

	@Override
	
	//return 
	public double CalculateRefund(double amount) {
		this.amount = amount-(amount*0.15);
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
