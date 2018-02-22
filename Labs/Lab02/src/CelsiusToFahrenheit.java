import java.util.Scanner;
public class CelsiusToFahrenheit {
	public static void main (String[] args) {
		double celsius;
		double fahrenheit;
		System.out.print("Enter a temperature in Celsius : ");
		Scanner input = new Scanner(System.in);
		celsius = input.nextDouble();
		fahrenheit = (9.0/5) * celsius + 32;
		System.out.print(celsius + " degrees in Celsius is " + fahrenheit + " degrees in Fahrenheit.");
	}
	
}
