
public class Account {
	private int id = 0;
	private double balance = 1000;
	private double anualInterestRate = 4.5;
	
	public Account() { 
	}
	public Account(int i, double b) {
		id = i;
		balance = b;
	}
	public Account(int i, double b, double r) {
		id = i;
		b = balance;
		anualInterestRate = r;
	}
	
	public int getId() { return id; }
	public double getBalance() { return balance; }
	public double getRate() { return anualInterestRate; }
	
	public void setId(int i) {
		id = i;
	}
	public void setBalance(double b) {
		balance = b;
	}
	public void setRate(double r) {
		anualInterestRate = r;
	}
	
	public double getMonthlyInterestRate() {
		return anualInterestRate/12;
	}
	
	public void withdraw(double w) {
		if(balance<w) {
			System.out.println("Insufficient funds");
		} else {
			balance = balance - w;
		}
	}
	
	public void deposit(double d) {
		balance = balance + d;
	}
	
	public String toString() {
		return "ID: "+id+" Balance: $"+balance+" Anual Interest Rate: "+anualInterestRate;
	}
}
