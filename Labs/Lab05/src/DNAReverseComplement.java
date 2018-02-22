import java.util.Scanner;
public class DNAReverseComplement {
	public static void main (String[] args) {
		String d;
		String complement = "";
		char n = ' ';
		int i;
		String rc = "";
		char nn = ' ';
		
		System.out.print("Enter a DNA strand: ");
		Scanner input = new Scanner(System.in);
		d = input.nextLine();		
		for(i=0; i<d.length();i++) {
			switch (d.charAt(i)) {         //change letters (the complement)
				case 'A': n = 'T'; break;
				case 'T': n = 'A'; break;
				case 'C': n = 'G'; break;
				case 'G': n = 'C'; break;	
			}
		complement = complement + n;
		}
		//System.out.println(complement);
		
		//reverse the String (reverse the complement)
		for (i=complement.length()-1; i>=0; i--) {
			nn = complement.charAt(i);
			rc = rc+nn;
		}
		System.out.println("The reverse complement of the DNA strand is: " +rc);
	}
}
