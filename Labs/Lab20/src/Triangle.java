import java.util.Scanner;
public class Triangle {
	private double s1;
	private double s2;
	private double s3;
	
	public Triangle(double f, double s, double t) throws IllegalTriangleException{
		s1 = f;
		s2 = s;
		s3 = t;
		if(s1+s2>s3 && s2+s3>s1 && s1+s3>s2) {	//sum of two sides must be greater than the remaining side
			//no problem
		} else {
			throw new IllegalTriangleException();
		}
	}
	
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		double side1; double side2; double side3;
		System.out.println("Create a triangle.");
		System.out.print("Enter value for side 1: ");
		side1 = input.nextDouble();
		System.out.print("Enter value for side 2: ");
		side2 = input.nextDouble();
		System.out.print("Enter value for side 3: ");
		side3 = input.nextDouble();
		try {
		Triangle tri = new Triangle(side1,side2,side3);
		System.out.println("Triangle successfully created.");
		} catch (IllegalTriangleException ex) {
			System.out.println("Triangle was not created. Error with value of sides.");			
		}
	}
}
