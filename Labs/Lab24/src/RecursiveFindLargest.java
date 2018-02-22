
public class RecursiveFindLargest {
	public static void main (String[] args) {
		int[] list = {3,2,1,4,2,5,7,6};
		System.out.println(findLargest(list,0));
		
	}
	
	
	public static int max(int a, int b) {
		if(a > b) { return a; }
		else { return b; }
	}
	
	public static int findLargest(int [] list, int currentIndex) { //start at 0
		if(currentIndex<list.length-1) { //cycle through the array without the last number
			return max(list[currentIndex], findLargest(list,currentIndex+1));	
		} else { //last number. returns itself
			return list[currentIndex];
		}
		
	}

}
