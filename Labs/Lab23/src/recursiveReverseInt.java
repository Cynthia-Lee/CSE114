import java.util.Scanner;
public class recursiveReverseInt {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an integer to be displayed in reverse: ");
		int v = input.nextInt();
		reverseDisplay(v);
	
	}
	
	public static void reverseDisplay(int value) {
		if(value>0) {
			System.out.print(value%10); //last number
			value = value/10; //everything but the last number
			reverseDisplay(value);
		}
	}
	
}
