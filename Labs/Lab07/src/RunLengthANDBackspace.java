import java.util.Scanner;
public class RunLengthANDBackspace {
	public static void main (String[] args) {
		String c;
		String d;
		
		System.out.print("Enter a run-length encoded string: ");
		Scanner input = new Scanner(System.in);
		c = input.next();
		System.out.println(expand(c));
		System.out.println();
		System.out.print("Enter a sentence (^H deletes the previously typed character): ");
		Scanner in = new Scanner(System.in);
		d = in.nextLine();
		System.out.println(backspace(d));
		
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

	public static String backspace (String s) {
		String BACKSPACE = "^H";
		int bsIndex = 0;
		
		while ( (bsIndex = s.indexOf(BACKSPACE) ) != -1) {
			s = s.substring(0, bsIndex-1) + s.substring(bsIndex + BACKSPACE.length() );
		}
		
		return s;
	}		
	
	
	
	
	
	
	
	
	
	
}
