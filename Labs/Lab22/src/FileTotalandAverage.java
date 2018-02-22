import java.io.*;
import java.util.Scanner;

public class FileTotalandAverage {
	public static void main (String[] args ) {
		File f = new File("test.txt");
		try {
			Scanner input = new Scanner(f);
			int total = 0;
			double average = 0;
			int count = 0;
			while(input.hasNextInt()) {
				total = total +input.nextInt();
				count++;
			}
			average = (double)total/count;
			System.out.println("The total is: " + total);
			System.out.println("The average is: " + average);
			input.close();
			
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		

		
	}
}
