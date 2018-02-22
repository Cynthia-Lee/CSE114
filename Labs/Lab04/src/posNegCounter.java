import java.util.Scanner;
public class posNegCounter {
	public static void main (String[] args) {
		int sum = 0;
		int val;
		int pos = 0;
		int neg = 0;
		double average;
		
		do {
		System.out.print("Please enter an integer(0 to quit): ");
		Scanner input = new Scanner(System.in);
		val = input.nextInt();
				
			if (val<0) { //negative
				neg++;
			} else if (val!=0) {	//positive
				pos++;
			}
			
			sum = sum + val;
			
		} while (val!=0);
		
		average = sum/(double)(pos+neg);
		System.out.println("\nPositive integers entered: "+pos);
		System.out.println("Negative integers entered: "+neg);
		System.out.println("Sum: "+sum);
		System.out.println("Average: "+average);		
	
		
	}
}
