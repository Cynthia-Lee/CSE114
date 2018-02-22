
public class MainRegularPolygon {
	public static void main (String[] args) {
		RegularPolygon first = new RegularPolygon(5, 10);
		RegularPolygon second = new RegularPolygon(12, 14);
		System.out.println("The first polygon has " + first.getNum() + " sides length of " + first.getSide() );
		System.out.println("The perimeter of the first polygon is " + first.getPerimeter());
		
		System.out.println("The second polygon has " + second.getNum()+ " sides length of " +second.getSide() );
		System.out.println("The perimeter of the second polygon is " + second.getPerimeter() );
		
	}

}
