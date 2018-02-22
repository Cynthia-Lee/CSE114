import java.util.Scanner;
import java.util.*;
public class HextoDec {
	public static void main (String[] args) {
		System.out.print("Enter a Hexideciaml String to be converted to Decimal: ");
		Scanner input = new Scanner(System.in);
		String s = input.next();
		try {
			System.out.println( parseHex(s) );
		} catch (HexFormatException ex) {
			System.out.println("Invalid Hexidecial String.");
		}
	
	}
	
	public static int parseHex(String hex) throws HexFormatException{
		int res = 0;
		double base = 16;
		double power = 0;
		int num = 0;
		if(hex.contains("G")||hex.contains("H")||hex.contains("I")||hex.contains("J")||
			hex.contains("K")||hex.contains("L")||hex.contains("M")||hex.contains("N")
			||hex.contains("O")||hex.contains("P")||hex.contains("Q")||hex.contains("R")
			||hex.contains("S")||hex.contains("T")||hex.contains("U")||hex.contains("V")
			||hex.contains("W")||hex.contains("X")||hex.contains("Y")||hex.contains("Z")) {
			
			throw new HexFormatException();
		} else {
			for(int i = hex.length()-1; i>=0; i--) { //read each letter from the last index
				switch ((hex.charAt(i)+"")) {
					case "A": num = 10; break;
					case "B": num = 11; break;
					case "C": num = 12; break;
					case "D": num = 13; break;
					case "E": num = 14; break;
					case "F": num = 15; break;
					default: num = Integer.parseInt(hex.charAt(i)+"");		
				}
				res = (int) ( res + (num*Math.pow(base,power)) ); //pow gives double
				power++;
			}	
		}
		return res;
	}
	
}
