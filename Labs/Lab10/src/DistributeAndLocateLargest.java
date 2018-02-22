import java.util.Scanner;
import java.util.Arrays;
public class DistributeAndLocateLargest {
	public static void main (String[] args) {
	/*	int[] v  = {3,1,6,2,4,1,5};
		distribute(v,2);
		System.out.println(Arrays.toString(v));
		*/
		int indexRead;
		int numRows; 
		int numCols;
		
		int[] r = new int[15];
		for (int f = 0; f < r.length; f++) {
			r[f] = 1+(int)(Math.random()*(12+1)); //inclusive numbers 1-13
		}
		System.out.println(Arrays.toString(r));
		System.out.print("Enter an index to distribute: ");
		Scanner input = new Scanner(System.in);
		indexRead = input.nextInt();
		distribute(r,indexRead);
		System.out.println(Arrays.toString(r));
	
		System.out.println();
		System.out.print("Enter the number of rows: ");
		numRows = input.nextInt();
		System.out.print("Enter the number of columns: ");
		numCols = input.nextInt();
		double[][] val = new double[numRows][numCols];
		System.out.println("Enter the array values, one row at a time: ");
		for (int rr = 0; rr < numRows; rr++) {
			for (int cc = 0; cc < numCols; cc++) {
				val[rr][cc] = input.nextDouble();
			}
		}
		int [] l = new int[2];
		l = locateLargest(val);
		System.out.println("The largest element is at " + Arrays.toString(l));
		
		
	}
	
	public static void distribute(int[] values, int start_index) {
	/*	int count = values[start_index]; //how many times 1 is added to the next indexes
		values[start_index] = 0;
		if (start_index+count < values.length) {
			for (int j = start_index+1; j<=count+start_index; j++) {
				values[j] = values[j]+1;
			}
		} else { //would have to loop around
			for (int j = start_index+1; j<values.length; j++) {
				values[j] = values[j]+1;
			}
			for (int j = 0; j<count-((values.length-1)-(start_index)); j++) {
				values[j] = values[j]+1;
			}
		} */
		int count = values[start_index]; //how many times 1 is added to the next indexes
		values[start_index] = 0;
		int k = 0;
			for (int j = start_index+1; j<=count+start_index; j++) {
				if (j<values.length) {
				values[j] = values[j]+1;
				} else {
					//for (int k = 0; k<(count-((values.length-1)-(start_index))); k++) {
					values[k] = values[k]+1;
					k++;
					//}
					//break;
				}
			}
	}
	
	
	
	public static int [] locateLargest(double[][] a) {
		double max = a[0][0];
		int largeR = 0;
		int largeC = 0;
		for (int row = 0; row<a.length; row++ ) { //rows
			for (int col = 0; col<a[row].length; col++) {
				if(max < a[row][col]) {
					max = a[row][col];
					largeR = row;
					largeC = col;
				}
			}
		}
	int[] result = {largeR,largeC};
	return result;
	}
	
}
