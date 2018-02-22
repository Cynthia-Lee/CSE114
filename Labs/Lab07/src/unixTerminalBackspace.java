import java.util.Scanner;
public class unixTerminalBackspace {
	public static void main (String[] args) {
		String d;
		
		System.out.print("Enter a sentence: ");
		Scanner input = new Scanner(System.in);
		d = input.nextLine();
		System.out.println(backspace(d));
		//System.out.println(backspace("I wish^H^H^Hant some ice cream^H^H^H^H^Hmilk"));
	}
	
	public static String backspace (String s) {
		String BACKSPACE = "^H";
		int bsIndex = 0;
		
		while ( (bsIndex = s.indexOf(BACKSPACE) ) != -1) {
			s = s.substring(0, bsIndex-1) + s.substring(bsIndex + BACKSPACE.length() );
		}
		
		return s;
	}	
	
	
	
}
