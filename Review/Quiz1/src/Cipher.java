import java.util.Scanner;
public class Cipher {
	public static void main (String[] args) {
		String msg;
		int shift = 3;
		String cipher = "";
		int i;
		int val;
		
		System.out.print("Enter a message: ");
		Scanner input = new Scanner(System.in);
		msg = input.nextLine();
		 
		for(i=0; i<msg.length(); i++) {
			char c = msg.charAt(i);
			val = c + shift; //value of new c
			if ( (val>'z' && (c>='a' && c<='z')) || (val>'Z' && (c>='A' && c<='Z' )) ) { 
				val=val-26;
			} else if ( (!(c>='a' && c<='z')) && (!(c>='A' && c<='Z' )) ) {
				val = c;
			} 
			c = (char)val;
			cipher = cipher +c;
		}
		System.out.println(cipher);
		
	}
}
