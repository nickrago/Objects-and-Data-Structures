package lab06;

public class BankAccount {
	private double balance;
	private int idNum;
	private static int numAccounts = 0;
	
	public BankAccount(double bal) {
		if(bal < 0) throw new IllegalArgumentException("balance cannot be negative");
		this.balance = bal;
		this.idNum = numAccounts;
		numAccounts++;
	}

	public double getBalance() {
		return balance;
	}

	public int getIdNum() {
		return idNum;
	}
	
	static void reset() {
		numAccounts = 0;
	}
	
	@Override
	public String toString() {
		return ("Acct. #" + idNum + " has $" + balance);
	}
	
	public void deposit(double amount) {
		if(amount < 0) throw new IllegalArgumentException("cannot deposit negative amount");
		balance += amount;
	}
	
	public double withdraw(double amount) {
		if(amount < 0) throw new IllegalArgumentException("cannot withdraw negative amount");
		if(amount > balance) {amount = balance; balance = 0;} else {balance -= amount;}
		return amount;
	}
	
	
	
	

}
