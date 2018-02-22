
public class GroceryItem {
	private String name = "";
	private int quantity = 0;
	private double price = 0.0;
	
	public GroceryItem(String n, int q, double p) {
		name = n;
		quantity = q;
		price = p;
	}
	
	public double getCost() { //total cost
		return (quantity*price);
	}
	
	public void setQuantity(int q) {
		quantity = q;
	}
	
}
