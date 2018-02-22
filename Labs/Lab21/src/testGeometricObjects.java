
public class testGeometricObjects {
	public static void main (String[] args) {
		GeometricObject[] list = {new Square(), new Triangle(), new Square(), new Square(), new Triangle()};
				//new GeometricObject[5];
		for(int i = 0; i<list.length; i++) {
			if(list[i] instanceof Colorable) {
				((Colorable)list[i]).howToColor();
			} 		
		}
		
		
	}
}
