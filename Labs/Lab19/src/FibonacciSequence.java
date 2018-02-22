import java.util.ArrayList;
import java.util.Scanner;
public class FibonacciSequence {
	public static void main (String[] args) {
		ArrayList<Integer> fs;
		int n;
		int p;
		int index = 2;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of terms in the sequence:");
		n = input.nextInt();
		System.out.print("Enter the number of terms to print (will print the last terms):");
		p = input.nextInt();
		fs = new ArrayList<>(n);
		fs.add(0,0);
		fs.add(1,1);
		while(fs.size()<n) {
			fs.add(fs.get(index-1)+fs.get(index-2));
			index++;
		}
		String res = "";
		for(int k = 0; k<p; k++) {
			res = fs.get(fs.size()-1-k)+" "+res;
		}
		System.out.println(res);
		
		
	}
	
	
}
