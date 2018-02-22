import java.util.Scanner;
public class BinaryMethods {
	public static void main(String[] args) {
		String first;
		String second;
		int decimal;
		int length;
		
		Scanner input = new Scanner(System.in);
		System.out.print("(Enter two binary strings to be added) Enter the first string: ");
		first = input.nextLine();
		System.out.print("Enter the next string: ");
		second = input.nextLine();
		System.out.println("The sum of these strings is: " + addBinary(first,second));
		System.out.print("Enter a decimal (base 10) integer value: ");
		decimal = input.nextInt();
		System.out.print("Enter the desired length in bits: ");
		length = input.nextInt();
		System.out.println("The two's complement representation of the original integer value: " + toTwosComplement(decimal,length));
	}
	
	
	public static String pad(String b, int l) {
		int q;
		if (b.length()<l) {
			for (q = b.length(); q<l; q++) {
				b = "0"+b;
			}
		}
		return b;
	}
	
	
	public static String addBinary(String f, String s) { 
		int carry_bit = 0;
		String sum = "";
		int j;
			if (f.length() < s.length()) {
				f = pad(f,s.length());
			} else if (s.length() < f.length()) {
				s = pad(s,f.length());
			}
		
		for (j = f.length()-1; j>=0; j--) {
			if (carry_bit + (Integer.parseInt(f.substring(j,j+1))) + (Integer.parseInt(s.substring(j,j+1))) == 0 ) {
				sum = "0"+sum;
				carry_bit = 0;
			} else if (carry_bit + (Integer.parseInt(f.substring(j,j+1))) + (Integer.parseInt(s.substring(j,j+1))) == 1 ) {
				sum = "1" + sum;
				carry_bit = 0;
			} else if (carry_bit + (Integer.parseInt(f.substring(j,j+1))) + (Integer.parseInt(s.substring(j,j+1))) == 2 ) {
				sum = "0" + sum;
				carry_bit = 1;
			} else { //a sum of 3 means write down 1 and carry the other 1
				sum = "1" + sum;
				carry_bit = 1;
			}
		}
			if (carry_bit==1) { //Deal with any left over carry bit at the end
				sum = "1" + sum;
			}
		return sum;
	}
		
	
	public static String toTwosComplement(int d, int z) {
		String value = "";
		int rem;
		int b;
		int temp = d;
		
		if (temp>=0) { //integer is positive or 0
			
			while (d>0) { //converts to positive binary
				rem = d%2;
				d = d/2;
				value = rem + value;
			}
			if (value.length()<z) { //adds 0 for length
				value = pad(value,z);
			}
		
		} else { //integer is negative 
			d = d*(-1);
			while (d>0) { //converts to positive binary
				rem = d%2;
				d = d/2;
				value = rem + value;
			}
			
			if (value.length()<z) { //adds 0 for length
				value = pad(value,z);
			}

			//Negate the binary:
			//invert the string
			String nValue = "";
			for (b = value.length()-1; b>=0; b--) {
				if (value.charAt(b)=='0') {
					nValue = "1" + nValue;
				} else {
					nValue = "0" + nValue;
				}	
			} 
			
			//add 1
			value = addBinary(nValue,"1"); 
			
			//if the negated binary string is greater than the specified length (due to an extra carry bit),
			//remove the leading character bit
			String v = "";
			if (value.length()>z) {
				for (int k = 0; k<z; k++) {
					v = value.charAt(value.length()-1-k) + v;
				}
				value = v;
			} 
		} 
	return value;
	}	
		
		
}
	
