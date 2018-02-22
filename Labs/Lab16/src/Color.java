
public class Color {
	private int red; //0-255
	private int green;
	private int blue;
	private String colorName;
	
	public Color(int r, int g, int b) {
		colorName = null;
		red = r;
		green = g;
		blue = b;
	}
	
	public Color(int r, int g, int b, String name) {
		red = r;
		green = g;
		blue = b;
		colorName = name;
	}
	
	public int getRed() {
		return red;
	}
	public int getGreen() {
		return green;
	}
	public int getBlue() {
		return blue;
	}
	public String getColorName() {
		return colorName;
	}
	
	
}
