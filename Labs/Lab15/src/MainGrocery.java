
public class MainGrocery {
	public static void main (String[] args) {
		GroceryList list = new GroceryList();
		list.add(new GroceryItem("can of soup",3,1.5));
		list.add(new GroceryItem("gallon of milk",1,3.29));
		list.add(new GroceryItem("dozen eggs",2,3));
		list.add(new GroceryItem("yogurt",6,2));
		System.out.println("The total cost of items is $"+list.getTotalCost());
		
	}
}
