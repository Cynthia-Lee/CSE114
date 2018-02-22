import java.util.Scanner;
public class RunLengthEncoding {
	public static void main (String[] args) {
	String c;
		
	System.out.print("Enter a run-length encoded string: ");
	Scanner input = new Scanner(System.in);
	c = input.next();
	System.out.println(expand(c));
	
	}
	
	public static String expand (String i) {
		String letters = "";	
		int p; int j;
		
		for (p = 1; p<i.length(); p+=2) { //amount
			for (j = 0; j<Integer.parseInt(i.substring(p,p+1)) ;j++) {
				letters = letters + i.charAt(p-1);
			}
		}
		 return letters;
	}

	
	
	
	
	
	
}
