//Name: Cynthia Lee
//ID: 111737790
public class RewardsCard extends CreditCard {
	protected int rewardPoints;
	
	public RewardsCard(String holder, long number, int expiration, double limit) {
		super(holder, number, expiration, limit);
		rewardPoints = 0;
	}
	public RewardsCard(String holder, long number, int expiration) {
		super(holder, number, expiration);
		this.cardLimit = 500;
		rewardPoints = 0;
	}
	public int rewardPoints() {
		return rewardPoints;
	}
	public boolean redeemPoints(int points) {
		if(this.isFraud==true) {
			return false;
		}
		double bal = this.balance - ((double)points/100);
		if(points<=rewardPoints && bal>=0) {
			this.balance -= ((double)points/100);
			rewardPoints -= points;
			double reduction = ((double)points/100);
			Transaction redemption = new Transaction("redemption","CSEBank",reduction);
			transactions.add(redemption);
			return true;
		} else if(points<=rewardPoints && bal<0) {
			//$reward points greater than balance
			int pointsUsed = (int)(this.balance*100);
			this.balance = 0;
			rewardPoints = rewardPoints-pointsUsed;
			double reduction = ((double)pointsUsed/100); //points in $
			Transaction redemption = new Transaction("redemption","CSEBank",reduction);
			transactions.add(redemption);
			return true;
		} else {
			return false;
		}
	}
	public String toString() {
		return super.toString()+"\tReward Points: "+rewardPoints;
		//"Card # "+number+"\tExpiration Date: "+this.expiration()+"\tBalance: $"+balance+"\tReward Points: "+rewardPoints;
	}
	public boolean addTransaction(Transaction t) {
		if(this.isFraud==true) {
			return false;
		}
		if(t.type().equals("debit") && (t.amount()<=this.availableCredit())) {
			//transaction accepted
			this.balance += t.amount();
			transactions.add(t);//add transaction on card's array list of transactions
			rewardPoints = rewardPoints + ((int)(t.amount()*100));
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
		System.out.println("Expiration date: "+this.expiration());
		System.out.format("Ending balance: $%.2f%n",this.balance);
		System.out.println("Reward Points: "+rewardPoints);
		System.out.println("Transactions: ");
		//print out transactions
		for(int i = 0; i<transactions.size(); i++) {
			System.out.println(transactions.get(i).toString());
		}
	}
	
}
