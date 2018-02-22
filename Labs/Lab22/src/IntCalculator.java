import java.util.Scanner;
import java.io.*;

public class IntCalculator {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("(Enter to opperands and the operation to be performed, seperated by whitespace)");
		System.out.println("Please enter a calculation to perform: ");
		int f = input.nextInt();
		String op = input.next();
		int s = input.nextInt();
		//types of errors: ArithmeticException
		try  { //add,subtract,multiply,divide,modulus
			int res = 0;
			if(op.equals("+")) { res = f+s;}
			else if(op.equals("-")) { res = f-s;}
			else if(op.equals("*")) { res = f*s;}
			else if(op.equals("/")) { res = f/s;}
			else if(op.equals("%")) { res = f%s;}
			else {
				throw new Exception("wrong operator");
			}
			
			System.out.println(res);
		} catch (ArithmeticException ex) {
			System.out.println("Divisioin by zero is illegal");
		} catch (Exception ex) {
			System.out.println(op + " is an invalid operator");
		}
		
		
		
		
		
		
		
	}
}
