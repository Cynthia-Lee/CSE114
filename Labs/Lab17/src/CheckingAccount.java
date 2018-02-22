
public class CheckingAccount extends Account{
	private double overdraft = 0;
	
	public CheckingAccount(int i, double b, double o) {
		super(i,b);
		overdraft = o;
	}
	public CheckingAccount(int i, double b, double r, double o) {
		super(i,b,r);
		overdraft = o;
	}
	public CheckingAccount(double o) {
		super();
		overdraft = o;
	}
	
	public void setOverdraft(double o) {
		overdraft = o;
	}
	
	public void withdraw(double w) {
		if(super.getBalance()<w && w<=super.getBalance()+overdraft) {
			super.setBalance(super.getBalance()-w);
		} else {
			super.withdraw(w);
		}
	}
	
	public String toString() {
		return super.toString()+" Overdraft Limit: "+overdraft;
	}
	
}