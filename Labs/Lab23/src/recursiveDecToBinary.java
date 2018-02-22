import java.util.Scanner;
public class recursiveDecToBinary {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a decimal value: ");
		int n = input.nextInt();
		System.out.println("The binary value is: " + dec2Bin(n));
		
	}
	
	public static String dec2Bin(int value) {
		/*String res = "";
		int base = 2;
		if(value>0) {
			int rem = value%base;
			value = value/base;
			res = rem + res;
			dec2Bin(value);
		}
		return res;
	}*/
		int base = 2;
		//int rem = value%base; //gets the remainder first. value=3 3%2 R1 -> value=1 1%2 R1
		if(value>0) {  //value=3 -> value=1
			return dec2Bin(value/base) + (value%base); //new(value=1)[1]+1
			//value = value/base;	//value=1 -> value=0(1/2)
		} else { 
			return ""; 
		}
	}
		
	
}
