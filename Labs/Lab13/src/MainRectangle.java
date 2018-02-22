
public class MainRectangle {
	public static void main (String[] args) {
		Rectangle first = new Rectangle(4,40);
		Rectangle second = new Rectangle(3.5,35.9);
		first.setColor("red");
		second.setColor("red");
		System.out.println("First Rectangle: width = " + first.getWidth() + ", height = " + first.getHeight() + ", color = " + first.getColor() );
		System.out.println("First Rectangle: area = " + first.getArea() + ", perimeter = " + first.getPerimeter() );
		System.out.println("Second Rectangle: width = " + second.getWidth() + ", height = " + second.getHeight() + ", color = " + second.getColor() );
		System.out.println("Second Rectangle: area = " + second.getArea() + ", perimeter = " + second.getPerimeter());
		
	}
}
