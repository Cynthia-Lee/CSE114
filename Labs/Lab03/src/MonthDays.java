import java.util.Scanner;
public class MonthDays {
	public static void main (String[] args) {
		int monthNum;
		int year;	
		String monthS = "";
		boolean isLeapYear;
		int days = 0;
		System.out.print("Please enter month (1-12): ");
		Scanner input = new Scanner(System.in);
		monthNum = input.nextInt();
		System.out.print("Please enter the year: ");
		year = input.nextInt();
		
		if (year%4!=0) {
			isLeapYear=false; //common
		} else if (year%100!=0) {
			isLeapYear=true; 
		} else if (year%400!=0) {
			isLeapYear=false; //common
		} else {
			isLeapYear=true;
		}
		
		switch (monthNum) {
			case 1: monthS = "January";
			days = 31;
			break;
			case 2: monthS = "February";
			if (isLeapYear==true) {
				days = 29;
			} else {
				days = 28;
			}
			break;
			case 3: monthS = "March";
			days = 31;
			break;
			case 4: monthS = "April";
			days = 30;
			break;
			case 5: monthS =  "May";
			days = 31;
			break;
			case 6: monthS = "June";
			days = 30;
			break;
			case 7: monthS =  "July";
			days = 31;
			break;
			case 8: monthS =  "August";
			days = 31;
			break;
			case 9: monthS =  "September";
			days = 30;
			break;
			case 10: monthS =  "October";
			days = 31;
			break;
			case 11: monthS =  "November";
			days = 30;
			break;
			case 12: monthS =  "December";
			days = 31;
			break;
		}
				
			System.out.println(monthS + " " + year + " has " + days + " days.");

		
	}
}
