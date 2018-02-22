//all sides have the same length and all angles has the same degree
public class RegularPolygon {
	//instance variables
	private int n; //defines number of sides in a polygon
	private double side; //stores length of the side
	
	//constructors
	public RegularPolygon() { //creates regular polygon with default values
		setNum(3);//n = 3;
		setSide(1);//side = 1;
	}
	//constructor
	public RegularPolygon(int n, double side) {
		setNum(n);
		setSide(side);
	}
	
	//getter methods
	public int getNum() {
		return n;
	}
	public double getSide() {
		return side;
	}
	
	//setter methods
	public void setNum(int n) {
		this.n = n;
	}
	public void setSide(double side) {
		this.side = side;
	}
	
	//perimeter method
	public double getPerimeter() {
		return (n*side);
	}
	
}
