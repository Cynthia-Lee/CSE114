//Name: Cynthia Lee
//ID: 111737790

//import java.util.ArrayList;

public class CreditCard extends BankCard {
	private int cardExpirationDate; //3 or any 4 digit number, myy or mmyy
	//single digit months cannot have a 0 before it (if they are, will assume that int is written in base 8
	//instead of base 10 (intended to be decimal)
	protected double cardLimit; //in dollars
	//In addition, as a quick hint to avoid spurious NullPointerExceptions,
	//make sure that your BankCard class actually instantiates its ArrayList, 
	//instead of just creating a reference variable

	public CreditCard(String cardHolder, long cardNumber, int expiration, double limit) {
		super(cardHolder, cardNumber);
		cardExpirationDate = expiration;
		cardLimit = limit;
	}
	
	public CreditCard(String cardHolder, long cardNumber, int expiration) {
		super(cardHolder, cardNumber);
		cardExpirationDate = expiration;
		cardLimit = 500;
	}
	
	public double limit() {
		return cardLimit;
	}
	
	public double availableCredit() {
		return (cardLimit-this.balance);
	}
	
	public int expiration() {
		return cardExpirationDate;
	}
	
	public String toString() {
		return "Card # "+number+"\tExpiration Date: "+cardExpirationDate+"\tBalance: $"+balance;
	}
	
	public boolean addTransaction(Transaction t) {
		if(this.isFraud==true) {
			return false;
		}
		if(t.type().equals("debit") && (t.amount()<=this.availableCredit())) {
			//transaction accepted
			this.balance += t.amount();
			transactions.add(t);//add transaction on card's array list of transactions
			return true;
		} else if(t.type().equals("debit") && (t.amount()>this.availableCredit())) {
			//decline
			return false;
		} else if (t.type().equals("credit")) {//credit transaction amount will be negative
			this.balance += t.amount();
			transactions.add(t);
			return true;
		} else { //any other type (like "redemption"),
			return false;
		}	
	}
	
	public void printStatement() {
		System.out.println("Card holder name: "+this.cardHolder());
		System.out.println("Card number: "+this.number);
		System.out.println("Expiration date: "+this.cardExpirationDate);
		System.out.format("Ending balance: $%.2f%n",this.balance);
		System.out.println("Transactions: ");
		//print out transactions
		for(int i = 0; i<transactions.size(); i++) {
			System.out.println(transactions.get(i).toString());
		}
	}
	
	public boolean getCashAdvance(double d) {
		if(this.isFraud==true) {
			return false;
		}
		double fee = (d*0.05);
		if((d+fee)<=this.availableCredit()) {
			this.balance += (d+fee);
			Transaction advance = new Transaction("advance","CSEBank",d);
			transactions.add(advance);
			Transaction tFee = new Transaction("fee","Cash advance fee",fee);
			transactions.add(tFee);
			return true;
		} else { //amount+fee > availableCredit
			return false;
		}
	}
	
}
