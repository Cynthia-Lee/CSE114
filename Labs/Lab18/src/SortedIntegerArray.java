
public class SortedIntegerArray {
	private int[] arr;
	private int size = 0;
	
	public SortedIntegerArray(int i) {
		arr = new int[i];
	}
	
	public int size() {
		return size;
	}
	public int get(int index) {
		if(index<0 || index>=size) {
			return -1;
		} else {
			return arr[index];
		}
	}
	
	public String toString() {
		String res = "";
		for(int i = 0; i<size; i++) {
			res = res+arr[i]+" ";
		}
		return res;
	}
	
	public void add(int i) {
		if(size==arr.length) {
			System.out.println("Error. Array is full.");
		} else {
			int insert = 0;
			//adds value to the end of the array first
			arr[size] = i;
			size++;
			
			//start to find where to put the value
			if (arr[0]>i) {
				insert = 0;
			} else {
				for(int p = size-1; p>0; p--) {
					if(arr[p]<i) {
						insert = p+1;
						break;
					} 	
				}
			}
			//if the value needs to be inserted between numbers
			for(int k = arr.length-1; k>insert; k--) { //shift values to the right
				arr[k] = arr[k-1]; 
			}
			arr[insert] = i;
			
		}
	}
	
	public void remove(int index) {
		if(index>=0 && index<size) {
			if(index==size-1) {
				//does not need to shift
			} else {	
				for(int k = index; k<arr.length-1; k++) { //shift numbers left
					arr[k] = arr[k+1];
				}
			}
			size--;
		}
	}
	
	//testing the class
	public static void main (String[] args) {
		SortedIntegerArray test = new SortedIntegerArray(5);
		System.out.println("Number of values in the array: " +test.size());
		test.add(2);
		test.add(1);
		test.add(3);
		test.add(4);
		System.out.println(test.toString());
		System.out.println("Number of values in the array: " + test.size());
		test.add(0);
		System.out.println(test.toString());
		System.out.println("Number of values in the array: " + test.size());
		test.remove(2);
		System.out.println(test.toString());
		test.remove(2);
		System.out.println(test.toString());
		System.out.println("The number at index 2 is: " + test.get(2));
		test.add(6);
		System.out.println(test.toString());
		test.add(5);
		System.out.println(test.toString());
	}
	
	
	
	
}


