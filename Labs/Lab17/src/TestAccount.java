
public class TestAccount {
	public static void main (String[] args) {
		Account acc = new Account(1234,1000);
		CheckingAccount ca = new CheckingAccount(1444,2000,500);
		//System.out.println(acc.toString());
		System.out.println("Account");
		System.out.println(acc);
		System.out.println("Depositing $500.00");
		acc.deposit(500.0);
		System.out.println(acc);
		System.out.println("Withdrawing $650.49");
		acc.withdraw(650.49);
		System.out.println(acc);
		System.out.println();
		System.out.println("Checking Account");
		System.out.println(ca);
		System.out.println("Depositing $700.00");
		ca.deposit(700.0);
		System.out.println(ca);
		System.out.println("Withdrawing $650.49");
		ca.withdraw(650.49);
		System.out.println(ca);
		
	}
}
