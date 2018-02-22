
public class Rectangle {
	//instance variables
	//defaults
	private double width;
	private double height;
	private String color = "white";
	
	public Rectangle() {
		setWidth(1);
		setHeight(1);
	}
	
	public Rectangle(double width, double height) {
		setWidth(width);
		setHeight(height);
		//default color 
	}
	
	//getter methods
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public String getColor() {
		return color;
	}
	
	//setter methods
	public void setWidth(double width) {
		this.width = width;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getArea() {
		return (width*height);
	}
	
	public double getPerimeter() {
		return ((width*2) + (height*2));
	}
}
