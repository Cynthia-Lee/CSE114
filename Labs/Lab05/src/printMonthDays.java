import java.util.Scanner;
public class printMonthDays {
	public static void main (String[] args) {
		int days;
		int offset;
		int i;
		//int count = 0;
		
		System.out.print("Enter the number of days in the month: ");
		Scanner input = new Scanner(System.in);
		days = input.nextInt();
		System.out.print("Enter the offset value (1-6): ");
		offset = input.nextInt();
		
		
		for(i = 0; i<offset; i++ ) { //offset
			System.out.print("   ");
			//count++;
		}
		
		
		for(i =1; i<days+1; i++) { //days
			if(i<10) {
				System.out.print(" " +i+" ");
			} else {
				System.out.print(i+" ");
			}
			//count++;
			if ( (i+offset) %7==0) {
				System.out.println();
				//count = 0;
			}
			
		}
		
		
		
		
	}

}
