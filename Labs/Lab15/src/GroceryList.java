
public class GroceryList {
	//contain an array of GroceryItem objects
	private GroceryItem[] list;
	//variable that tracks the number of items on the list
	private int numItems = 0;
	
	public GroceryList() { //creates new GroceryList
		list = new GroceryItem[10];
	}
	
	
	public void add(GroceryItem i) { //adds if list has fewer than 10 items
		if(numItems<10) { //if it is empty, add the item
			list[numItems] = i;
			numItems++;
		}
	}
	
	public double getTotalCost() {
		double sum = 0;
		for(int r = 0; r<numItems; r++) {
			sum = sum + list[r].getCost();
		}
		return sum;
	}
}

	
	