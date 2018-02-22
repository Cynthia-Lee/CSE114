//Name: Cynthia Lee
//ID: 111737790

import java.util.Scanner;
public class rollingDice {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter value [(number of dice rolled)d(how many sides on each dice)]: ");
		String s = input.next();
		System.out.println(rollDice(s));
		
	}
	
	public static int rollDice(String r) {
		int index = r.indexOf('d'); //index of d
		String s1 = r.substring(0,index); //substring up to index (number of die)
		String s2 = r.substring(index+1); //substring from d+1 to end of string (type of die, how many sides)
		int num = Integer.parseInt(s1); //integer value of s1
		int size = Integer.parseInt(s2); //integer value of s2
		int roll = 0;
		for(int p = 1; p<=num; p++) {
			int val = (int)(Math.random()*(size-1)+1);
			roll = roll+val;
		}
		
		return roll;
	}
	
}
