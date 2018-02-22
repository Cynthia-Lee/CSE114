import java.util.Scanner;
import java.util.Arrays;
import java.util.Arrays;
public class markovMatrixAndMagicSquare {
	public static void main (String[] args) {
	/*	double[][] p = { {0.15,0.875,0.375}, 
						 {0.55,0.005,0.225}, 
						 {0.30, 0.12, 0.4} };
		System.out.println( isMarkovMatrix(p) ); */ 
		double[][] matrix = new double[3][3];
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a 3x3 matrix, row by row:");
		for(int row = 0; row<3; row++) {
			for(int col = 0; col<3; col++) {
				matrix[row][col] = input.nextDouble();
			}
			
		}
		if(isMarkovMatrix(matrix)==true) {
			System.out.println("This is a positive Markov matrix");
		} else {
			System.out.println("This is not a positive Markov matrix");			
		}
		
   /*	int[][] magic = new int[5][5];
		magic = createSquare(5); 
		for(int i = 0; i<5; i++) {
			for(int j = 0; j<5; j++) {
				System.out.print(magic[i][j]+" ");
			}
			System.out.println();
		} */
		int d;
		System.out.print("Enter a size for the magic square (Must be a odd positive integer): ");
		d = input.nextInt();
		int[][] magic = new int[d][d];
		magic = createSquare(d);
		for(int i = 0; i<d; i++) {
			for(int j = 0; j<d; j++) {
				System.out.print(magic[i][j]+"\t");
			}
			System.out.println();
		} 
	}
	
	public static boolean isMarkovMatrix(double[][] m) {
		double sum = 0.0;
		boolean check = true;
		for(int c = 0; c < 3; c++) { //3x3 matrix
			sum = 0;
			for(int r = 0; r < m.length; r++) {
				sum = sum+m[r][c];	
			}	
			
			if(sum!=1) {
				check = false;
				break;
			} 
		} 
		return check;
	}
	
	public static int[][] createSquare(int size) {
		int[][] square = new int[size][size];
		square[0][size/2] = 1;
		int num = 2;
		int r = 0;
		int c = size/2;
		int tempR; int tempC;
		while(num<=(size*size)) {
			tempR = r;
			tempC = c;
			//System.out.println(num);
			r = r-1;
			c = c-1;
			//System.out.println("outside" + r +" " +c);
			if( (r)<0 ) { //if space doesn't exist, loop around (square[size-1][size-1])
				r = size-1;
			} 
			if ( (c)<0 ){
				c = size-1;
			} 
			//System.out.print(num);
			//System.out.println("outside" + r +" " +c);
			if(square[r][c]==0) {
				square[r][c] = num;
			} else { //if occupied, move it 1 row lower than the starting position
				//go back to the number's position before
				//r = r+1;
				//c = c+1;
				r = tempR;
				c = tempC;
				//place the number under it
				r = r+1;
				//System.out.println(num+"inside" + r +" " +c);
				square[r][c]=num;
			} 
			num++;
		}
		
		return square;
	}
	
	
}
