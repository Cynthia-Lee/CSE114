//Name: Cynthia Lee
//ID: 111737790

import java.util.Scanner;
import java.util.Arrays;
public class CountSortArray {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		int min; 
		int max;
		System.out.print("Enter how many numbers are in the array: ");
		n = input.nextInt();
		int[] arr = new int[n];
		System.out.print("Enter the minimum value of the array: ");
		min = input.nextInt();
		System.out.print("Enter the maximum value of the array: ");
		max = input.nextInt();
		for(int i = 0; i<n; i++) {
			arr[i] = (int)(Math.random()*(max-min+1)+min);
		}
		System.out.print("The unsorted array is: ");
		System.out.println(Arrays.toString(arr));
		int[] sorted = countingSort(arr, min, max);
		System.out.print("The sorted array is: ");
		System.out.println(Arrays.toString(sorted));
		
		
	}
	
	public static int[] countingSort(int[] arr, int min, int max) {
		int[] count = new int[max-min+1]; 
		for(int k = 0; k<arr.length; k++) {
			count[arr[k]-min]++; //use min value to offset
		}
		
		int[] sort = new int[arr.length];
		int st = 0;
		for(int k = 0; k<count.length; k++) {
			for(int a = 0; a<count[k]; a++) {
				if(count[k]!=0) {
					sort[st] = min+k;
					st++;
				}
				
			}
		}
		
		return sort;
		
	}
	
}
