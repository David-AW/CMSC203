
public class SavingsAccount extends BankAccount{

	private double rate = 2.5;
	private int savingsNumber = 0;
	private String accountNumber;
	
	public SavingsAccount(String name, double init_bal) {
		super(name, init_bal);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	
	public SavingsAccount(SavingsAccount copy, double init_bal) {
		super(copy, init_bal);
		savingsNumber = copy.savingsNumber + 1;
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	
	public void postInterest() {
		deposit(getBalance() * (rate/100/12));
	}
	
	@Override
	public String getAccountNumber() {
		return accountNumber;
	}
	
}
