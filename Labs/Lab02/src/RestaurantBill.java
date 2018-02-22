import java.util.Scanner;
public class RestaurantBill {
	public static void main (String[] args){
		double subtotal;
		double tip;
		double totalbill;
		System.out.print("Please enter the subtotal: ");
		Scanner input = new Scanner(System.in);
		subtotal = input.nextDouble();
		if(subtotal<=30) {
			tip = 5;
		} else {
			tip = subtotal*0.15;
		}
		totalbill = subtotal+tip;
		System.out.println("The gratuity is $" + tip + " and the total bill is $" + totalbill);
		
	}
}
