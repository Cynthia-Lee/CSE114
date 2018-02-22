import java.util.Scanner;
public class RoundDouble {
	public static void main (String[] arg) {
		double r;
		int n;
		Scanner input = new Scanner(System.in);
		System.out.print("Type out a decimal number: ");
		double d = input.nextDouble();
		r = d%(int)d; 
		if(d>1) {
			if(r>=.5) {
				n=((int)d)+1;
			} else {
				n=(int)d;
			}
		} else {
			if(d>=.5) {
				n=1;
			} else {
				n=0;
			}
		}
		System.out.println("Your decimal rounds to: "+n);
		
	}

}
