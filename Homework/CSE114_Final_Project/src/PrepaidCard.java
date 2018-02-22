//Name: Cynthia Lee
//ID: 111737790
public class PrepaidCard extends BankCard{
	// It defines the instance methods below (it does not add any new instance variables)
	
	public PrepaidCard(String cardHolder, long cardNumber, double balance) {
		super(cardHolder, cardNumber);
		super.balance = balance; 
	}
	public PrepaidCard(String cardHolder, long cardNumber) {
		super(cardHolder, cardNumber);
	}
	public boolean addTransaction(Transaction t) {
		if(this.isFraud==true) {
			return false;
		}
		if(t.type().equals("debit") && t.amount()<=this.balance) {
			//accepted
			balance -= t.amount();
			transactions.add(t);
			return true;
		} else if (t.type().equals("debit") && t.amount()>this.balance) {
			//decline
			return false;
		} else if (t.type().equals("credit")) {//credit transaction amount will be negative
			this.balance = this.balance - t.amount(); //(credits have negative amounts, 
			//so this effectively adds money back to the PrepaidCard)
			transactions.add(t);
			return true;
		} else { //any other type (like "redemption"),
			return false;
		}	
	}
	public boolean addFunds(double amount) {
		if(this.isFraud==true) {
			return false;
		}
		if(amount>=0) {
			this.balance = this.balance + amount;
			Transaction p = new Transaction("top-up","User payment",(-1*amount));
			transactions.add(p);
			return true;
		} else {
			return false;
		}
	}
	public String toString() {
		return super.toString();
	}
	public void printStatement() { //abstract method from BankCard
		System.out.println("Card holder name: "+this.cardHolder());
		System.out.println("Card number: "+this.number);
		System.out.format("Ending balance: $%.2f%n",this.balance);
		System.out.println("Transactions: ");
		//print out transactions
		for(int i = 0; i<transactions.size(); i++) {
			System.out.println(transactions.get(i).toString());
		}
		
	}
	
	
	
}
