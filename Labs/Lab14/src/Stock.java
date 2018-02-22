
public class Stock {
	private String symbol;
	private String name;
	private double previousClosingPrice;
	private double currentPrice;
	
	public Stock(String s, String n) {
		symbol = s;
		name = n;
	}
	
	public String getSymbol() {
		return symbol;
	}
/*	public void setSymbol(String sy) {
		symbol = sy;
	} */
	
	public String getName() {
		return name;
	}
/*	public void setName(String nam) {
		name = nam;
	} */
	
	public double getPreviousClosingPrice() {
		return previousClosingPrice;
	}
	public void setPreviousClosingPrice(double pp) {
		previousClosingPrice = pp;
	}
	
	public double getCurrentPrice() {
		return currentPrice; 
	}
	public void setCurrentPrice(double cp) {
		currentPrice = cp;
	}
	
	public double changePercent() {
		double percent = ( (currentPrice - previousClosingPrice)/previousClosingPrice )*100; 
		//percent change from previousClosingPrice to currentPrice
		return percent;
	}
	
}
