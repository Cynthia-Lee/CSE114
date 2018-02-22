import java.util.Scanner;
public class RecursiveStringReverse {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string to be reversed: ");
		String s = input.nextLine();
		System.out.println(reverse(s));
	}
	
	public static String reverse(String s) {
		if(s.length()==0||s.length()==1) {
			return s;
		} else {
			return reverse(s.substring(1))+s.charAt(0); 
			//take the first letter and put it to the end, then have a substring of the original
		}		
		
	}
	
	//helper version 
	/*
	 
	 public static String reverse(String s) {
	 	if(s.length()==1) {
	 		return s;
	 	} else {
	 		return s.charAt(s.length()-1) + reverse(s, 0, s.length()-1);
	 	}
	
	 }
	 
	 private static String reverse(String source, int lowIndex, int highIndex) {
	 	return reverse(source.substring(lowIndex++,highIndex--));
	 }
	 
	 */
}
