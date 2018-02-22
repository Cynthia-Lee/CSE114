import java.util.Scanner;
public class matrixCoins {
	public static void main (String[] args) {
		int[][] result = new int[3][3];
		Scanner input = new Scanner(System.in);
		int num;
		int rem;
		
		System.out.print("Enter a number between 0 and 511: ");
		num = input.nextInt();
		
		while(num>0) {
			for(int r = 2; r>=0; r--) {
				for(int c = 2; c>=0; c--) {
					rem = num%2;
					num = num/2;
					result[r][c] = rem;
					
				}
			}
		}
		
		for(int r = 0; r<3; r++) {
			for(int c = 0; c<3; c++) {
				if(result[r][c]==0) {
					System.out.print("H ");
				} else {
					System.out.print("T ");
				}
			}
			System.out.println();
		}
		
		
		
	}
}
