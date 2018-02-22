import java.util.Arrays;
public class bubbleSortandValueCounter {
	public static void main (String[] args) {
		double[] i = {6.0,4.4,1.9,2.9,3.4,2.9,3.5};
		bubbleSort(i);
		System.out.println();
		int[] v = new int[(int)((Math.random()*10)+1)];
		for (int u = 0; u < v.length; u++) {
			v[u] = (int)(Math.random()*(100+1));
		}
		System.out.print(Arrays.toString(v));
		System.out.println(); 
		//int [] v = {23,12,14,12,5};
		valueCounter(v);
	
	}
	
	public static void bubbleSort (double[] list) { //increasing order (small->large)
		boolean changed = true;
		double temp;
		do {
			for (int p = 0; p < list.length; p++) { //prints out array
				System.out.print(list[p]+" ");
				}	
				System.out.println();
			changed = false;
			for (int j = 0; j < list.length-1; j++) { //sorts out the highest first
				if (list[j]>list[j+1]) {
					temp = list[j]; //code to swap list[j] with list[j+1]
					list[j] = list[j+1];
					list[j+1] = temp;
					changed = true;
				}
			}
			
		} while (changed);
	} 
	
/*	public static void valueCounter (int[] values) {

		Arrays.sort(values);
		int move = 0;
		int count = 0;
		int place = 0;
		while(place<values.length) {
			for(int j= 0; j< values.length; j++) {
				if(values[place]==values[j]) {
					count++;
					move++;
				}
			}
			System.out.println(values[place]+ " occurs "+count+" time(s).");
			count = 0;
			place = place+move;
			move = 0;
		}
	} 
	*/
	
	public static void valueCounter (int[] values) { //two for loops, not nested
		int[] n = new int[101];

		for (int j = 0; j < values.length; j++) {
			n[values[j]]+=1;
		}
		for(int k = 0; k < n.length; k++) {
			if (n[k]!=0) {
				System.out.println(k+" occurs "+ n[k]+ " time(s).");
			}
		}
		
		
		}
	
}
