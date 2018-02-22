import java.util.Scanner;
public class MainComplex { //test program
	public static void main (String[] args) {
		//prompts user to enter two complex numbers
		double fa; double fb; double sa; double sb;
		String first = "";
		String second = "";
		System.out.println("Enter two complex numbers. Use a+bi form. The first complex number is: ");
		Scanner input = new Scanner(System.in);
		first = input.next();
		fa = Double.parseDouble(first.substring(0,first.indexOf('+')));
		fb = Double.parseDouble(first.substring(first.indexOf('+')+1,first.indexOf('i')));
		System.out.println("Enter the second complex number: ");
		input.nextLine();
		second = input.next();
		sa = Double.parseDouble(second.substring(0,second.indexOf('+')));
		sb = Double.parseDouble(second.substring(second.indexOf('+')+1,second.indexOf('i')));
		//displays addition,subtraction,multiplication,division
		Complex one = new Complex(fa, fb);
		Complex two = new Complex(sa, sb);
		System.out.println("The result of addition is " +one.add(two));
		System.out.println("The result of subtraction is " +one.subtract(two));
		System.out.println("The result of multiplication is " +one.multiply(two));
		System.out.println("The result of division is " +one.divide(two));
	}
}
