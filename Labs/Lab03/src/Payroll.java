import java.util.Scanner;
public class Payroll {
	public static void main (String[] args){
		String name;
		double hoursAWeek;
		double hourPayRate;
		double fedTaxRate;
		double stateTaxRate;
		double grossPay;
		double totalDeduction;
		System.out.print("Enter employee's name: ");
		Scanner input = new Scanner(System.in);
		name = input.nextLine();
		System.out.print("Enter number of hours worked in a week: ");		
		hoursAWeek = input.nextDouble();
		System.out.print("Enter hourly pay rate: ");
		hourPayRate = input.nextDouble();
		System.out.print("Enter federal tax withholding rate: ");
		fedTaxRate = input.nextDouble();
		System.out.print("Enter state tax withholding rate: ");
		stateTaxRate = input.nextDouble();
		System.out.println("");
		System.out.println("Employee Name: "+name);
		System.out.println("Hours worked: "+hoursAWeek);
		System.out.println("Pay Rate: $"+hourPayRate);
		grossPay = (hoursAWeek*hourPayRate);
		System.out.println("Gross Pay: $"+ grossPay);
		System.out.println("");
		System.out.println("Deductions:");
		System.out.println("");		
		double fedWith = (grossPay*fedTaxRate)-((grossPay*fedTaxRate)%0.01);
		double stateWith = (grossPay*stateTaxRate)-((grossPay*stateTaxRate)%0.01);

		System.out.format("%s %.1f %s %.1f\n","Federal Witholding (", fedTaxRate*100, "%): $", fedWith);
		System.out.println("State Witholding ("+stateTaxRate*100 + "%): $"+stateWith);
		
		System.out.println("");
		
		totalDeduction = (fedWith+stateWith);
		System.out.println("Total Deduction: $"+ totalDeduction);
		
		System.out.println("");

		System.out.println("Net Pay: $"+ (grossPay-totalDeduction));
	}
}
