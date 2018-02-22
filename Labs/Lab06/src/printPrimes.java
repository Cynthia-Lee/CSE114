//import java.util.Scanner;
public class printPrimes {
	public static void main(String[] args) {
		int i = 2;
		int count = 0;
		// Scanner input = new Scanner(System.in);
		// i = input.nextInt();
		while (count < 1000) { // 1000 prime numbers
			if (isPrime(i)) {
				System.out.print(i + "\t");
				count++; // counts how many prime numbers

				if (count % 10 == 0) {
					System.out.println();
				}
			}

			i++;
		}
	}

	public static boolean isPrime(int num) {
		int i;
		boolean numprime = true;
		if (num > 1) {
			for (i = 2; i < num; i++) { // for the value of 2, it doesn't enter the loop -> default = false;
				if (num % i == 0) {
					numprime = false;
					break; // once it finds one factor, it breaks out of the loop
				}
			}
			return numprime;
		} else {
			return false;
		}
	}

}
