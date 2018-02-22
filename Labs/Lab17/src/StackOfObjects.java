import java.util.ArrayList;
public class StackOfObjects {
	private Object[] arr;
	private int len;
	private int size; 
	
	public StackOfObjects() {
		len = 2;
		arr = new Object[len];
		size = 0;
	}
	public StackOfObjects(int le) {
		len = le;
		arr = new Object[len];
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public void push(Object o) {
		if(size==arr.length) {
			expand(); //resize array and then add value
		} 
		arr[size] = o;
		size++;
		
	}
	
	public Object pop() {
		Object temp = arr[size-1];
		arr[size-1]=null;
		size--;
		return temp;
	}
	
	private void expand() {
		Object[] n = new Object[len*2];
		for(int i = 0; i<arr.length; i++) {
			n[i] = arr[i];
		}
		arr = n; //assigns new (larger) array to the class instance variable
		
	}
		
}
