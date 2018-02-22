public class FasterValueCounter {
	public static void main (String[] args) {
		int [] v = {23,12,14,12,5};
		valueCounter(v);
	
	}
	
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
