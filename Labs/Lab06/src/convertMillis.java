import java.util.Scanner;
public class convertMillis {
	public static void main (String[] args) {
		long m;
		
		System.out.print("Enter number of milliseconds: ");
		Scanner input = new Scanner(System.in);
		m = input.nextLong();
		String o = convertMillis(m);
		System.out.println(o);

	}
	
	public static String convertMillis(long millis) {
		long hours = 0; //millis/3600000;
		long minutes = 0; //millis/60000;
		long seconds = 0; //millis/1000;
		long newM = millis;
		
		hours = millis/3600000;
		newM = newM - (3600000*hours);
		minutes = newM/60000;
		newM = newM - (60000*minutes);
		seconds = newM/1000;
		
		String result = hours+":"+minutes+":"+seconds;
		return result;
	}
	
}
