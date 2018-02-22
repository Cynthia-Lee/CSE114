
public class MainStock {
	public static void main (String[] args) {
		Stock stock1 = new Stock("GOOG","Google Inc");
		stock1.setPreviousClosingPrice(100);
		stock1.setCurrentPrice(90);
		System.out.println(stock1.changePercent());
	}
}
