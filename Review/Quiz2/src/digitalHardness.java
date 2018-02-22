import java.util.Scanner;
public class digitalHardness {
	public static void main (String[] args) {
		
		System.out.print("Enter number to test: ");
		Scanner input = new Scanner(System.in);
		String c = input.nextLine();
		int k = hardness(c);
		System.out.println("Digital hardness: "+k);
		
		
	}
	
	public static int hardness(String number) {
		int i;
		int hardness = 0;
		//while loop with right and left
		for(i=0; i<number.length()/2;i++) {
			 if ( (number.charAt(i) =='1') && (number.charAt(number.length()-1-i) =='1') ) {
				 if(i==number.length()-1-i) {
					 hardness++;
				 } else {
					 hardness = hardness + 2;
				 }
			} else {
				break;
			}
			
		}
		return hardness;
	}
	
}
