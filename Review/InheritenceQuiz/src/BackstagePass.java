
public class BackstagePass extends Ticket{
	private String hostName;
	
	public BackstagePass(String name, double price, String host) { //constructor
		super(name,price);
		//Ticket(name,price); //does not work because it is invoking it as a method in the BackstagePass
		//Ticket.Ticket(name,price); //doesn't work either because it is still invoking Ticket(name,price) as a method 
		hostName = host;	
	}
	
}
