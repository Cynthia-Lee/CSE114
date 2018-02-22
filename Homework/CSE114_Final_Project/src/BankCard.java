//Name: Cynthia Lee
//ID: 111737790
import java.util.ArrayList;

public abstract class BankCard {
	private String name; //cardholder's name
	protected long number; //card number, 16 integers
	protected double balance; //card current balance
	//protected Transaction[] trans; //holds transaction objects
	protected ArrayList<Transaction> transactions = new ArrayList<Transaction>( );
	
	protected boolean isFraud = false;
	
	public BankCard(String cardholderName, long cardNumber) {
	/*	if(cardholderName.contains("_")) {
			String[] n = cardholderName.split("_");
			name = n[0]+" "+n[1];
		} else if (cardholderName.contains(" ")) {
			name = cardholderName;
		} */
		name = cardholderName;
		number = cardNumber;
		balance = 0;
	}
	
	public double balance() {
		return balance;
	}
	public long number() {
		return number;
	}
	public String cardHolder() {
		return name;
	}
	public String toString() {
		return "Card # "+number+"\tabBalance: $"+balance;
	}
	public abstract boolean addTransaction(Transaction t); //when implemented, method performs the 
															//specified transaction on the card, returns success or failure
	public abstract void printStatement(); //when implemented, method prints the current card's 
											//basic information, cardholder's name, card number, balance, etc.
	//along with list of transactions that have been completed successfully 
	
	public void checkFraud(BankCard c) {
		int count = 0;
		Transaction temp1 = null;
		Transaction temp2 = null;
		for(int i = 0; i<transactions.size(); i++) {
			if(transactions.get(i).type().equals("debit") && transactions.get(i).amount()<1.50) { //consecutive
				if(count == 0) {
					temp1 = transactions.get(i);
					count++;
				} else if (count == 1) {
					if(temp1.merchant().equals(transactions.get(i).merchant())) {
						temp2 = transactions.get(i);
						count++;
					}
				}
			} else {
				count = 0;
			}
		}
		
		if(count==2) {
			Transaction rollback1 = new Transaction("credit","Fraud compensation",temp1.amount());
			Transaction rollback2 = new Transaction("credit","Fraud compensation",temp2.amount());
			if(c instanceof RewardsCard) {
				((RewardsCard)c).addTransaction(rollback1);
				((RewardsCard)c).addTransaction(rollback2);
			} else if (c instanceof CreditCard) {
				((CreditCard)c).addTransaction(rollback1);
				((CreditCard)c).addTransaction(rollback2);
			} else if (c instanceof PrepaidCard) {
				((PrepaidCard)c).addTransaction(rollback1);
				((PrepaidCard)c).addTransaction(rollback2);
			}
			isFraud = true;
			//c.addTransaction(rollback1);
			//c.addTransaction(rollback2);
		}	
	}
	
	
}
